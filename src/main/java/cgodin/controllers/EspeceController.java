package cgodin.controllers;

import cgodin.models.DAO.EspeceDAO;
import cgodin.models.DAO.IEspeceDAO;
import cgodin.models.entities.Espece;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EspeceController {
    @GetMapping("/test")
    public RedirectView rootRedirect() {
        return new RedirectView("listeEspece");
    }
    @GetMapping("/test2")
    public String rootRedirect2() {
        return  "redirect: listeEspece";
    }
    @RequestMapping(value = "/listeEspece", method = RequestMethod.GET)
    public ModelAndView listeEspece(HttpServletRequest request) {
        // Check if the user is an admin
    /*    boolean isAdmin = false;
        try {
            isAdmin = (boolean) request.getSession().getAttribute("isAdmin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!isAdmin) {
            return new ModelAndView("redirect:/");
        }
        // If the user is an admin, retrieve the list of especes
*/
        IEspeceDAO especeDAO = new EspeceDAO();
        List<Espece> especes = especeDAO.allEspeces();
        ModelAndView modelAndView = new ModelAndView("listeEspece");
        modelAndView.addObject("especes", especes);
        return modelAndView;
    }

    @GetMapping("/addespece")
    public ModelAndView showEspeceForm(HttpServletRequest request) {
        // Check if the user is an admin
        boolean isAdmin = false;
        try {
            isAdmin = (boolean) request.getSession().getAttribute("isAdmin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!isAdmin) {
            return new ModelAndView("redirect:/");
        }
        // If the user is an admin, retrieve the list of especes
        ModelAndView modelAndView = new ModelAndView("creationEspece");
        return modelAndView;
    }

    @PostMapping("/addespece")
    public String addEspece( Espece espece ) {
        espece.setEspece(espece.getEspece());
        espece.setPhotoUrl(espece.getPhotoUrl());
        System.out.println(espece.getPhotoUrl());
        espece.setDescription(espece.getDescription());
        IEspeceDAO especeDAO = new EspeceDAO();

        if (especeDAO.add(espece) > 0) {
            return "redirect:/";
        }
        else {
            return "creationEspecee";
        }
    }

    @GetMapping("/getEspeceDetail")
    public ModelAndView getEspeceDetail(HttpServletRequest request){
        // Check if the user is an admin
        boolean isAdmin = false;
        try {
            isAdmin = (boolean) request.getSession().getAttribute("isAdmin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!isAdmin) {
            return new ModelAndView("redirect:/");
        }
        // If the user is an admin, retrieve the list of especes
        String nomEspece =  request.getParameter("nom");
        IEspeceDAO especeDAO = new EspeceDAO();
        Espece DetailEspece = especeDAO.getEspeceByName(nomEspece);
        System.out.println("DetailEspece :" +DetailEspece );

        ModelAndView modelAndView = new ModelAndView("DetailEspece");
        modelAndView.addObject("DetailEspece", DetailEspece);
        return modelAndView;
    }
/*    @GetMapping("/removeEspece")
    public String removeEspece(@RequestParam("nom") String nomEespece){
        //
        System.out.println("test : espece : " + nomEespece );
        IEspeceDAO especeDAO = new EspeceDAO();
        if (especeDAO.remove(nomEespece) > 0) {
            return "redirect:/";
        }
        else {
            return "redirect:/removeEspece";
        }

    }*/
    @GetMapping("/removeEspece")
    public ModelAndView showRemoveEspeceForm(HttpServletRequest request){
        // Check if the user is an admin
        boolean isAdmin = false;
        try {
            isAdmin = (boolean) request.getSession().getAttribute("isAdmin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!isAdmin) {
            return new ModelAndView("redirect:/");
        }
        // If the user is an admin, retrieve the list of especes
        String nomEespece = request.getParameter("nom");
        // Set the parameter value as a hidden field in the form
        request.setAttribute("nomEespece", nomEespece);
        ModelAndView modelAndView = new ModelAndView("removeEspeceForm");
        return modelAndView;
    }
    @PostMapping("/removeEspece")
    public String removeEspece(@RequestParam("nomEspece") String nomEspece){
        System.out.println("test : espece : " + nomEspece );
        IEspeceDAO especeDAO = new EspeceDAO();
        if (especeDAO.remove(nomEspece) > 0) {
            return "redirect:/";
        }
        else {
            return "redirect:/removeEspece";
        }
    }

    @GetMapping ("/editEspece")
    public ModelAndView showEditEspeceForm(HttpServletRequest request){
        // Check if the user is an admin
        boolean isAdmin = false;
        try {
            isAdmin = (boolean) request.getSession().getAttribute("isAdmin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!isAdmin) {
            return new ModelAndView("redirect:/");
        }
        // If the user is an admin, retrieve the list of especes
        String nomEspece = request.getParameter("nom");
        IEspeceDAO especeDAO = new EspeceDAO();
        Espece espece = especeDAO.getEspeceByName(nomEspece);
        ModelAndView modelAndView = new ModelAndView("editEspeceForm");
        modelAndView.addObject("espece", espece);
        return modelAndView;
    }
    @PostMapping ("/editEspece")
    public String updateEspece(Espece espece){
        IEspeceDAO especeDAO = new EspeceDAO();
        if (especeDAO.edit(espece) > 0) {
            return "redirect:/";
        }
        else {
            return "redirect:/editEspece";
        }
    }
}
