package th.database.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.ClientDao;
import th.database.service.AbstractService;
import th.database.service.ClientService;
import th.model.entities.Client;

/**
 * Service responsible for management of client entity.
 *
 * @author tomasz.huchro
 */
@Service
@Transactional
public class ClientServiceImpl extends AbstractService<Client, ClientDao> implements ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class.getName());

    private ClientDao dao;

    @Autowired
    public ClientServiceImpl(ClientDao dao) {
        this.dao = dao;
        LOG.info("Client service created.");
    }

    public List<Client> findByName(String name) {
        return dao.findByName(name);
    }

    public List<Client> findByLastname(String lastname) {
        return dao.findByLastname(lastname);
    }

    public List<Client> findByEmail(String email) {
        return dao.findByEmail(email);
    }

    public List<Client> findByPhone(Integer phone) {
        return dao.findByPhone(phone);
    }

    public List<Client> findByCreationDate(Date creationDate) {
        return dao.findByCreationDate(creationDate);
    }

    public List<Client> findByAddrPostal(String addrPostal) {
        return dao.findByAdrrPostal(addrPostal);
    }

    public List<Client> findByAddrHome(String addrHome) {
        return dao.findByAdrrHome(addrHome);
    }

    public List<Client> findByCompany(String company) {
        return dao.findByCompany(company);
    }
}