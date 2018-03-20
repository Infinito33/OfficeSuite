package th.database.dto;

import java.util.Date;

/**
 * Data transfer object for {@link th.model.entities.Hotel} entity.
 *
 * @author tomasz.huchro, 2016-09-03.
 */
public class HotelDto {

    private Integer id;

    private String hotelName;

    private double starsCount;

    private Integer rating;

    private boolean recommendation;

    private String information;

    private Date creationDate;

    private String country;

    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(double starsCount) {
        this.starsCount = starsCount;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean isRecommendation() {
        return recommendation;
    }

    public void setRecommendation(boolean recommendation) {
        this.recommendation = recommendation;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

