package cgodin.models.entities;

public class Utilisateur {
    private int idMembre;
    private String nom;
    private String prenom;
    private String courriel;
    private String lieuResidence;
    private String motDePasse;
    private String noTelephone;
    private boolean compteEstActif;

    public Utilisateur() {
    }

    public Utilisateur(int idMembre, String nom, String prenom, String courriel, String lieuResidence, String motDePasse, String noTelephone, boolean compteEstActif) {
        this.idMembre = idMembre;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.lieuResidence = lieuResidence;
        this.motDePasse = motDePasse;
        this.noTelephone = noTelephone;
        this.compteEstActif = compteEstActif;
    }

    public int getIdMembre() { return idMembre; }

    public void setIdMembre(int idMembre) { this.idMembre = idMembre; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getCourriel() { return courriel; }

    public void setCourriel(String courriel) {this.courriel = courriel; }

    public String getLieuResidence() { return lieuResidence; }

    public void setLieuResidence(String lieuResidence) { this.lieuResidence = lieuResidence; }

    public String getMotDePasse() { return motDePasse; }

    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getNoTelephone() { return noTelephone; }

    public void setNoTelephone(String noTelephone) { this.noTelephone = noTelephone; }

    public boolean isCompteEstActif() { return compteEstActif; }

    public void setCompteEstActif(boolean compteEstActif) { this.compteEstActif = compteEstActif; }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idMembre=" + idMembre +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", courriel='" + courriel + '\'' +
                ", lieuResidence='" + lieuResidence + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", noTelephone='" + noTelephone + '\'' +
                ", compteEstActif=" + compteEstActif +
                '}';
    }
}
