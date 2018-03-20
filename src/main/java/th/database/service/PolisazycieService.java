package th.database.service;

import th.model.entities.Polisazycie;

import java.util.Date;
import java.util.List;

public interface PolisazycieService extends IService<Polisazycie> {

    Polisazycie findByPolicyNumber(int policyNumber);

    List<Polisazycie> findByInformationLike(String information);

    List<Polisazycie> findByCreationDate(Date creationDate);
}
