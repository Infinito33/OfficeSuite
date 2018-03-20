package th.database.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.PolisazycieDao;
import th.model.entities.Polisazycie;

/**
 * Polisazycie dao implementation.
 *
 * @author tomasz.huchro
 */
@Repository
@Transactional
public class PolisazycieDaoImpl extends AbstractDao<Integer, Polisazycie> implements PolisazycieDao {

    private static final Logger LOG = Logger.getLogger(PolisazycieDaoImpl.class.getName());

    public PolisazycieDaoImpl() {
        LOG.info("PolisazycieDaoImpl created.");
    }

    public Polisazycie findByPolicyNumber(int policyNumber) {
        return (Polisazycie) this.createEntityCriteria().add(Restrictions.eq("policyNumber", policyNumber)).uniqueResult();
    }

    public List<Polisazycie> findByInformationLike(String information) {
        return this.createEntityCriteria().add(Restrictions.like("information", information)).list();
    }

    public List<Polisazycie> findByCreationDate(Date creationDate) {
        return this.createEntityCriteria().add(Restrictions.eq("creationDate", creationDate)).list();
    }

    public void initEntityRelations(Polisazycie polisazycie) {
        this.getSession().refresh(polisazycie);
        Hibernate.initialize(polisazycie.getClient());
    }

}