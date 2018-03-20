package th.model.entities;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

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
 * Entity class which represents client from database table called "client".
 *
 * @author tomasz.huchro
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    @Email(message = "{client.email.invalid}")
    private String email;

    @Column(name = "birthDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Basic(optional = false)
    @Column(name = "sex")
    private Integer sex;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "addrPostal")
    private String addrPostal;

    @Column(name = "addrHome")
    private String addrHome;

    @Column(name = "company")
    private String company;

    @Column(name = "information")
    private String information;

    @Basic(optional = false)
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Trip> tripSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private Set<S7> s7Set;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Polisazycie> polisy;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String name, String lastname, Integer sex, Date creationDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.creationDate = creationDate;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddrPostal() {
        return addrPostal;
    }

    public void setAddrPostal(String addrPostal) {
        this.addrPostal = addrPostal;
    }

    public String getAddrHome() {
        return addrHome;
    }

    public void setAddrHome(String addrHome) {
        this.addrHome = addrHome;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Set<Polisazycie> getPolisy() {
        return polisy;
    }

    public void setPolisy(Set<Polisazycie> polisy) {
        this.polisy = polisy;
    }

    public Set<S7> getS7Set() {
        return s7Set;
    }

    public void setS7Set(Set<S7> s7Set) {
        this.s7Set = s7Set;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(name).append(" ").append(lastname);
//        return builder.toString();
//    }

    public static Client parseClient(Object client) {
        return (Client) client;
    }

    public void copyClientWithNewData(Client newClient) {
        newClient.setName(this.name);
        newClient.setLastname(this.lastname);
        newClient.setId(this.id);
        newClient.setEmail(this.email);
        newClient.setAddrHome(this.addrHome);
        newClient.setAddrPostal(this.addrPostal);
        newClient.setCompany(this.company);
        newClient.setCreationDate(new Date());
        newClient.setPhone(this.phone);
        newClient.setBirthDate(this.birthDate);
        newClient.setSex(this.sex);
        newClient.setInformation(this.information);
    }

}