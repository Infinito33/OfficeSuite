package th.database.dto;

import java.util.Date;

/**
 * Data transfer object for {@link th.model.entities.Trip} entity.
 *
 * @author tomasz.huchro, 2016-09-03.
 */
public class TripDto {

    private Integer id;

    private Date date;

    private int cost;

    private int profit;

    private String organisator;

    private Integer period;

    private String food;

    private String transport;

    private int persons;

    private Integer kidsAmount;

    private Integer kidAge1;

    private Integer kidAge2;

    private Integer kidAge3;

    private Integer kidAge4;

    private Date creationDate;

    private String clientName;

    private String clientLastname;

    private String hotelName;

    private String country;

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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastname() {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname) {
        this.clientLastname = clientLastname;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}