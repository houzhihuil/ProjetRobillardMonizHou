package cgodin.models.DAO;

import cgodin.models.entities.Annonce_Photo;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class Annonce_PhotoDAO implements IAnnonce_PhotoDAO{
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
    public List<Annonce_Photo> allAnnonce_Photos() {
        return null;
    }

    @Override
    public int add(Annonce_Photo annonce_photo) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement= connection.createStatement();
            //3 executer une requete

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Annonce_Photo ( annonceIDAnnonce, photoIDPhoto ) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, annonce_photo.getAnnonceIDAnnonce());
            pstmt.setInt(2, annonce_photo.getPhotoIDPhoto());
            int nbLines = pstmt.executeUpdate();

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
