package th.model.entities;

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
 * Entity class which represents S7 from database table called "S7".
 *
 * @author tomasz.huchro
 */
@Entity
@Table(name = "s7")
public class S7 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "policyId")
    private int policyId;

    @Basic(optional = false)
    @Column(name = "cardNumber")
    private int cardNumber;

    @Column(name = "information")
    private String information;

    @Basic(optional = false)
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    public S7() {
    }

    public S7(Integer id) {
        this.id = id;
    }

    public S7(Integer id, int policyId, int cardNumber, Date creationDate) {
        this.id = id;
        this.policyId = policyId;
        this.cardNumber = cardNumber;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof S7)) {
            return false;
        }
        S7 other = (S7) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.th.officesuiteservice.model.S7[ id=" + id + " ]" + " policyId = " + policyId + " card number = " + cardNumber;
    }

}
