package th.database.dao;

import th.model.entities.S7;

import java.util.Date;
import java.util.List;

/**
 * Interface for S7 data access methods.
 *
 * @author tomasz.huchro
 */
public interface S7Dao extends IDao<S7> {

    S7 findByPolicyId(int policyId);

    S7 findByCardNumber(int cardNumber);

    List<S7> findByInformationLike(String information);

    List<S7> findByCreationDate(Date creationDate);

}