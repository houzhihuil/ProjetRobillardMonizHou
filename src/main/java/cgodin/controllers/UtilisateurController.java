package cgodin.controllers;

import cgodin.models.DAO.*;
import cgodin.models.entities.Annonce;
import cgodin.models.entities.Espece;
import cgodin.models.entities.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "utilisateur")
public class UtilisateurController {

    public UtilisateurController() {
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView Login(Utilisateur utilisateur, HttpServletRequest request) {
//
//        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
//        List<Utilisateur> utilisateurs = utilisateurDAO.allUtilisateurs();
//        //tester si cet utilisateur existe
//        for (Utilisateur u : utilisateurs) {
//
//           if (u.getCourriel().equals(utilisateur.getCourriel()) && u.getMotDePasse().equals(utilisateur.getMotDePasse())) {
//                // Afficher l'ID de l'utilisateur dans la console
//                System.out.println("User ID: " + u.getIdMembre());
//
//                // Vérifier si l'utilisateur est un administrateur et rediriger vers la page d'administration
//                if (utilisateurDAO.isAdmin(u.getCourriel())) { // Modifiez cette ligne pour utiliser la méthode isAdmin
//                    ModelAndView modelAndView = new ModelAndView("admin");
//                    modelAndView.addObject("utilisateur", u);
//
//
//                    // Stocker l'ID de l'utilisateur dans la session
//                    request.getSession().setAttribute("idMembre", u.getIdMembre());
//                    request.getSession().setAttribute("isAdmin", true);
//
//                    return modelAndView;
//                }
//
//                ModelAndView modelAndView = new ModelAndView("accueil");
//                modelAndView.addObject("utilisateur", u);
//
//                // Stocker l'ID de l'utilisateur dans la session
//                request.getSession().setAttribute("idMembre", u.getIdMembre());
//
//                return modelAndView;
//            }
//        }
//
//        ModelAndView modelAndView = new ModelAndView("index");
//        return modelAndView;
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Utilisateur utilisateur, HttpServletRequest request) {
        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        List<Utilisateur> utilisateurs = utilisateurDAO.allUtilisateurs();
        // Recherche de l'utilisateur correspondant
        for (Utilisateur u : utilisateurs) {
            if (u.getCourriel().equals(utilisateur.getCourriel()) && u.getMotDePasse().equals(utilisateur.getMotDePasse())) {
                if (u.isCompteEstActif()) { // Vérification de l'état actif de l'utilisateur
                    System.out.println("User ID: " + u.getIdMembre());
                    // Redirection vers la page appropriée
                    if (utilisateurDAO.isAdmin(u.getCourriel())) {
                        ModelAndView modelAndView = new ModelAndView("admin");
                        modelAndView.addObject("utilisateur", u);
                        request.getSession().setAttribute("idMembre", u.getIdMembre());
                        request.getSession().setAttribute("isAdmin", true);
                        return modelAndView;
                    }
                    ModelAndView modelAndView = new ModelAndView("accueil");
                    modelAndView.addObject("utilisateur", u);
                    request.getSession().setAttribute("idMembre", u.getIdMembre());
                    return modelAndView;
                } else { // Utilisateur désactivé
                    ModelAndView modelAndView = new ModelAndView("index");
                    modelAndView.addObject("error", "Votre compte est désactivé. Veuillez contacter l'administrateur pour plus d'informations.");
                    return modelAndView;
                }
            }
        }
        // Utilisateur non trouvé
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("error", "Nom d'utilisateur ou mot de passe incorrect.");
        return modelAndView;
    }


    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public ModelAndView editProfile(HttpServletRequest request) {
        int idMembre = (int) request.getSession().getAttribute("idMembre");
        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        List<Utilisateur> utilisateurs = utilisateurDAO.allUtilisateurs();
        Utilisateur currentUser = null;
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getIdMembre() == idMembre) {
                currentUser = utilisateur;
                break;
            }
        }
        ModelAndView modelAndView = new ModelAndView("editProfile");
        modelAndView.addObject("utilisateur", currentUser);
        return modelAndView;
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public ModelAndView updateProfile(@RequestParam("idMembre") int idMembre,
                                      @RequestParam("nom") String nom,
                                      @RequestParam("prenom") String prenom,
                                      @RequestParam("courriel") String courriel,
                                      @RequestParam("lieuResidence") String lieuResidence,
                                      @RequestParam("motDePasse") String motDePasse,
                                      @RequestParam("noTelephone") String noTelephone,

                                      HttpServletRequest request) {

        System.out.println("updateProfile method called");

        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdMembre(idMembre);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setCourriel(courriel);
        utilisateur.setLieuResidence(lieuResidence);
        utilisateur.setMotDePasse(motDePasse);
        utilisateur.setNoTelephone(noTelephone);

        utilisateurDAO.edit(idMembre, utilisateur);

        System.out.println("User updated in the database");

        ModelAndView modelAndView = new ModelAndView("accueil");
        modelAndView.addObject("utilisateur", utilisateur);
        return modelAndView;
    }

//    @RequestMapping(value = "/listeAnnonce", method = RequestMethod.GET)
//    public ModelAndView listeAnnonce(@RequestParam(value = "typeAnnonce", required = false) String typeAnnonce,
//                                     @RequestParam(value = "espece", required = false) String espece,
//                                     @RequestParam(value = "localisation", required = false) String localisation,
//                                     @RequestParam(value = "date", required = false) String date) {
//        IAnnonceDAO annonceDAO = new AnnonceDAO();
//        List<Annonce> annonces = annonceDAO.allAnnonces();
//
//        if (typeAnnonce != null && !typeAnnonce.isEmpty()) {
//            annonces = annonces.stream()
//                    .filter(a -> a.getTypeAnnonce().equalsIgnoreCase(typeAnnonce))
//                    .collect(Collectors.toList());
//        }
//
//        if (espece != null && !espece.isEmpty()) {
//            annonces = annonces.stream()
//                    .filter(a -> a.getEspece().equalsIgnoreCase(espece))
//                    .collect(Collectors.toList());
//        }
//
//        if (localisation != null && !localisation.isEmpty()) {
//            annonces = annonces.stream()
//                    .filter(a -> a.getLocalisation().equalsIgnoreCase(localisation))
//                    .collect(Collectors.toList());
//        }
//        if (date != null && !date.isEmpty()) {
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate filterDate;
//            try {
//                filterDate = LocalDate.parse(date, dateFormatter);
//                annonces = annonces.stream()
//                        .filter(a -> a.getDate().isEqual(filterDate))
//                        .collect(Collectors.toList());
//            } catch (DateTimeParseException e) {
//                e.printStackTrace();
//            }
//        }

/*    @RequestMapping(value = "/listeAnnonce", method = RequestMethod.GET)
    public ModelAndView listeAnnonce(@RequestParam(value = "typeAnnonce", required = false) String typeAnnonce,
                                     @RequestParam(value = "espece", required = false) String espece,
                                     @RequestParam(value = "localisation", required = false) String localisation,
                                     @RequestParam(value = "startDate", required = false) String startDateParam,
                                     @RequestParam(value = "endDate", required = false) String endDateParam,
                                     HttpServletRequest request) {
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = annonceDAO.allAnnonces();

        if (typeAnnonce != null && !typeAnnonce.isEmpty()) {
            annonces = annonces.stream()
                    .filter(a -> a.getTypeAnnonce().equalsIgnoreCase(typeAnnonce))
                    .collect(Collectors.toList());
        }

        if (espece != null && !espece.isEmpty()) {
            annonces = annonces.stream()
                    .filter(a -> a.getEspece().equalsIgnoreCase(espece))
                    .collect(Collectors.toList());
        }

        if (localisation != null && !localisation.isEmpty()) {
            annonces = annonces.stream()
                    .filter(a -> a.getLocalisation().equalsIgnoreCase(localisation))
                    .collect(Collectors.toList());
        }
        if (startDateParam != null && !startDateParam.isEmpty() && endDateParam != null && !endDateParam.isEmpty()) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate, endDate;
            try {
                startDate = LocalDate.parse(startDateParam, dateFormatter);
                endDate = LocalDate.parse(endDateParam, dateFormatter);
                annonces = annonces.stream()
                        .filter(a -> a.getDate().isEqual(startDate) || (a.getDate().isAfter(startDate) && a.getDate().isBefore(endDate)) || a.getDate().isEqual(endDate))
                        .collect(Collectors.toList());
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        }

        ModelAndView modelAndView = new ModelAndView("listeAnnonce");
        modelAndView.addObject("annonces", annonces);


        int idMembre = (int) request.getSession().getAttribute("idMembre");
        List<Boolean> statuFavori  = annonceDAO.binstatuFavori( idMembre );
        modelAndView.addObject("statuFavoris", statuFavori);
        System.out.println("statuFavori size : "+ statuFavori.size());
        System.out.println("annoncesAll size : "+ annoncesAll.size());
        System.out.println("annonces size : "+ annonces.size());
        return modelAndView;
    }*/

