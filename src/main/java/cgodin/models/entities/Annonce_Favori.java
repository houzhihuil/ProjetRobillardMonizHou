package cgodin.models.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Annonce_Favori {
    private int annonceIDAnnonce;
    private int utilisateurIDMembre;
    private LocalDateTime dateMiseEnFavori;

    public Annonce_Favori() {
    }

    public Annonce_Favori(int annonceIDAnnonce, int utilisateurIDMembre, LocalDateTime dateMiseEnFavori) {
        this.annonceIDAnnonce = annonceIDAnnonce;
        this.utilisateurIDMembre = utilisateurIDMembre;
        this.dateMiseEnFavori = dateMiseEnFavori;
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

    public LocalDateTime getDateMiseEnFavori() {
        return dateMiseEnFavori;
    }

    public void setDateMiseEnFavori(LocalDateTime dateMiseEnFavori) {
        this.dateMiseEnFavori = dateMiseEnFavori;
    }

    @Override
    public String toString() {
        return "Annonce_Favori{" +
                "annonceIDAnnonce=" + annonceIDAnnonce +
                ", utilisateurIDMembre=" + utilisateurIDMembre +
                ", dateMiseEnFavori=" + dateMiseEnFavori +
                '}';
    }
}
