package cgodin.models.DAO;

import cgodin.models.entities.Annonce_Signalee;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Annonce_SignaleeDAO implements IAnnonce_SignaleeDAO {
    public final String URL = "jdbc:mysql://mysql-alexandrerobillard.alwaysdata.net:3306/alexandrerobillard_meoprobillardmonizhou";
    public final String USERNAME = "289329";
    public final String PASSWORD = "Root2022";

    Connection connection = null;

    @Override
    public void establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Connexion etablie");
            } else {
                System.out.println("Connexion non etablie");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Annonce_Signalee> allAnnonces_Signalees() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Annonce_Signalee");
            //4 manipuler le resultat
            List<Annonce_Signalee> annonce_signalees = new ArrayList<Annonce_Signalee>();
            while (result.next()) {
                Annonce_Signalee annonce_signalee = new Annonce_Signalee();
                annonce_signalee.setAnnonceIDAnnonce(result.getInt("annonceIDAnnonce"));
                annonce_signalee.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                annonce_signalee.setDateSignalement(LocalDateTime.parse(result.getString("dateSignalement"), formatter));

                annonce_signalee.setNotes(result.getString("notes"));
                annonce_signalee.setType(result.getString("type"));

                annonce_signalees.add(annonce_signalee);
            }
            //5 fermer la connexion
            closeConnection();
            return annonce_signalees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Annonce_Signalee getAnnonces_SignaleesByID(int annonceIDAnnonce, int utilisateurIDMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Annonce_Signalee where annonceIDAnnonce = "+ annonceIDAnnonce
                   + " AND utilisateurIDMembre= " + utilisateurIDMembre );

            //4 manipuler le resultat
            Annonce_Signalee annonce_signalee = null;
            if (result.next()) {
                annonce_signalee = new Annonce_Signalee();
                annonce_signalee.setAnnonceIDAnnonce(result.getInt("annonceIDAnnonce"));
                annonce_signalee.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                annonce_signalee.setDateSignalement(LocalDateTime.parse(result.getString("dateSignalement"), formatter));
                annonce_signalee.setNotes(result.getString("notes"));
                annonce_signalee.setType(result.getString("type"));
            }

            //5 fermer la connexion
            closeConnection();
            return annonce_signalee;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(Annonce_Signalee annonce_Signalee) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement= connection.createStatement();
            //3 executer une requete
            int annonceIDAnnonce= annonce_Signalee.getAnnonceIDAnnonce();
            int utilisateurIDMembre = annonce_Signalee.getUtilisateurIDMembre();
            LocalDateTime dateSignalement = annonce_Signalee.getDateSignalement();
            String notes = annonce_Signalee.getNotes();
            String type = annonce_Signalee.getType();
            int nbLines= statement.executeUpdate("INSERT INTO Annonce_Signalee (annonceIDAnnonce, utilisateurIDMembre, dateSignalement, notes, type) VALUES('"+ annonceIDAnnonce +"', '"+utilisateurIDMembre+"', '"+dateSignalement+"', '"+notes+"', '"+type +"')");
            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int edit(int annonceIDAnnonce, int utilisateurIDMembre, Annonce_Signalee annonce_signalee) {
         try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete

            LocalDateTime dateSignalement  = annonce_signalee.getDateSignalement();
            String notes = annonce_signalee.getNotes();
            String type = annonce_signalee.getType();
            int nbLines = statement.executeUpdate("UPDATE Annonce_Signalee SET dateSignalement = '" +  dateSignalement + "', notes= '"  + notes + "', type= '"  + type +"' WHERE annonceIDAnnonce= " + annonceIDAnnonce +
                            " AND utilisateurIDMembre= " + utilisateurIDMembre
                    );
             
             //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(int annonceIDAnnonce, int utilisateurIDMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete

            int nbLines = statement.executeUpdate("DELETE FROM Annonce_Signalee WHERE annonceIDAnnonce= " + annonceIDAnnonce +
                            " AND utilisateurIDMembre= " + utilisateurIDMembre);

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public  int removeByInterval(int jours) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            int nbLines = statement.executeUpdate("DELETE FROM Annonce_Signalee WHERE DATEDIFF(CURRENT_TIMESTAMP, dateSignalement ) > ' " + jours + " ' ");

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int removeByUtilisateurIDMembre(int utilisateurIDMembre) {
        try {
            establishConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Annonce_Signalee WHERE utilisateurIDMembre = ?");
            pstmt.setInt(1, utilisateurIDMembre);
            int nbLines = pstmt.executeUpdate();
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
