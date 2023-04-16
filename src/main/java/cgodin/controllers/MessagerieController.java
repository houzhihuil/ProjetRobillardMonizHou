package cgodin.controllers;

import cgodin.models.DAO.*;


import cgodin.models.entities.Messagerie;
import cgodin.models.entities.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MessagerieController {

    private final IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    @GetMapping("/listeMessagerie")
    public ModelAndView allMessagerie(){
        ModelAndView modelAndView = new ModelAndView("listeMessagerie");
        IMessagerieDAO messagerieDAO = new MessagerieDAO();
        List <Messagerie> messageries = messagerieDAO.allMessageries();
        modelAndView.addObject("messageries", messageries);
        for (Messagerie m: messageries
             ) {
            System.out.println(m.getMessage()+ "  "+ m.getExpediteurIDMembre());
        }
        return modelAndView;
    }

    @GetMapping("/getMessagerieDetail")
    public ModelAndView getMsgDetail (HttpServletRequest request){

        int idMessage = Integer.parseInt(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView("DetailMessagerie");
        IMessagerieDAO messagerieDAO = new MessagerieDAO();
        Messagerie DetailMessagerie = messagerieDAO.getMessgerieByID(idMessage);
        System.out.println(DetailMessagerie);
        modelAndView.addObject("DetailMessagerie", DetailMessagerie);
        return modelAndView;
    }

    @GetMapping("/listeMesMessagerie")
    public ModelAndView lirMessagerie( HttpServletRequest request){
        int idMembre = (int) request.getSession().getAttribute("idMembre");
        ModelAndView modelAndView = new ModelAndView("listeMesMessagerie");
        IMessagerieDAO messagerieDAO = new MessagerieDAO();
        List <Messagerie> monMessageries = messagerieDAO.getMessgerieByUtilisateur(idMembre);
        modelAndView.addObject("monMessageries", monMessageries);
        modelAndView.addObject("monIDMembre", idMembre);
        return modelAndView;
    }


    @GetMapping("/addmessagerie")
    public ModelAndView showMessagerieForm() {
        ModelAndView modelAndView = new ModelAndView("creationMessagerie");
        List <Utilisateur>  utilisateurs =  utilisateurDAO.allUtilisateurs();
        modelAndView.addObject("utilisateurs", utilisateurs);
        return modelAndView;
    }

    @PostMapping("/addmessagerie")
    public String addMessagerie(@RequestParam("message") String message,
                                @RequestParam("destinataireIDMembre") int destinataireIDMembre,
                                HttpServletRequest request ) {

        int idMembre = (int) request.getSession().getAttribute("idMembre");
        // Afficher l'ID de l'utilisateur de la session dans la console
        System.out.println("Session user ID : " + idMembre);
        Messagerie messagerie = new Messagerie();
        messagerie.setDestinataireIDMembre(destinataireIDMembre);
        messagerie.setExpediteurIDMembre(idMembre);
        messagerie.setMessage(message);
        messagerie.setDateMessage(LocalDateTime.now() );

        IMessagerieDAO messagerieDAO = new MessagerieDAO();
        if (messagerieDAO.add(messagerie) > 0) {
            return "redirect:/";
        }
        else {
            return "creationMessagerie";
        }
    }


    @PostMapping("/supprimermessagerie")
    public String removeMessagerie( HttpServletRequest request){
        int idMembre = (int) request.getSession().getAttribute("idMembre");
        // Afficher l'ID de l'utilisateur de la session dans la console
        System.out.println("test : Session user ID : " + idMembre);
        IMessagerieDAO messagerieDAO = new MessagerieDAO();

        if (messagerieDAO.remove(idMembre) > 0) {
            return "redirect:/";
        }
        else {
            return "redirect:/supprimermessagerie";
        }

    }
}
