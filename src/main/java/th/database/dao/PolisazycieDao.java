package th.database.dao;

import th.model.entities.Polisazycie;

import java.util.Date;
import java.util.List;

/**
 * Interface for polisazycie data access methods.
 *
 * @author tomasz.huchro
 */
public interface PolisazycieDao extends IDao<Polisazycie> {

    Polisazycie findByPolicyNumber(int policyNumber);

    List<Polisazycie> findByInformationLike(String information);

    List<Polisazycie> findByCreationDate(Date creationDate);

}
