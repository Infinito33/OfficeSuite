package th.database.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.ClientDao;
import th.model.entities.Client;

/**
 * Client dao implementation.
 *
 * @author tomasz.huchro
 */
@Repository
@Transactional
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

    private static final Logger LOG = Logger.getLogger(ClientDaoImpl.class.getName());

    public ClientDaoImpl() {
        LOG.info("ClientDaoImpl created.");
    }

    public List<Client> findByName(String name) {
        return this.createEntityCriteria().add(Restrictions.eq("name", name)).list();
    }

    public List<Client> findByLastname(String lastname) {
        return this.createEntityCriteria().add(Restrictions.eq("lastname", lastname)).list();
    }

    public List<Client> findByEmail(String email) {
        return this.createEntityCriteria().add(Restrictions.eq("email", email)).list();
    }

    public List<Client> findByCompany(String company) {
        return this.createEntityCriteria().add(Restrictions.eq("company", company)).list();
    }

    public List<Client> findByPhone(Integer phone) {
        return this.createEntityCriteria().add(Restrictions.eq("phone", phone)).list();
    }

    public List<Client> findByAdrrHome(String adrrHome) {
        return this.createEntityCriteria().add(Restrictions.eq("adrrHome", adrrHome)).list();
    }

    public List<Client> findByAdrrPostal(String adrrPostal) {
        return this.createEntityCriteria().add(Restrictions.eq("adrrPostal", adrrPostal)).list();
    }

    public List<Client> findByCreationDate(Date creationDate) {
        return this.createEntityCriteria().add(Restrictions.eq("creationDate", creationDate)).list();
    }

    @Transactional
    public void initEntityRelations(Client client) {
        this.getSession().refresh(client);
        Hibernate.initialize(client.getS7Set());
        Hibernate.initialize(client.getPolisy());
        Hibernate.initialize(client.getTripSet());
    }

}