package cgodin.controllers;

import cgodin.models.DAO.*;
import cgodin.models.entities.Annonce;
import cgodin.models.entities.Annonce_Signalee;
import cgodin.models.entities.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AnnonceSignalee {
    private final IAnnonceDAO annonceDAO = new AnnonceDAO();
    private final IAnnonce_SignaleeDAO annonce_signaleeDAO =  new Annonce_SignaleeDAO();
    private final IUtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    @GetMapping("/addannoncesignalee")
    public ModelAndView showSignaleForm() {
        ModelAndView modelAndView = new ModelAndView("creationAnnonce_signale");
        List <Annonce> annonceList = annonceDAO.allAnnonces();
        modelAndView.addObject("annonceList", annonceList);
        List <Utilisateur> utilisateurs = utilisateurDAO.allUtilisateurs();
        modelAndView.addObject("utilisateurs",utilisateurs);
        return modelAndView;
    }

    @PostMapping("/addannoncesignalee")
    public String addSignale( @RequestParam("annonceIDAnnonce") String annonceIDAnnonce,
                              @RequestParam("utilisateurIDMembre") String utilisateurIDMembre,
                              @RequestParam("notes") String notes,
                              @RequestParam("type") String type,
                                HttpServletRequest request ) {

        int idMembre = (int) request.getSession().getAttribute("idMembre");

        Annonce_Signalee annonce_signalee = new Annonce_Signalee();

        annonce_signalee.setDateSignalement(LocalDateTime.now());
        annonce_signalee.setAnnonceIDAnnonce(Integer.parseInt(annonceIDAnnonce));
        annonce_signalee.setUtilisateurIDMembre(Integer.parseInt(utilisateurIDMembre));
        annonce_signalee.setType(type);
        annonce_signalee.setNotes(notes);
        if (annonce_signaleeDAO.add(annonce_signalee) > 0) {
            return "redirect:/";
        }
        else {
            return "addannoncesignalee";
        }
    }

    @GetMapping("listeannoncesignalee")
    public ModelAndView allAnnoncesignalees(){
        ModelAndView modelAndView = new ModelAndView("listeAnnoncesignalees");
        IAnnonce_SignaleeDAO annonceSignaleeDAO = new Annonce_SignaleeDAO();
        List <Annonce_Signalee> annonce_signalees = annonceSignaleeDAO.allAnnonces_Signalees();
        modelAndView.addObject("annonce_signalees", annonce_signalees);
        return modelAndView;
    }

    @GetMapping("/getSignaleeDetail")
    public ModelAndView getSignaleeDetail (HttpServletRequest request){
        int annonceIDAnnonce = Integer.parseInt(request.getParameter("id1"));
        int utilisateurIDMembre = Integer.parseInt(request.getParameter("id2"));
        ModelAndView modelAndView = new ModelAndView("DetailAnnonceSignalee");
        IAnnonce_SignaleeDAO annonceSignaleeDAO = new Annonce_SignaleeDAO();
        Annonce_Signalee  annonceSignale = annonceSignaleeDAO.getAnnonces_SignaleesByID(annonceIDAnnonce,   utilisateurIDMembre);

        modelAndView.addObject("annonce_signalee", annonceSignale);
        return modelAndView;
    }


    @Scheduled(fixedRate = 60000) // runs every minute
    public void deleteExpiredAnnonceSignalee() {
        IAnnonce_SignaleeDAO annonceSignaleeDAO = new Annonce_SignaleeDAO();
             int deletedRows = annonceSignaleeDAO.removeByInterval(91);
            if (deletedRows > 0) {
                System.out.println("Deleted " + deletedRows + " expired annonce_Signalee.");
            }
            else {
                System.out.println(" Annonce signalee 1 day ");
            }
    }

}
