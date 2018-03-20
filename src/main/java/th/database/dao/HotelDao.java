package th.database.dao;

import th.model.entities.Hotel;

import java.util.Date;
import java.util.List;

/**
 * Interface for hotel data access methods.
 *
 * @author tomasz.huchro, 2016-03-15
 */
public interface HotelDao extends IDao<Hotel> {

    List<Hotel> findByName(String name);

    List<Hotel> findByStarsCount(Double starsCount);

    List<Hotel> findByRating(Integer rating);

    List<Hotel> findByRecommendation(Boolean recommendation);

    List<Hotel> findByInformationLike(String information);

    List<Hotel> findByCreationDate(Date creationDate);

}