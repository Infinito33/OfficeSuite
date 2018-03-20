package th.database.service;

import th.model.entities.Hotel;

import java.util.Date;
import java.util.List;

public interface HotelService extends IService<Hotel> {

    public List<Hotel> findByName(String hotelName);

    public List<Hotel> findByStarsCount(Double starsCount);

    public List<Hotel> findByRating(Integer rating);

    public List<Hotel> findByRecommendation(Boolean recommendation);

    public List<Hotel> findByInformationLike(String information);

    public List<Hotel> findByCreationDate(Date creationDate);
}
