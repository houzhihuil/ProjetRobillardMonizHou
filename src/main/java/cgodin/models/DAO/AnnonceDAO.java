package cgodin.models.DAO;

import cgodin.models.entities.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAO implements IAnnonceDAO {

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

/*    @Override
    public List<Annonce> allAnnonces() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Annonce");
            //4 manipuler le resultat
            List<Annonce> annonces = new ArrayList<Annonce>();
            while (result.next()) {
                Annonce annonce = new Annonce();
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                annonces.add(annonce);
            }
            //5 fermer la connexion
            closeConnection();
            return annonces;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public List<Annonce> allAnnonces() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            // Update the SQL query to include a join with the Photo table
            ResultSet result = statement.executeQuery(
                    "SELECT a.*, p.photoURL " +
                            "FROM Annonce a " +
                            "JOIN Annonce_Photo ap ON a.idAnnonce = ap.annonceIDAnnonce " +
                            "JOIN Photo p ON ap.photoIDPhoto = p.idPhoto"
            );
            //4 manipuler le resultat
            List<Annonce> annonces = new ArrayList<Annonce>();
            while (result.next()) {
                Annonce annonce = new Annonce();
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                annonce.setPhotoURL(result.getString("photoURL")); // Set the photoURL property
                annonces.add(annonce);
            }
            //5 fermer la connexion
            closeConnection();
            return annonces;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Annonce> afficherActiveAnnonces() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Annonce WHERE annonceEstActive = 1 ");

            //4 manipuler le resultat
            List<Annonce> annonces = new ArrayList<Annonce>();
            while (result.next()) {
                Annonce annonce = new Annonce();
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                annonces.add(annonce);
            }
            //5 fermer la connexion
            closeConnection();
            return annonces;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Annonce> afficherAllAnnonces() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Annonce ORDER BY idAnnonce;");

            //4 manipuler le resultat
            List<Annonce> annonces = new ArrayList<Annonce>();
            while (result.next()) {
                Annonce annonce = new Annonce();
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                annonces.add(annonce);
            }
            //5 fermer la connexion
            closeConnection();
            return annonces;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Annonce> allAnnoncesFavoris(int idMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery(
                    /*"SELECT a.*, CASE WHEN af.annonceIDAnnonce IS NULL THEN FALSE ELSE TRUE END AS is_favorite " +
                            "FROM Annonce a LEFT JOIN Annonce_Favori af ON a.idAnnonce = af.annonceIDAnnonce AND af.utilisateurIDMembre = " + idMembre );*/

                    /* "SELECT a.*, CASE WHEN af.idAnnonce IS NOT NULL AND af.utilisateurIDMembre = \" + idMembre + \" THEN TRUE ELSE FALSE END AS is_favorite  " +
                    "FROM Annonce a LEFT JOIN Annonce_Favori af ON a.idAnnonce = af.annonceIDAnnonce AND af.utilisateurIDMembre = " + idMembre );
*/

                   /* "SELECT a.*, " +
                    "CASE WHEN af.idAnnonce IS NOT NULL AND af.utilisateurIDMembre = " + idMembre + " THEN TRUE ELSE FALSE END AS is_favorite " +
                    "FROM Annonce a   LEFT JOIN Annonce_Favori af ON a.idAnnonce = af.annonceIDAnnonce AND af.utilisateurIDMembre = " + idMembre );
*/

                    "SELECT a.*, " +
                    "CASE WHEN af.utilisateurIDMembre IS NOT NULL THEN TRUE ELSE FALSE END AS is_favorite " +
                    "FROM Annonce a " +
                    "LEFT JOIN Annonce_Favori af ON a.idAnnonce = af.annonceIDAnnonce AND af.utilisateurIDMembre = " + idMembre +
                    " ORDER BY idAnnonce");




            //4 manipuler le resultat
            List<Annonce> annoncesFav = new ArrayList<>();
            while (result.next()) {
                Annonce annonce = new Annonce();
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                annonce.setIsFavorite(result.getBoolean("is_favorite")); // Set the value of is_favorite column

                annoncesFav.add(annonce);
            }
            //5 fermer la connexion
            closeConnection();
            return annoncesFav;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(Annonce annonce) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Annonce (typeAnnonce, date, localisation, espece, sexe, notes, annonceEstActive, especeNom, utilisateurIDMembre) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, annonce.getTypeAnnonce());

            LocalDate date = annonce.getDate();
            if (date == null) {
                date = LocalDate.now(); // set the date to the current date if it's null
            }
            pstmt.setDate(2, Date.valueOf(date));

            pstmt.setString(3, annonce.getLocalisation());
            pstmt.setString(4, annonce.getEspece());
            pstmt.setString(5, annonce.getSexe());

            String notes = annonce.getNotes();
            if (notes == null) {
                notes = ""; // set the notes to an empty string if it's null
            }
            pstmt.setString(6, notes);

            pstmt.setBoolean(7, annonce.isAnnonceEstActive());
            pstmt.setString(8, annonce.getEspeceNom());
            pstmt.setInt(9, annonce.getUtilisateurIDMembre());

            int nbLines = pstmt.executeUpdate();

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int edit(int idAnnonce, Annonce annonce) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            // Statement statement = connection.createStatement();
            //3 executer une requete
            String typeAnnonce = annonce.getTypeAnnonce();
            LocalDate dateAnnonce = annonce.getDate();
            String localisation = annonce.getLocalisation();
            String espece = annonce.getEspece();
            String sexe = annonce.getSexe();
            String notes = annonce.getNotes();

            String especeNom = annonce.getEspeceNom();
            int utilisateurIDMembre = annonce.getUtilisateurIDMembre();
            // int nbLines = statement.executeUpdate("UPDATE Annonce SET typeAnnonce = '" + typeAnnonce + "', date= '" + date + "', localisation= '" + localisation + "', espece= '" + espece + "', sexe= '" + sexe + "', notes= '" + notes + "', annonceEstActive= '" + annonceEstActive + "', especeNom= '" + especeNom + "', utilisateurIDMembre= '" + utilisateurIDMembre + "' WHERE idAnnonce= " + idAnnonce);

            String sql = "UPDATE Annonce SET typeAnnonce = ?, date = ?, localisation = ?, espece = ?, sexe = ?, notes = ?, especeNom = ?, utilisateurIDMembre = ? WHERE idAnnonce = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, typeAnnonce);
            preparedStatement.setDate(2, Date.valueOf(dateAnnonce));
            preparedStatement.setString(3, localisation);
            preparedStatement.setString(4, espece);
            preparedStatement.setString(5, sexe);
            preparedStatement.setString(6, notes);
            preparedStatement.setString(7, especeNom);
            preparedStatement.setInt(8, utilisateurIDMembre);
            preparedStatement.setInt(9, idAnnonce);

            int nbLines = preparedStatement.executeUpdate();


            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int desactiverAnnonce(int jours) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            int nbLines = statement.executeUpdate("UPDATE Annonce SET annonceEstActive = false WHERE DATEDIFF(CURRENT_TIMESTAMP, date ) > ' " + jours + " ' ");

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int desactiverAnnonceByidAnnonce(int idAnnonce) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            int nbLines = statement.executeUpdate("UPDATE Annonce SET annonceEstActive = false WHERE idAnnonce = ' " + idAnnonce + " ' ");

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(int idAnnonce) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete

            int nbLines = statement.executeUpdate("DELETE FROM Annonce WHERE idAnnonce=" + idAnnonce);

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
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Annonce WHERE utilisateurIDMembre = ?");
            pstmt.setInt(1, utilisateurIDMembre);
            int nbLines = pstmt.executeUpdate();
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
            int nbLines = statement.executeUpdate("DELETE FROM Annonce WHERE DATEDIFF(CURRENT_TIMESTAMP, date ) > ' " + jours + " ' ");

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


