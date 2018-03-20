package th.database.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.HotelDao;
import th.model.entities.Hotel;

/**
 * Hotel dao implementation.
 *
 * @author tomasz.huchro
 */
@Repository
@Transactional
public class HotelDaoImpl extends AbstractDao<Integer, Hotel> implements HotelDao {

    private static final Logger LOG = Logger.getLogger(HotelDaoImpl.class.getName());

    public HotelDaoImpl() {
        LOG.info("HotelDaoImpl created.");
    }

    public List<Hotel> findByName(String hotelName) {
        return this.createEntityCriteria().add(Restrictions.eq("hotelName", hotelName)).list();
    }

    public List<Hotel> findByStarsCount(Double starsCount) {
        return this.createEntityCriteria().add(Restrictions.eq("starsCount", starsCount)).list();
    }

    public List<Hotel> findByRating(Integer rating) {
        return this.createEntityCriteria().add(Restrictions.eq("rating", rating)).list();
    }

    public List<Hotel> findByRecommendation(Boolean recommendation) {
        return this.createEntityCriteria().add(Restrictions.eq("recommendation", recommendation)).list();
    }

    public List<Hotel> findByInformationLike(String information) {
        return this.createEntityCriteria().add(Restrictions.like("information", "%" + information + "%")).list();
    }

    public List<Hotel> findByCreationDate(Date creationDate) {
        return this.createEntityCriteria().add(Restrictions.eq("creationDate", creationDate)).list();
    }

    @Transactional
    public void initEntityRelations(Hotel hotel) {
        this.getSession().refresh(hotel);
        Hibernate.initialize(hotel.getPlace());
        Hibernate.initialize(hotel.getTripSet());
    }

}