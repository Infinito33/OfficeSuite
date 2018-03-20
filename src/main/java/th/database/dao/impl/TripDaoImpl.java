package th.database.dao.impl;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.TripDao;
import th.model.entities.Client;
import th.model.entities.Trip;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Trip dao implementation.
 *
 * @author tomasz.huchro
 */
@Repository
@Transactional
public class TripDaoImpl extends AbstractDao<Integer, Trip> implements TripDao {

    private static final Logger LOG = Logger.getLogger(TripDaoImpl.class.getName());

    public TripDaoImpl() {
        LOG.info("TripDaoImpl created.");
    }

    public List<Trip> findByDate(Date date) {
        return this.createEntityCriteria().add(Restrictions.eq("date", date)).list();
    }

    public List<Trip> findByCost(int cost) {
        return this.createEntityCriteria().add(Restrictions.eq("cost", cost)).list();
    }

    public List<Trip> findByProfit(int profit) {
        return this.createEntityCriteria().add(Restrictions.eq("profit", profit)).list();
    }

    public List<Trip> findByOrganisator(String organisator) {
        return this.createEntityCriteria().add(Restrictions.eq("organisator", organisator)).list();
    }

    public List<Trip> findByPeriod(int period) {
        return this.createEntityCriteria().add(Restrictions.eq("period", period)).list();
    }

    public List<Trip> findByFood(String food) {
        return this.createEntityCriteria().add(Restrictions.eq("food", food)).list();
    }

    public List<Trip> findByTransport(String transport) {
        return this.createEntityCriteria().add(Restrictions.eq("transport", transport)).list();
    }

    public List<Trip> findByPersons(int persons) {
        return this.createEntityCriteria().add(Restrictions.eq("persons", persons)).list();
    }

    public List<Trip> findByCreationDate(Date creationDate) {
        return this.createEntityCriteria().add(Restrictions.eq("creationDate", creationDate)).list();
    }

    @Override
    public List findByClientId(int id) {
        String hql = "from Trip where idClient = :id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id", id);
        List trips = query.list();
        initListRelations(trips);
        return query.list();
    }

    public void initEntityRelations(Trip trip) {
        this.getSession().refresh(trip);
        Hibernate.initialize(trip.getClient());
        Hibernate.initialize(trip.getHotel());
        Hibernate.initialize(trip.getPlace());
    }

}