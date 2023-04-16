package cgodin.controllers;

import cgodin.models.DAO.*;
import cgodin.models.entities.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "creationAnnonce")
public class CreationAnnonceController {
    private final IAnnonceDAO annonceDAO = new AnnonceDAO();
    private final IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private final IEspeceDAO especeDAO = new EspeceDAO();
    private final IPhotoDAO photoDAO = new PhotoDAO();
    private final IAnnonce_PhotoDAO annonce_photoDAO = new Annonce_PhotoDAO();

    @RequestMapping(value = "creerannonce", method = RequestMethod.GET)
    public ModelAndView CreationAnnonce() {
        ModelAndView modelAndView = new ModelAndView("creationAnnonce");

        List<Espece> especes = especeDAO.allEspeces(); // Récupérer toutes les espèces
        modelAndView.addObject("especes", especes); // Ajouter les espèces au modèle

        List<Photo> photos = photoDAO.allPhotos(); // // Récupérer toutes les photos
        modelAndView.addObject("photos", photos); // Ajouter le photo au modèle

        return modelAndView;
    }
    @RequestMapping(value = "creerannonce2", method = RequestMethod.GET)
    public ModelAndView CreationAnnonce2() {
        ModelAndView modelAndView = new ModelAndView("creationAnnonce2");

        List<Espece> especes = especeDAO.allEspeces(); // Récupérer toutes les espèces
        modelAndView.addObject("especes", especes); // Ajouter les espèces au modèle

        List<Photo> photos = photoDAO.allPhotos(); // // Récupérer toutes les photos
        modelAndView.addObject("photos", photos); // Ajouter le photo au modèle

        return modelAndView;
    }

    @RequestMapping(value = "/annonce", method = RequestMethod.POST)
    public String Annonce(@RequestParam("typeAnnonce") String typeAnnonce,
                          @RequestParam("localisation") String localisation,
                          @RequestParam("espece") String espece,
                          @RequestParam("sexe") String sexe,
                          @RequestParam("notes") String notes,
                          @RequestParam("idPhoto") int idPhoto,
                          HttpServletRequest request, Model model) {

        System.out.println("typeAnnonce: " + typeAnnonce);
        System.out.println("localisation: " + localisation);
        System.out.println("espece: " + espece);
        System.out.println("sexe: " + sexe);
        System.out.println("notes: " + notes);
        System.out.println("idPhoto: " + idPhoto);
        int idMembre = (int) request.getSession().getAttribute("idMembre");

        // Afficher l'ID de l'utilisateur de la session dans la console
        System.out.println("Session user ID: " + idMembre);

        // Update the 'Annonce' object creation with the fetched 'espece' value

        Annonce annonce = new Annonce( typeAnnonce, LocalDate.now(), localisation, espece, sexe, notes, true, "", idMembre);
        annonce.setEspeceNom(espece);
        annonceDAO.add(annonce); // this executes the INSERT query
        int idAnnonce = annonceDAO.getLastidAnnonce(); // stmt.getLastInsertId();

        System.out.println("idPhoto : "+idPhoto);
        System.out.println("idAnnonce : "+idAnnonce);
        System.out.println("***");
        Annonce_Photo annonce_photo = new Annonce_Photo();
        annonce_photo.setAnnonceIDAnnonce(idAnnonce);
        annonce_photo.setPhotoIDPhoto(idPhoto);
        annonce_photoDAO.add(annonce_photo);
        return "redirect:/utilisateur/listeAnnonce";
    }

    @RequestMapping(value = "ajout")
    public ModelAndView Ajout() {
        ModelAndView modelAndView = new ModelAndView("creationAnnonce");
        AnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = annonceDAO.allAnnonces();
        modelAndView.addObject("annonces", annonces);
        return modelAndView;
    }

    @GetMapping(value = "/desactivaterAnnonce")
    public String desactivateAnnonce(@RequestParam("id") int idAnnonce ) {
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        if (annonceDAO.desactiverAnnonceByidAnnonce(idAnnonce) > 0) {
            System.out.println("Desactivate avec success. ");
            return "redirect:/";
        }
        return "creationAnnonce";
    }


    @Scheduled(fixedRate = 600000) // runs every 10 minute
    public void deleteExpiredAnnonce( ) {
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        int deletedRows = annonceDAO.removeByInterval(365);
        if (deletedRows > 0) {
            System.out.println("Deleted " + deletedRows + " expired annonce.");
        }
    }

    @Scheduled(fixedRate = 600000) // runs every 10 minute
    public void desactivateAnnonce( ) {
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        int desactivateRows = annonceDAO.desactiverAnnonce(90);
        if (desactivateRows > 0) {
            System.out.println("Desactivate total " + desactivateRows + " stale annonce.");
        }
    }

}
