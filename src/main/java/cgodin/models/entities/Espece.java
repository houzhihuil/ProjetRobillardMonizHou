package cgodin.models.entities;

public class Espece {
    private String espece;
    private String photoUrl;
    private String description;

    public Espece() {
    }

    public Espece(String nom, String photoUrl, String description) {
        this.espece = nom;
        this.photoUrl = photoUrl;
        this.description = description;
    }

    public String getEspece() { return espece; }

    public void setEspece(String nom) { this.espece = nom; }

    public String getPhotoUrl() { return photoUrl; }

    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Espece{" +
                "nom='" + espece + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}