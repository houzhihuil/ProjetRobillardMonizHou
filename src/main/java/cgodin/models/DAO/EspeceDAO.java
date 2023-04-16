package cgodin.models.DAO;

import cgodin.models.entities.Espece;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspeceDAO implements IEspeceDAO {


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
    public List<Espece> allEspeces() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Espece");
            //4 manipuler le resultat
            List<Espece> especes = new ArrayList<>();
            while (resultSet.next()) {
                Espece espece = new Espece();
                espece.setEspece(resultSet.getString("espece"));
                espece.setPhotoUrl(resultSet.getString("photoUrl"));
                espece.setDescription(resultSet.getString("description"));

                especes.add(espece);
            }
            //5 fermer la connexion
            closeConnection();
            return especes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


@Override
public Espece getEspeceByName(String nomEspece) {
    try {
        //1 etablir une connexion
        establishConnection();
        //2 creer une declaration
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Espece where espece = ?");
        statement.setString(1, nomEspece);
        //3 executer une requete
        ResultSet result = statement.executeQuery();
        //4 manipuler le resultat
        Espece espece = new Espece();
        while (result.next()) {
            espece.setEspece(result.getString("espece"));
            espece.setPhotoUrl(result.getString("photoURL"));
            espece.setDescription(result.getString("description"));
        }

        //5 fermer la connexion
        closeConnection();
        return espece;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    @Override
    public int add(Espece espece) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Espece (espece, photoUrl, description) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, espece.getEspece());
            pstmt.setString(2, espece.getPhotoUrl());
            pstmt.setString(3, espece.getDescription());

            // 3
             int nbLines = pstmt.executeUpdate();

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int edit(Espece espece) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete

            String nomEespece = espece.getEspece();
            String photoURL = espece.getPhotoUrl();
            String description = espece.getDescription();
            int nbLines = statement.executeUpdate("UPDATE Espece SET photoURL = '" +  photoURL + "', description= '"  + description +
            "' WHERE espece ='" + nomEespece + "'");

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(String nomEespece) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            int nbLines  = statement.executeUpdate("DELETE FROM Espece WHERE espece ='" + nomEespece + "'");

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}