package cgodin.models.DAO;

import cgodin.models.entities.Annonce_Photo;

import java.util.List;

public interface IAnnonce_PhotoDAO {
    void establishConnection();

    void closeConnection();
    List<Annonce_Photo> allAnnonce_Photos();

    int add(Annonce_Photo annonce_photo);
}
