package cgodin.controllers;

import cgodin.models.DAO.IUtilisateurDAO;
import cgodin.models.DAO.UtilisateurDAO;
import cgodin.models.entities.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "creation")
public class CreationCompteController {


    @RequestMapping(value = "compte", method = RequestMethod.GET)
    public ModelAndView Compte() {
        ModelAndView modelAndView = new ModelAndView("creationCompte");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/compte", method = RequestMethod.POST)
    public String Compte(Utilisateur utilisateur) { //model binding
        IUtilisateurDAO iUtilisateurDAO = new UtilisateurDAO();

        iUtilisateurDAO.add(utilisateur);

        //return "Nouvel utilisateur ajoute ! " + utilisateur;
        return "Inscription fait avec succès!" + "<br>" + "nom : " +
                utilisateur.getNom() + "<br>" + "Courriel: " + utilisateur.getCourriel();
    }
}
