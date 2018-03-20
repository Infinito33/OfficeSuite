package th.database.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.HotelDao;
import th.database.service.AbstractService;
import th.database.service.HotelService;
import th.model.entities.Hotel;

/**
 * Service responsible for management of hotel entity.
 *
 * @author tomasz.huchro
 */
@Service
@Transactional
public class HotelServiceImpl extends AbstractService<Hotel, HotelDao> implements HotelService {

    private static final Logger LOG = Logger.getLogger(HotelServiceImpl.class.getName());

    private HotelDao dao;

    @Autowired
    public HotelServiceImpl(HotelDao dao) {
        this.dao = dao;
        LOG.info("Hotel service created.");
    }

    public List<Hotel> findByName(String hotelName) {
        return dao.findByName(hotelName);
    }

    public List<Hotel> findByStarsCount(Double starsCount) {
        return dao.findByStarsCount(starsCount);
    }

    public List<Hotel> findByRating(Integer rating) {
        return dao.findByRating(rating);
    }

    public List<Hotel> findByRecommendation(Boolean recommendation) {
        return dao.findByRecommendation(recommendation);
    }

    public List<Hotel> findByInformationLike(String information) {
        return dao.findByInformationLike(information);
    }

    public List<Hotel> findByCreationDate(Date creationDate) {
        return dao.findByCreationDate(creationDate);
    }

}