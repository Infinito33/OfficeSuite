package th.database.dao.impl;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.S7Dao;
import th.model.entities.S7;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * S7 dao implementation.
 *
 * @author tomasz.huchro
 */
@Repository
@Transactional
public class S7DaoImpl extends AbstractDao<Integer, S7> implements S7Dao {

    private static final Logger LOG = Logger.getLogger(S7DaoImpl.class.getName());

    public S7DaoImpl() {
        LOG.info("S7DaoImpl created.");
    }

    public S7 findByPolicyId(int policyId) {
        return (S7) this.createEntityCriteria().add(Restrictions.eq("policyId", policyId)).uniqueResult();
    }

    public S7 findByCardNumber(int cardNumber) {
        return (S7) this.createEntityCriteria().add(Restrictions.eq("cardNumber", cardNumber)).uniqueResult();
    }

    public List<S7> findByInformationLike(String information) {
        return this.createEntityCriteria().add(Restrictions.like("information", information)).list();
    }

    public List<S7> findByCreationDate(Date creationDate) {
        return this.createEntityCriteria().add(Restrictions.eq("creationDate", creationDate)).list();
    }

    public void initEntityRelations(S7 s7) {
        this.getSession().refresh(s7);
        Hibernate.initialize(s7.getClient());
    }

}