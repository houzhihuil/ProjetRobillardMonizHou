package cgodin.models.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Messagerie {
    private int idMessage;
    private String message;
    private LocalDateTime dateMessage;
    private int expediteurIDMembre;
    private int destinataireIDMembre;
    public Messagerie() {
    }

    public Messagerie(int idMessage, String message, LocalDateTime dateMessage, int expediteurIDMembre, int destinataireIDMembre) {
        this.idMessage = idMessage;
        this.message = message;
        this.dateMessage = dateMessage;
        this.expediteurIDMembre = expediteurIDMembre;
        this.destinataireIDMembre = destinataireIDMembre;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public LocalDateTime getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(LocalDateTime dateMessage) {
        this.dateMessage = dateMessage;
    }

    public int getExpediteurIDMembre() {
        return expediteurIDMembre;
    }

    public void setExpediteurIDMembre(int expediteurIDMembre) {
        this.expediteurIDMembre = expediteurIDMembre;
    }

    public int getDestinataireIDMembre() {
        return destinataireIDMembre;
    }

    public void setDestinataireIDMembre(int destinataireIDMembre) {
        this.destinataireIDMembre = destinataireIDMembre;
    }

    @Override
    public String toString() {
        return "Messagerie{" +
                "idMessage=" + idMessage +
                ", message='" + message + '\'' +
                ", dateMessage=" + dateMessage +
                ", expediteurIDMembre=" + expediteurIDMembre +
                ", destinataireIDMembre=" + destinataireIDMembre +
                '}';
    }
}