    @RequestMapping(value = "/listeAnnonce", method = RequestMethod.GET)
    public ModelAndView listeAnnonce(@RequestParam(value = "typeAnnonce", required = false) String typeAnnonce,
                                     @RequestParam(value = "espece", required = false) String espece,
                                     @RequestParam(value = "localisation", required = false) String localisation,
                                     @RequestParam(value = "startDate", required = false) String startDateParam,
                                     @RequestParam(value = "endDate", required = false) String endDateParam,
                                     @RequestParam(name = "page", defaultValue = "1") int page,
                                     HttpServletRequest request) {
        int idMembre = (int) request.getSession().getAttribute("idMembre");
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = annonceDAO.allAnnoncesFavoris(idMembre);
        //List<Annonce> annonces = annonceDAO.allAnnonces();

        // Filtering based on request parameters
        if (typeAnnonce != null && !typeAnnonce.isEmpty()) {
            annonces = annonces.stream()
                    .filter(a -> a.getTypeAnnonce().equalsIgnoreCase(typeAnnonce))
                    .collect(Collectors.toList());
        }
        if (espece != null && !espece.isEmpty()) {
            annonces = annonces.stream()
                    .filter(a -> a.getEspece().equalsIgnoreCase(espece))
                    .collect(Collectors.toList());
        }
        if (localisation != null && !localisation.isEmpty()) {
            annonces = annonces.stream()
                    .filter(a -> a.getLocalisation().equalsIgnoreCase(localisation))
                    .collect(Collectors.toList());
        }
        if (startDateParam != null && !startDateParam.isEmpty() && endDateParam != null && !endDateParam.isEmpty()) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate, endDate;
            try {
                startDate = LocalDate.parse(startDateParam, dateFormatter);
                endDate = LocalDate.parse(endDateParam, dateFormatter);
                annonces = annonces.stream()
                        .filter(a -> a.getDate().isEqual(startDate) || (a.getDate().isAfter(startDate) && a.getDate().isBefore(endDate)) || a.getDate().isEqual(endDate))
                        .collect(Collectors.toList());
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        }

        // Pagination
        int itemsPerPage = 5; // set the number of items to display per page
        int totalItems = annonces.size(); // get the total number of items after filtering
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage); // calculate the total number of pages
        int start = (page - 1) * itemsPerPage; // calculate the starting index of the items
        int end = Math.min(start + itemsPerPage, totalItems); // calculate the ending index of the items

