package cgodin.models.DAO;

import cgodin.models.entities.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO implements IUtilisateurDAO {
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
    public List<Utilisateur> allUtilisateurs() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Utilisateur");
            //4 manipuler le resultat
            List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
            while (result.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setIdMembre(result.getInt("idMembre"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                utilisateur.setCourriel(result.getString("courriel"));
                utilisateur.setLieuResidence(result.getString("lieuResidence"));
                utilisateur.setNoTelephone(result.getString("noTelephone"));
                utilisateur.setMotDePasse((result.getString("motDePasse")));
                utilisateur.setCompteEstActif((result.getBoolean("compteEstActif")));
                utilisateurs.add(utilisateur);
            }
            //5 fermer la connexion
            closeConnection();
            return utilisateurs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(Utilisateur utilisateur) {
        try {
            establishConnection();
            String sql = "INSERT INTO Utilisateur (nom, prenom, courriel, lieuResidence, motDePasse, noTelephone, compteEstActif) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getCourriel());
            preparedStatement.setString(4, utilisateur.getLieuResidence());
            preparedStatement.setString(5, utilisateur.getMotDePasse());
            preparedStatement.setString(6, utilisateur.getNoTelephone());
            preparedStatement.setBoolean(7, true);
            int nbLines = preparedStatement.executeUpdate();
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int edit(int idMembre, Utilisateur utilisateur) {
        try {
            establishConnection();
            String sql = "UPDATE Utilisateur SET nom = ?, prenom = ?, courriel = ?, lieuResidence = ?, motDePasse = ?, noTelephone = ? WHERE idMembre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getCourriel());
            preparedStatement.setString(4, utilisateur.getLieuResidence());
            preparedStatement.setString(5, utilisateur.getMotDePasse());
            preparedStatement.setString(6, utilisateur.getNoTelephone());
            preparedStatement.setInt(7, idMembre);
            int nbLines = preparedStatement.executeUpdate();
            closeConnection();

            System.out.println("Updated lines: " + nbLines); // Add this line to see how many lines were updated
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int desactiverUtilisateurByidMembre(int idMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            int nbLines = statement.executeUpdate("UPDATE Utilisateur SET compteEstActif = false WHERE idMembre = ' " + idMembre + " ' ");

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Utilisateur getUtilisateurById(int id) {
        Utilisateur utilisateur = null;
        try {
            establishConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Utilisateur WHERE idMembre = ?");
            pstmt.setInt(1, id);

            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setIdMembre(result.getInt("idMembre"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setPrenom(result.getString("prenom"));
                // ... (populate other fields)
            }
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utilisateur;
    }


    @Override
    public int remove(int idMembre) {
        try {
            establishConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Utilisateur WHERE idMembre = ?");
            pstmt.setInt(1, idMembre);
            int nbLines = pstmt.executeUpdate();
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isAdmin(String email) {
        return "admin@gmail.com".equalsIgnoreCase(email);
    }

}