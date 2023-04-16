package cgodin.models.DAO;

import cgodin.models.entities.Messagerie;

import java.util.List;

public interface IMessagerieDAO {
    void establishConnection();

    void closeConnection();

    List<Messagerie> allMessageries();
    Messagerie getMessgerieByID(int idMessage);
    List<Messagerie> getMessgerieByUtilisateur(int idMembre);
    int removeByExpediteurIDMembre(int idMembre);
    int removeByDestinataireIDMembre(int idMembre);
    int add(Messagerie messagerie);
    int edit(int idMessagerie, Messagerie messagerie);
    int remove(int expediteurIDMembre);// remove Messagerie by expediteurIDMembre



}