        annonces = annonces.subList(start, end); // apply pagination

        // Construct the pagination links
        int maxLinks = 5; // maximum number of pagination links to display
        int startLink = Math.max(1, page - maxLinks / 2);
        int endLink = Math.min(totalPages, startLink + maxLinks - 1);
        startLink = Math.max(1, endLink - maxLinks + 1);

        for (Annonce a:
            annonces ) {
            System.out.println(a.getIdAnnonce() +" : " + a.isFavorite());
        }




        ModelAndView modelAndView = new ModelAndView("listeAnnonce");
        modelAndView.addObject("annonces", annonces);


        modelAndView.addObject("totalPages", totalPages);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("startLink", startLink);
        modelAndView.addObject("endLink", endLink);

        return modelAndView;
    }


//    @RequestMapping(value = "/deleteProfile", method = RequestMethod.POST)
//    public ModelAndView deleteProfile(HttpServletRequest request) {
//        int idMembre = (int) request.getSession().getAttribute("idMembre");
//
//        IAnnonceDAO annonceDAO = new AnnonceDAO();
//        annonceDAO.removeByUtilisateurIDMembre(idMembre);
//
//        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
//        utilisateurDAO.remove(idMembre);
//
//        ModelAndView modelAndView = new ModelAndView("index");
//        request.getSession().invalidate(); // Invalidate the session after deleting the profile
//        return modelAndView;
//    }

    @RequestMapping(value = "/deleteProfile", method = RequestMethod.POST)
    public ModelAndView deleteProfile(@RequestParam("idMembre") int idMembre, HttpServletRequest request) {

        IAnnonce_SignaleeDAO annonce_signaleeDAO = new Annonce_SignaleeDAO();
        annonce_signaleeDAO.removeByUtilisateurIDMembre(idMembre);

        IMessagerieDAO messagerieDAO = new MessagerieDAO();
        messagerieDAO.removeByExpediteurIDMembre(idMembre);

        IMessagerieDAO messagerieDAO2 = new MessagerieDAO();
        messagerieDAO2.removeByDestinataireIDMembre(idMembre);

        IAnnonceDAO annonceDAO = new AnnonceDAO();
        annonceDAO.removeByUtilisateurIDMembre(idMembre);

        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        utilisateurDAO.remove(idMembre);

        ModelAndView modelAndView = new ModelAndView("index");
        request.getSession().invalidate(); // Invalidate the session after deleting the profile
        return modelAndView;
    }



    @RequestMapping(value = "/listeUtilisateurs", method = RequestMethod.GET)
    public ModelAndView listeUtilisateurs() {
        ModelAndView modelAndView = new ModelAndView("listeUtilisateurs");
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        List<Utilisateur> utilisateurs = utilisateurDAO.allUtilisateurs();
        modelAndView.addObject("utilisateurs", utilisateurs);
        return modelAndView;
    }

