package com.example.projetrobillardmonizhou;

import cgodin.models.DAO.IPhotoDAO;
import cgodin.models.DAO.PhotoDAO;
import cgodin.models.entities.Photo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@WebServlet(name = "FileUploadServlet", urlPatterns = "/uploadFile")
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>File Upload Form</title></head><body>");
        out.println("<form method=\"post\" action=\"uploadFile\" enctype=\"multipart/form-data\">");
        out.println("<input type=\"file\" name=\"file\">");
        out.println("<input type=\"submit\" value=\"Upload\">");
        out.println("</form>");
        out.println("</body></html>");
    }
  /*  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the file part from the request
        Part filePart = request.getPart("file");

        // Get the filename
        String fileName = extractFileName(filePart);

        // Get the path to the "images" directory
        String imagePath = request.getServletContext().getRealPath("/images");

        // Create a Path object for the file
        Path filePath = Paths.get(imagePath, fileName);
        System.out.println("**** filePath : ****");
        System.out.println(filePath);

        String imagePath2 = "C:\\Users\\pierr\\Desktop\\ProjetRobillardMonizHou\\src\\main\\webapp\\images\\"; //path change

        System.out.println("request.getContextPath()  :  "+request.getContextPath());

        Path filePath2 = Paths.get(imagePath2, fileName);
        System.out.println("**** filePath2 : ****");
        System.out.println(filePath2);

        // Check if the file already exists
        *//*if (Files.exists(filePath)) {
            response.sendError(HttpServletResponse.SC_CONFLICT, "File already exists");
            return;
        }*//*

        // Copy the file to the images directories

        try (
                InputStream input = filePart.getInputStream()) {
            Files.copy(input, filePath);

            IPhotoDAO photoDAO = new PhotoDAO();
            Photo photo = new Photo();
            String photoURL = "http://localhost:8080/ProjetRobillardMonizHou_war_exploded/images/"+fileName;
            photo.setPhotoURL(photoURL);
            photoDAO.add(photo);

            System.out.println("**** photoURL : ****");
            System.out.println(photo.getPhotoURL());

            // Reset the input stream to the beginning of the file
            input.reset();
            try (OutputStream output = new FileOutputStream(imagePath2 + filePart.getSubmittedFileName())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }

        }

        // Set the content type and response message
        response.setContentType("text/plain");
        response.getWriter().println("File uploaded successfully!");


        request.setAttribute("message", "File uploaded successfully!");
        request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);

        // Redirect to another URL
        // response.sendRedirect("http://localhost:8080/ProjetRobillardMonizHou_war_exploded/creationAnnonce/creerannonce");

    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the file part from the request
        Part filePart = request.getPart("file");

        // Get the original filename
        String originalFileName = extractFileName(filePart);

        // Get the file extension
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf('.'));

        // Generate a unique filename by appending a timestamp to the original filename (without extension)
        String uniqueFileName = originalFileName.substring(0, originalFileName.lastIndexOf('.')) + "_" + System.currentTimeMillis() + fileExtension;

        // Get the path to the "images" directory
        String imagePath = request.getServletContext().getRealPath("/images");

        // Create a Path object for the file
        Path filePath = Paths.get(imagePath, uniqueFileName);

        // Copy the file to the images directory
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, filePath);

            IPhotoDAO photoDAO = new PhotoDAO();
            Photo photo = new Photo();
            String photoURL = "http://localhost:8080/ProjetRobillardMonizHou_war_exploded/images/" + uniqueFileName;
            photo.setPhotoURL(photoURL);
            photoDAO.add(photo);

            // Reset the input stream to the beginning of the file
            // Copy the file to the second images directory
/*            input.reset();
            String imagePath2 = "C:\\Users\\pierr\\Desktop\\ProjetRobillardMonizHou\\src\\main\\webapp\\images\\"; //path change
            Path filePath2 = Paths.get(imagePath2, uniqueFileName);
            try (OutputStream output = new FileOutputStream(imagePath2 + uniqueFileName)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);*/
        }

        // Set the content type and response message
        response.setContentType("text/plain");
        response.getWriter().println("File uploaded successfully!");

        request.setAttribute("message", "File uploaded successfully!");
        request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);

        // Redirect to another URL
        // response.sendRedirect("http://localhost:8080/ProjetRobillardMonizHou_war_exploded/creationAnnonce/creerannonce");
        //System.out.println(imagePath);
    }

    private String extractFileName(Part part) {
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");

        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}