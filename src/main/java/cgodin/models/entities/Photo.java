package cgodin.models.entities;

public class Photo {
    private int idPhoto;
    private String photoURL;

    public Photo() {
    }

    public Photo(int idPhoto, String photoURL) {
        this.idPhoto = idPhoto;
        this.photoURL = photoURL;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "idPhoto=" + idPhoto +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }
}
