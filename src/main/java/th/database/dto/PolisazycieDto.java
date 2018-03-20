package th.database.dto;

import java.util.Date;

/**
 * Data transfer object for {@link th.model.entities.Polisazycie} entity.
 *
 * @author tomasz.huchro, 2016-09-03.
 */
public class PolisazycieDto {

    private Integer id;

    private int policyNumber;

    private String information;

    private Date creationDate;

    private String clientName;

    private String clientLastname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
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

}

