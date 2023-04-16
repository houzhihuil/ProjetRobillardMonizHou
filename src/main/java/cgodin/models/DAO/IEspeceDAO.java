package cgodin.models.DAO;

import cgodin.models.entities.Espece;

import java.util.List;

public interface IEspeceDAO {
    void establishConnection();

    void closeConnection();
    List<Espece> allEspeces();

    Espece getEspeceByName(String nomEspece);
    
    int add(Espece espece);

    int edit(Espece espece);

    int remove(String nomEspece);
}
