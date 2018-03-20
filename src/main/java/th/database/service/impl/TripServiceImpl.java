package th.database.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.TripDao;
import th.database.service.AbstractService;
import th.database.service.TripService;
import th.model.entities.Trip;

/**
 * Service responsible for management of client entity.
 *
 * @author tomasz.huchro
 */
@Service
@Transactional
public class TripServiceImpl extends AbstractService<Trip, TripDao> implements TripService {

    private static final Logger LOG = Logger.getLogger(TripServiceImpl.class.getName());

    private TripDao dao;

    @Autowired
    public TripServiceImpl(TripDao dao) {
        this.dao = dao;
        LOG.info("Trip service created.");
    }

    public List<Trip> findByDate(Date date) {
        return dao.findByDate(date);
    }

    public List<Trip> findByCost(int cost) {
        return dao.findByCost(cost);
    }

    public List<Trip> findByProfit(int profit) {
        return dao.findByProfit(profit);
    }

    public List<Trip> findByOrganisator(String organisator) {
        return dao.findByOrganisator(organisator);
    }

    public List<Trip> findByPeriod(int period) {
        return dao.findByPeriod(period);
    }

    public List<Trip> findByFood(String food) {
        return dao.findByFood(food);
    }

    public List<Trip> findByTransport(String transport) {
        return dao.findByTransport(transport);
    }

    public List<Trip> findByPersons(int persons) {
        return dao.findByPersons(persons);
    }

    public List<Trip> findByCreationDate(Date creationDate) {
        return dao.findByCreationDate(creationDate);
    }

    @Override
    public List findByClientId(int id) {
        return dao.findByClientId(id);
    }


}
