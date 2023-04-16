package cgodin.models.DAO;

import cgodin.models.entities.Espece;
import cgodin.models.entities.Photo;

import java.util.List;

public interface IPhotoDAO {
    void establishConnection();

    void closeConnection();
    List<Photo> allPhotos();

    int add(Photo photo);
}
