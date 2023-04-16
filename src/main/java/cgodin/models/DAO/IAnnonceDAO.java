package cgodin.models.DAO;

import cgodin.models.entities.Annonce;

import java.util.List;

public interface IAnnonceDAO {
    void establishConnection();

    void closeConnection();

    List<Annonce> allAnnonces();
    List<Annonce> afficherActiveAnnonces();
    List<Annonce> afficherAllAnnonces();
    List<Annonce> allAnnoncesFavoris(int idMembre);

    int add(Annonce annonce);

    int edit(int idAnnonce, Annonce annonce);
    int desactiverAnnonce(int jours);

    int desactiverAnnonceByidAnnonce(int idAnnonce);

    int remove(int idAnnonce);

    int removeByUtilisateurIDMembre(int idMembre);

    int removeByInterval(int jours);

    List<Annonce> annoncesByUtilisateurIDMembre(int utilisateurIDMembre);

    int getLastidAnnonce();

    Annonce getAnnonceById(int idAnnonce);

}
