package cgodin.models.entities;


import java.time.LocalDate;

public class Annonce {
    private int idAnnonce;
    private String typeAnnonce;
    private LocalDate date;
    private String localisation;
    private String espece;
    private String sexe;
    private String notes;
    private boolean annonceEstActive;
    private String especeNom;
    private int utilisateurIDMembre;
    private String photoURL;
    private boolean isFavorite;

    public Annonce() {
    }

    public Annonce(String typeAnnonce, LocalDate date, String localisation, String espece, String sexe, String notes, boolean annonceEstActive, String especeNom, int utilisateurIDMembre) {

        this.typeAnnonce = typeAnnonce;
        this.date = date;
        this.localisation = localisation;
        this.espece = espece;
        this.sexe = sexe;
        this.notes = notes;
        this.annonceEstActive = annonceEstActive;
        this.especeNom = especeNom;
        this.utilisateurIDMembre = utilisateurIDMembre;
    }

    public int getIdAnnonce() { return idAnnonce; }

    public void setIdAnnonce(int idAnnonce) { this.idAnnonce = idAnnonce; }

    public String getTypeAnnonce() { return typeAnnonce; }

    public void setTypeAnnonce(String typeAnnonce) { this.typeAnnonce = typeAnnonce; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public String getLocalisation() { return localisation; }

    public void setLocalisation(String localisation) { this.localisation = localisation; }

    public String getEspece() { return espece; }

    public void setEspece(String race) { this.espece = race; }

    public String getSexe() { return sexe; }

    public void setSexe(String sexe) { this.sexe = sexe;
    }

    public String getNotes() { return notes; }

    public void setNotes(String note) { this.notes = note; }

    public boolean isAnnonceEstActive() { return annonceEstActive; }

    public void setAnnonceEstActive(boolean annonceEstActive) { this.annonceEstActive = annonceEstActive; }

    public String getEspeceNom() { return especeNom; }

    public void setEspeceNom(String especeNom) { this.especeNom = especeNom; }

    public int getUtilisateurIDMembre() { return utilisateurIDMembre; }

    public void setUtilisateurIDMembre(int utilisateurIDMembre) { this.utilisateurIDMembre = utilisateurIDMembre; }

    public String getPhotoURL() { return photoURL; }
    public void setPhotoURL(String photoURL) { this.photoURL = photoURL; }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "idAnnonce=" + idAnnonce +
                ", typeAnnonce='" + typeAnnonce + '\'' +
                ", date=" + date +
                ", localisation='" + localisation + '\'' +
                ", espece='" + espece + '\'' +
                ", sexe='" + sexe + '\'' +
                ", notes='" + notes + '\'' +
                ", annonceEstActive=" + annonceEstActive +
                ", especeNom='" + especeNom + '\'' +
                ", utilisateurIDMembre=" + utilisateurIDMembre +
                ", photoURL='" + photoURL + '\'' +
                ", isFavorite=" + isFavorite +
                '}';
    }
}