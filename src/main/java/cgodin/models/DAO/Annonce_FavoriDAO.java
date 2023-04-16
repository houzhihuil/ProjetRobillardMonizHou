package cgodin.models.DAO;

import cgodin.models.entities.Annonce_Favori;
import cgodin.models.entities.Annonce_Favori;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Annonce_FavoriDAO implements IAnnonce_FavoriDAO{
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
    public List<Annonce_Favori> allAnnonce_Favoris() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Annonce_Favori");
            //4 manipuler le resultat
            List<Annonce_Favori> annonce_favoris = new ArrayList<>();
            while (resultSet.next()) {
                Annonce_Favori annonce_favori = new Annonce_Favori();
                annonce_favori.setAnnonceIDAnnonce(resultSet.getInt("annonceIDAnnonce"));
                annonce_favori.setUtilisateurIDMembre(resultSet.getInt("utilisateurIDMembre"));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                annonce_favori.setDateMiseEnFavori(LocalDateTime.parse(resultSet.getString("dateMiseEnFavori"), formatter));

                annonce_favoris.add(annonce_favori);
            }
            //5 fermer la connexion
            closeConnection();
            return annonce_favoris;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int add(Annonce_Favori annonce_favori) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement= connection.createStatement();
            //3 executer une requete
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Annonce_Favori (annonceIDAnnonce, utilisateurIDMembre, DateMiseEnFavori) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, annonce_favori.getAnnonceIDAnnonce());
            pstmt.setInt(2, annonce_favori.getUtilisateurIDMembre());
            pstmt.setObject(3, annonce_favori.getDateMiseEnFavori());
            int nbLines = pstmt.executeUpdate();
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
            Statement statement= connection.createStatement();
            //3 executer une requete

            int nbLines = statement.executeUpdate("DELETE FROM Annonce_Favori WHERE annonceIDAnnonce= " + annonceIDAnnonce +
                    " AND utilisateurIDMembre= " + utilisateurIDMembre);

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isFavori(int annonceIDAnnonce, int utilisateurIDMembre) {
        try {
            //1 etablir une connexion
            establishConnection();

            //3 executer une requete
            PreparedStatement pstmt = connection.prepareStatement("SELECT EXISTS(SELECT * FROM Annonce_Favori WHERE annonceIDAnnonce = ? AND utilisateurIDMembre = ?)");
            pstmt.setInt(1, annonceIDAnnonce);
            pstmt.setInt(2, utilisateurIDMembre);
            ResultSet result = pstmt.executeQuery();

            // 4 Retrieve the result
            boolean isFavori = false;
            if (result.next()) {
                isFavori = result.getBoolean(1);
            }

            //5 fermer la connexion
            closeConnection();
            return isFavori;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
