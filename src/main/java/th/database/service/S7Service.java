package th.database.service;

import th.model.entities.S7;

import java.util.Date;
import java.util.List;

public interface S7Service extends IService<S7> {

    S7 findByPolicyId(int policyId);

    S7 findByCardNumber(int cardNumber);

    List<S7> findByInformationLike(String information);

    List<S7> findByCreationDate(Date creationDate);
}
