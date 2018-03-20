package th.database.service;

import th.model.entities.Client;

import java.util.Date;
import java.util.List;

public interface ClientService extends IService<Client> {

    List<Client> findByName(String name);

    List<Client> findByLastname(String lastname);

    List<Client> findByEmail(String email);

    List<Client> findByPhone(Integer phone);

    List<Client> findByCreationDate(Date creationDate);

    List<Client> findByAddrPostal(String addrPostal);

    List<Client> findByAddrHome(String addrHome);

    List<Client> findByCompany(String company);
}
