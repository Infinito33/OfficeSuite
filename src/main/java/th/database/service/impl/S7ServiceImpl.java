package th.database.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.S7Dao;
import th.database.service.AbstractService;
import th.database.service.S7Service;
import th.model.entities.S7;

/**
 * Service responsible for management of S7 entity.
 *
 * @author tomasz.huchro
 */
@Service
@Transactional
public class S7ServiceImpl extends AbstractService<S7, S7Dao> implements S7Service {

    private static final Logger LOG = Logger.getLogger(S7ServiceImpl.class.getName());

    private S7Dao dao;

    @Autowired
    public S7ServiceImpl(S7Dao dao) {
        this.dao = dao;
        LOG.info("S7 service created.");
    }

    public S7 findByPolicyId(int policyId) {
        return dao.findByPolicyId(policyId);
    }

    public S7 findByCardNumber(int cardNumber) {
        return dao.findByCardNumber(cardNumber);
    }

    public List<S7> findByInformationLike(String information) {
        return dao.findByInformationLike(information);
    }

    public List<S7> findByCreationDate(Date creationDate) {
        return dao.findByCreationDate(creationDate);
    }

}