/*    public List<Annonce> annoncesByUtilisateurIDMembre(int utilisateurIDMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Annonce WHERE utilisateurIDMembre = ?");
            pstmt.setInt(1, utilisateurIDMembre);
            //3 executer une requete
            ResultSet result = pstmt.executeQuery();
            //4 manipuler le resultat
            List<Annonce> annonces = new ArrayList<Annonce>();
            while (result.next()) {
                Annonce annonce = new Annonce();
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                annonces.add(annonce);
            }
            //5 fermer la connexion
            closeConnection();
            return annonces;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public List<Annonce> annoncesByUtilisateurIDMembre(int utilisateurIDMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT a.*, p.photoURL " +
                            "FROM Annonce a " +
                            "JOIN Annonce_Photo ap ON a.idAnnonce = ap.annonceIDAnnonce " +
                            "JOIN Photo p ON ap.photoIDPhoto = p.idPhoto " +
                            "WHERE a.utilisateurIDMembre = ?"
            );
            pstmt.setInt(1, utilisateurIDMembre);
            //3 executer une requete
            ResultSet result = pstmt.executeQuery();
            //4 manipuler le resultat
            List<Annonce> annonces = new ArrayList<Annonce>();
            while (result.next()) {
                Annonce annonce = new Annonce();
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));
                annonce.setPhotoURL(result.getString("photoURL")); // Set the photoURL property
                annonces.add(annonce);
            }
            //5 fermer la connexion
            closeConnection();
            return annonces;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getLastidAnnonce() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT MAX(idAnnonce) FROM Annonce ");

            // 4 Retrieve the result
            int lastId = 0;
            if (result.next()) {
                lastId = result.getInt(1);
            }

            //5 fermer la connexion
            closeConnection();
            return lastId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Annonce getAnnonceById(int idAnnonce) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            // ResultSet result = statement.executeQuery("SELECT MAX(idAnnonce) FROM Annonce ");
            ResultSet result = statement.executeQuery("SELECT *  FROM Annonce WHERE idAnnonce=" + idAnnonce);
            Annonce annonce = new Annonce();
            // 4 Retrieve the result
            if (result.next()) {
                annonce.setIdAnnonce(result.getInt("idAnnonce"));
                annonce.setTypeAnnonce(result.getString("typeAnnonce"));
                annonce.setDate(result.getObject("date", LocalDate.class));
                annonce.setLocalisation(result.getString("localisation"));
                annonce.setEspece(result.getString("espece"));
                annonce.setSexe(result.getString("sexe"));
                annonce.setNotes((result.getString("notes")));
                annonce.setAnnonceEstActive(result.getBoolean("annonceEstActive"));
                annonce.setEspeceNom((result.getString("especeNom")));
                annonce.setUtilisateurIDMembre(result.getInt("utilisateurIDMembre"));

            }

            //5 fermer la connexion
            closeConnection();
            return annonce;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}