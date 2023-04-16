package cgodin.models.DAO;

import cgodin.models.entities.Espece;
import cgodin.models.entities.Photo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhotoDAO implements IPhotoDAO {
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
    public List<Photo> allPhotos() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Photo ORDER BY idPhoto DESC;");
            //4 manipuler le resultat
            List<Photo> photos = new ArrayList<>();
            while (resultSet.next()) {
                Photo photo = new Photo();
                photo.setIdPhoto(resultSet.getInt("idPhoto"));
                photo.setPhotoURL(resultSet.getString("photoURL"));

                photos.add(photo);
            }
            //5 fermer la connexion
            closeConnection();
            return photos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(Photo photo) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Photo (photoURL) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, photo.getPhotoURL());
            // 3
            int nbLines = pstmt.executeUpdate();

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
