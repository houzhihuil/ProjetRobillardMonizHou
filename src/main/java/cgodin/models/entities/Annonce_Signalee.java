package cgodin.models.entities;

import java.time.LocalDateTime;

public class Annonce_Signalee {
    private int annonceIDAnnonce;
    private int utilisateurIDMembre;
    private LocalDateTime dateSignalement;
    private String notes;
    private String type;

    public Annonce_Signalee() {
    }

    public Annonce_Signalee(int annonceIDAnnonce, int utilisateurIDMembre, LocalDateTime dateSignalement, String notes, String type) {
        this.annonceIDAnnonce = annonceIDAnnonce;
        this.utilisateurIDMembre = utilisateurIDMembre;
        this.dateSignalement = dateSignalement;
        this.notes = notes;
        this.type = type;
    }

    public int getAnnonceIDAnnonce() {
        return annonceIDAnnonce;
    }

    public void setAnnonceIDAnnonce(int annonceIDAnnonce) {
        this.annonceIDAnnonce = annonceIDAnnonce;
    }

    public int getUtilisateurIDMembre() {
        return utilisateurIDMembre;
    }

    public void setUtilisateurIDMembre(int utilisateurIDMembre) {
        this.utilisateurIDMembre = utilisateurIDMembre;
    }

    public LocalDateTime getDateSignalement() {
        return dateSignalement;
    }

    public void setDateSignalement(LocalDateTime dateSignalement) {
        this.dateSignalement = dateSignalement;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Annonce_Signalee{" +
                "annonceIDAnnonce=" + annonceIDAnnonce +
                ", utilisateurIDMembre=" + utilisateurIDMembre +
                ", dateSignalement=" + dateSignalement +
                ", notes='" + notes + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
