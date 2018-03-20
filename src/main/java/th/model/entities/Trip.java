package th.model.entities;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class which represents trip from database table called "trip".
 *
 * @author tomasz.huchro
 */
@Entity
@Table(name = "trip")
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Basic(optional = false)
    @Column(name = "cost")
    private int cost;

    @Basic(optional = false)
    @Column(name = "profit")
    private int profit;

    @Basic(optional = false)
    @Column(name = "organisator")
    private String organisator;

    @Column(name = "period")
    private Integer period;

    @Column(name = "food")
    private String food;

    @Column(name = "transport")
    private String transport;

    @Basic(optional = false)
    @Column(name = "persons")
    private int persons;

    @Column(name = "kidsAmount")
    private Integer kidsAmount;

    @Column(name = "kidAge1")
    private Integer kidAge1;

    @Column(name = "kidAge2")
    private Integer kidAge2;

    @Column(name = "kidAge3")
    private Integer kidAge3;

    @Column(name = "kidAge4")
    private Integer kidAge4;

    @Basic(optional = false)
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    @JoinColumn(name = "idHotel", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;

    @JoinColumn(name = "idPlace", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Place place;

    public Trip() {
    }

    public Trip(Integer id) {
        this.id = id;
    }

    public Trip(Integer id, Date date, int cost, int profit, String organisator, int persons, Date creationDate) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.profit = profit;
        this.organisator = organisator;
        this.persons = persons;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getOrganisator() {
        return organisator;
    }

    public void setOrganisator(String organisator) {
        this.organisator = organisator;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public Integer getKidsAmount() {
        return kidsAmount;
    }

    public void setKidsAmount(Integer kidsAmount) {
        this.kidsAmount = kidsAmount;
    }

    public Integer getKidAge1() {
        return kidAge1;
    }

    public void setKidAge1(Integer kidAge1) {
        this.kidAge1 = kidAge1;
    }

    public Integer getKidAge2() {
        return kidAge2;
    }

    public void setKidAge2(Integer kidAge2) {
        this.kidAge2 = kidAge2;
    }

    public Integer getKidAge3() {
        return kidAge3;
    }

    public void setKidAge3(Integer kidAge3) {
        this.kidAge3 = kidAge3;
    }

    public Integer getKidAge4() {
        return kidAge4;
    }

    public void setKidAge4(Integer kidAge4) {
        this.kidAge4 = kidAge4;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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
        if (!(object instanceof Trip)) {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder("");
//        String name = "null";
//        String lastName = "null";
//        String country = "null";
//        String city = "null";
//        if(!(client instanceof HibernateProxy)) {
//            name = client.getName();
//            lastName = client.getLastname();
//        }
//        builder.append(name).append(lastName);
////        if(client != null) {
////            builder.append(client.getName()).append(" ").append(client.getLastname()).append(" - ").append(date).append(" (").append(place.getCountry()).append(", ").append(place.getCity());
////        }
//        System.out.println(builder.toString());
//        return builder.toString();
//    }

}
