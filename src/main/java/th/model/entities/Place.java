package th.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class which represents place from database table called "place".
 *
 * @author tomasz.huchro
 */
@Entity
@Table(name = "place")
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "country")
    private String country;

    @Basic(optional = false)
    @Column(name = "city")
    private String city;

    @Column(name = "island")
    private String island;

    @Column(name = "information")
    private String information;

    @Basic(optional = false)
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place", fetch = FetchType.LAZY)
    private Set<Hotel> hotelSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place", fetch = FetchType.LAZY)
    private Set<Trip> tripSet;

    public Place() {
    }

    public Place(Integer id) {
        this.id = id;
    }

    public Place(Integer id, String country, String city, Date creationDate) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIsland() {
        return island;
    }

    public void setIsland(String island) {
        this.island = island;
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

    public Set<Hotel> getHotelSet() {
        return hotelSet;
    }

    public void setHotelSet(Set<Hotel> hotelSet) {
        this.hotelSet = hotelSet;
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
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        String country = "null";
//        String city = "null";
//
//
////        builder.append(country == null ? "" : country).append(" - ").append(city == null ? "" : city);
////        if (island != null && !island.isEmpty()) {
////            builder.append(" (").append(island).append(")");
////        }
//        return builder.toString();
//    }

}
