package th.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.PolisazycieDao;
import th.database.service.AbstractService;
import th.database.service.PolisazycieService;
import th.model.entities.Polisazycie;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Service responsible for management of polisazycie entity.
 *
 * @author tomasz.huchro
 */
@Service
@Transactional
public class PolisazycieServiceImpl extends AbstractService<Polisazycie, PolisazycieDao> implements PolisazycieService {

    private static final Logger LOG = Logger.getLogger(PolisazycieServiceImpl.class.getName());

    private PolisazycieDao dao;

    @Autowired
    public PolisazycieServiceImpl(PolisazycieDao dao) {
        this.dao = dao;
        LOG.info("Polisazycie service created.");
    }

    public Polisazycie findByPolicyNumber(int policyNumber) {
        return dao.findByPolicyNumber(policyNumber);
    }

    public List<Polisazycie> findByInformationLike(String information) {
        return dao.findByInformationLike(information);
    }

    public List<Polisazycie> findByCreationDate(Date creationDate) {
        return dao.findByCreationDate(creationDate);
    }

}