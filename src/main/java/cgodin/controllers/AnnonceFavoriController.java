package cgodin.controllers;

import cgodin.models.DAO.*;
import cgodin.models.entities.Annonce;
import cgodin.models.entities.Annonce_Favori;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AnnonceFavoriController {
    private final IAnnonce_FavoriDAO annonce_favoriDAO =  new Annonce_FavoriDAO();
    @GetMapping("/addfavorie")
    public void addMessagerie(@RequestParam("id") int AnnonceIDAnnonce, HttpServletRequest request,  HttpServletResponse response ) throws ServletException, IOException {

        int idMembre = (int) request.getSession().getAttribute("idMembre");
        // Afficher l'ID de l'utilisateur de la session dans la console
        System.out.println("Session user ID : " + idMembre);
        Annonce_Favori annonce_favori = new Annonce_Favori();
        annonce_favori.setAnnonceIDAnnonce(AnnonceIDAnnonce);
        annonce_favori.setUtilisateurIDMembre(idMembre);
        annonce_favori.setDateMiseEnFavori(LocalDateTime.now());
        boolean binFav =annonce_favoriDAO.isFavori(AnnonceIDAnnonce,idMembre);
        System.out.println("binFav : " +binFav);

        if (!binFav) {
            annonce_favoriDAO.add(annonce_favori);
            request.setAttribute("message","Annonce mis en favori");
            request.setAttribute("AnnonceIDAnnonce",AnnonceIDAnnonce);
            request.setAttribute("UtilisateurIDMembree",idMembre);
        }
        else{
            annonce_favoriDAO.remove(AnnonceIDAnnonce, idMembre);
            request.setAttribute("message","Annonce récupéré en favori");
            request.setAttribute("AnnonceIDAnnonce",AnnonceIDAnnonce);
            request.setAttribute("UtilisateurIDMembree",idMembre);
        }
        request.getRequestDispatcher("/WEB-INF/successFav.jsp").forward(request, response);

    }

}
