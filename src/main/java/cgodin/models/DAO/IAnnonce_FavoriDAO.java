package cgodin.models.DAO;

import cgodin.models.entities.Annonce;
import cgodin.models.entities.Annonce_Favori;
import cgodin.models.entities.Annonce_Photo;

import java.util.List;

public interface IAnnonce_FavoriDAO {
    void establishConnection();

    void closeConnection();
    List<Annonce_Favori> allAnnonce_Favoris();
    int add(Annonce_Favori annonce_favori);
    int remove (int annonceIDAnnonce, int utilisateurIDMembre);
    boolean isFavori(int annonceIDAnnonce, int utilisateurIDMembre);
}