//    @GetMapping(value = "/desactiverUtilisateur")
//    public String desactivateUtilisateur(@RequestParam("id") int idMembre ) {
//        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
//        if (utilisateurDAO.desactiverUtilisateurByidMembre(idMembre) > 0) {
//            System.out.println("Desactivate avec success. ");
//            return "redirect:/";
//        }
//        return "admin";
//    }

    @PostMapping(value = "/supprimerUtilisateur")
    public String desactiverUtilisateur(@RequestParam("id") int idMembre ) {
        IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        if (utilisateurDAO.desactiverUtilisateurByidMembre(idMembre) > 0) {
            System.out.println("Supprimé avec succès. ");
            return "redirect:/";
        }
        return "admin";
    }

    @RequestMapping(value = "/listeMesAnnonces", method = RequestMethod.GET)
    public ModelAndView listeMesAnnonces(HttpServletRequest request) {
        int idMembre = (int) request.getSession().getAttribute("idMembre");

        // Définir l'attribut userID dans la session
        request.getSession().setAttribute("userID", idMembre);

        IAnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = annonceDAO.annoncesByUtilisateurIDMembre(idMembre);
        /*request.getSession().setAttribute("mesannonces", annonces);*/
        ModelAndView modelAndView = new ModelAndView("listeMesAnnonces");
        modelAndView.addObject("annonces", annonces);
        return modelAndView;
    }

    @RequestMapping(value = "/listeAnnoncesAdmin", method = RequestMethod.GET)
    public ModelAndView listeAnnoncesAdmin(HttpServletRequest request) {
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        List<Annonce> annonces = annonceDAO.allAnnonces();
        ModelAndView modelAndView = new ModelAndView("listeAnnoncesAdmin");
        modelAndView.addObject("annonces", annonces);
        return modelAndView;
    }

    @RequestMapping(value = "/redirectToMain", method = RequestMethod.GET)
    public String redirectToMain(HttpServletRequest request) {
        // Get the logged user ID from the session
        int idMembre = (int) request.getSession().getAttribute("idMembre");

        // Perform any additional login-related actions here

        // Redirect to the main page
        return "redirect:/http://localhost:8080/ProjetRobillardMonizHou_war_exploded/utilisateur/login"; // Replace "/" with the URL mapping of your main page
    }
    @RequestMapping(value = "/showAnnonceForm", method = RequestMethod.GET)
    public ModelAndView showAnnonce(@RequestParam("id") int idAnnonce) {
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        IEspeceDAO especeDAO = new EspeceDAO();
        Annonce monannonce = annonceDAO.getAnnonceById(idAnnonce);
        List<Espece> especes = especeDAO.allEspeces(); // Récupérer toutes les espèces


        ModelAndView modelAndView = new ModelAndView("editAnnonceForm");
        modelAndView.addObject("monannonce", monannonce);
        modelAndView.addObject("especes", especes); // Ajouter les espèces au modèle
        return modelAndView;
    }

    @RequestMapping(value = "/modifierMesAnnonce", method = RequestMethod.POST)
    public String modifierMesAnnonces(@RequestParam("idAnnonce") int idAnnonce,
                                            @RequestParam("typeAnnonce") String typeAnnonce,
                                            @RequestParam("localisation") String localisation,
                                            @RequestParam("espece") String espece,
                                            @RequestParam("sexe") String sexe,
                                            @RequestParam("notes") String notes,
                                            HttpServletRequest request) {
        IAnnonceDAO annonceDAO = new AnnonceDAO();
        Annonce annonce = annonceDAO.getAnnonceById(idAnnonce);
        annonce.setTypeAnnonce(typeAnnonce);
        annonce.setDate(LocalDate.now());
        annonce.setLocalisation(localisation);
        annonce.setEspece(espece);
        annonce.setSexe(sexe);
        annonce.setNotes(notes);

        annonceDAO.edit(idAnnonce,annonce);
        return "redirect: listeMesAnnonces";
    }


}
