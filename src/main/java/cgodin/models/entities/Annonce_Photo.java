package cgodin.models.entities;

public class Annonce_Photo {
    private int annonceIDAnnonce;
    private int photoIDPhoto;

    public Annonce_Photo() {
    }

    public Annonce_Photo(int annonceIDAnnonce, int photoIDPhoto) {
        this.annonceIDAnnonce = annonceIDAnnonce;
        this.photoIDPhoto = photoIDPhoto;
    }

    public int getAnnonceIDAnnonce() {
        return annonceIDAnnonce;
    }

    public void setAnnonceIDAnnonce(int annonceIDAnnonce) {
        this.annonceIDAnnonce = annonceIDAnnonce;
    }

    public int getPhotoIDPhoto() {
        return photoIDPhoto;
    }

    public void setPhotoIDPhoto(int photoIDPhoto) {
        this.photoIDPhoto = photoIDPhoto;
    }

    @Override
    public String toString() {
        return "Annonce_Photo{" +
                "annonceIDAnnonce=" + annonceIDAnnonce +
                ", photoIDPhoto=" + photoIDPhoto +
                '}';
    }
}
