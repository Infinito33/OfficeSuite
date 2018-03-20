package th.database.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.PlaceDao;
import th.model.entities.Place;

/**
 * Place dao implementation.
 *
 * @author tomasz.huchro
 */
@Repository
@Transactional
public class PlaceDaoImpl extends AbstractDao<Integer, Place> implements PlaceDao {

    private static final Logger LOG = Logger.getLogger(PlaceDaoImpl.class.getName());

    public PlaceDaoImpl() {
        LOG.info("PlaceDaoImpl created.");
    }

    public List<Place> findByCountry(String country) {
        return this.createEntityCriteria().add(Restrictions.eq("country", country)).list();
    }

    public List<Place> findByCity(String city) {
        return this.createEntityCriteria().add(Restrictions.eq("city", city)).list();
    }

    public List<Place> findByIsland(String island) {
        return this.createEntityCriteria().add(Restrictions.eq("island", island)).list();
    }

    public List<Place> findByInformationLike(String information) {
        return this.createEntityCriteria().add(Restrictions.like("information", information)).list();
    }

    public List<Place> findByCreationDate(Date creationDate) {
        return this.createEntityCriteria().add(Restrictions.eq("creationDate", creationDate)).list();
    }

    public void initEntityRelations(Place place) {
        this.getSession().refresh(place);
        Hibernate.initialize(place.getHotelSet());
        Hibernate.initialize(place.getTripSet());
    }

}