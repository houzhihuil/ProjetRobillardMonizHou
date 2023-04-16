package cgodin.models.DAO;

import cgodin.models.entities.Annonce_Signalee;

import java.util.List;

public interface IAnnonce_SignaleeDAO {



    void establishConnection();
    void closeConnection();

    List<Annonce_Signalee> allAnnonces_Signalees();
    Annonce_Signalee getAnnonces_SignaleesByID(int annonceIDAnnonce, int utilisateurIDMembre);
    int add(Annonce_Signalee annonce_Signalee);
    int edit(int annonceIDAnnonc, int utilisateurIDMembre, Annonce_Signalee annonce_signalee);
    int remove(int annonceIDAnnonc, int utilisateurIDMembre);
    int removeByInterval(int jours);
    int removeByUtilisateurIDMembre(int idMembre);

}
