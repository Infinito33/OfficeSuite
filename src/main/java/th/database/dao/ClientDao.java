package th.database.dao;

import th.model.entities.Client;

import java.util.Date;
import java.util.List;

/**
 * Interface for client data access methods.
 *
 * @author tomasz.huchro, 2016-03-15
 */
public interface ClientDao extends IDao<Client> {

    List<Client> findByName(String name);

    List<Client> findByLastname(String lastname);

    List<Client> findByEmail(String email);

    List<Client> findByCompany(String company);

    List<Client> findByPhone(Integer phone);

    List<Client> findByAdrrHome(String adrrHome);

    List<Client> findByAdrrPostal(String adrrPostal);

    List<Client> findByCreationDate(Date creationDate);

}