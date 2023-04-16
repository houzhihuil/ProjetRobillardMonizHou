package cgodin.models.DAO;

import cgodin.models.entities.Messagerie;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MessagerieDAO implements IMessagerieDAO {

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
    public List<Messagerie> allMessageries() {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Messagerie");
            //4 manipuler le resultat
            List<Messagerie> messageries = new ArrayList<Messagerie>();
            while (result.next()) {
                Messagerie messagerie = new Messagerie();
                messagerie.setIdMessage(result.getInt("idMessage"));
                messagerie.setMessage(result.getString("message"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                messagerie.setDateMessage(LocalDateTime.parse(result.getString("dateMessage"), formatter));
                messagerie.setExpediteurIDMembre(result.getInt("expediteurIDMembre"));
                messagerie.setDestinataireIDMembre(result.getInt("destinataireIDMembre"));

                messageries.add(messagerie);
            }
            //5 fermer la connexion
            closeConnection();
            return messageries;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(Messagerie messagerie) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Messagerie (message, dateMessage, expediteurIDMembre, destinataireIDMembre ) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, messagerie.getMessage());

            LocalDate dateMessage = LocalDate.from(messagerie.getDateMessage());
            if (dateMessage == null) {
                dateMessage = LocalDate.now(); // set the date to the current date if it's null
            }
            pstmt.setDate(2, Date.valueOf(dateMessage));
            pstmt.setInt(3, messagerie.getExpediteurIDMembre());
            pstmt.setInt(4, messagerie.getDestinataireIDMembre());
            int nbLines = pstmt.executeUpdate();

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int edit(int idMessagerie, Messagerie messagerie) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete

            String message = messagerie.getMessage();
            LocalDate dateMessage = LocalDate.from(messagerie.getDateMessage());
            int expediteurIDMembre = messagerie.getExpediteurIDMembre();
            int destinataireIDMembre = messagerie.getDestinataireIDMembre();

            int nbLines = statement.executeUpdate("UPDATE Messagerie SET message = '" + message + "', dateMessage= '" + dateMessage + "', expediteurIDMembre= '" + expediteurIDMembre + "', destinataireIDMembre= '" + destinataireIDMembre + "' WHERE idMessagerie= " + idMessagerie);

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(int expediteurIDMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete

            int nbLines = statement.executeUpdate("DELETE FROM Messagerie WHERE expediteurIDMembre =" + expediteurIDMembre);

            //5 fermer la connexion
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Messagerie getMessgerieByID(int idMessage) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Messagerie where idMessage = "+ idMessage );
            //4 manipuler le resultat
            Messagerie messagerie = new Messagerie();
            while (result.next()) {
                messagerie.setIdMessage(result.getInt("idMessage"));
                messagerie.setMessage(result.getString("message"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                //messagerie.setDateMessage(result.getTimestamp("dateMessage").toLocalDateTime() );
                messagerie.setDateMessage(LocalDateTime.parse(result.getString("dateMessage"), formatter));
                messagerie.setExpediteurIDMembre(result.getInt("expediteurIDMembre"));
                messagerie.setDestinataireIDMembre(result.getInt("destinataireIDMembre"));

            }
            //5 fermer la connexion
            closeConnection();
            return messagerie;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Messagerie> getMessgerieByUtilisateur(int idMembre) {
        try {
            //1 etablir une connexion
            establishConnection();
            //2 creer une declaration
            Statement statement = connection.createStatement();
            //3 executer une requete
            ResultSet result = statement.executeQuery("SELECT * FROM Messagerie where destinataireIDMembre  = "+ idMembre +" OR destinataireIDMembre =" +idMembre );
            //4 manipuler le resultat
            List<Messagerie> messageries = new ArrayList<Messagerie>();
            while (result.next()) {
                Messagerie messagerie = new Messagerie();
                messagerie.setIdMessage(result.getInt("idMessage"));
                messagerie.setMessage(result.getString("message"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                //messagerie.setDateMessage(result.getTimestamp("dateMessage").toLocalDateTime() );
                messagerie.setDateMessage(LocalDateTime.parse(result.getString("dateMessage"), formatter));
                messagerie.setExpediteurIDMembre(result.getInt("expediteurIDMembre"));
                messagerie.setDestinataireIDMembre(result.getInt("destinataireIDMembre"));

                messageries.add(messagerie);
            }
            //5 fermer la connexion
            closeConnection();
            return messageries;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int removeByExpediteurIDMembre(int expediteurIDMembre) {
        try {
            establishConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Messagerie WHERE expediteurIDMembre = ?");
            pstmt.setInt(1, expediteurIDMembre);
            int nbLines = pstmt.executeUpdate();
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int removeByDestinataireIDMembre(int destinataireIDMembre) {
        try {
            establishConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Messagerie WHERE destinataireIDMembre = ?");
            pstmt.setInt(1, destinataireIDMembre);
            int nbLines = pstmt.executeUpdate();
            closeConnection();
            return nbLines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}