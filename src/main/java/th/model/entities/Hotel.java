package th.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class which represents hotel from database table called "hotel".
 *
 * @author tomasz.huchro
 */
@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "hotelName")
    private String hotelName;

    @Basic(optional = false)
    @Column(name = "starsCount")
    private double starsCount;

    @Column(name = "rating")
    private Integer rating;

    @Basic(optional = false)
    @Column(name = "recommendation")
    private boolean recommendation;

    @Column(name = "information")
    private String information;

    @Basic(optional = false)
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @JoinColumn(name = "idPlace", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Place place;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private Set<Trip> tripSet;

    public Hotel() {
    }

    public Hotel(Integer id) {
        this.id = id;
    }

    public Hotel(Integer id, String hotelName, double starsCount, boolean recommendation, Date creationDate) {
        this.id = id;
        this.hotelName = hotelName;
        this.starsCount = starsCount;
        this.recommendation = recommendation;
        this.creationDate = creationDate;
    }

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

    public boolean getRecommendation() {
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(hotelName == null ? "" : hotelName).append(" (");
//        if(place != null) {
//            builder.append(place.getCountry()).append(", ").append(place.getCity()).append(")");
//        }
//        return builder.toString();
//    }

}