package cgodin.models.DAO;

import cgodin.models.entities.Utilisateur;

import java.util.List;

public interface IUtilisateurDAO {
    void establishConnection();

    void closeConnection();

    List<Utilisateur> allUtilisateurs();

    Utilisateur getUtilisateurById(int id);

    int desactiverUtilisateurByidMembre(int idMembre);
    int add(Utilisateur utilisateur);

    int edit(int id, Utilisateur utilisateur);

    int remove(int id);

    boolean isAdmin(String email);
}
