package th.database.service.impl;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.database.dao.PlaceDao;
import th.database.service.AbstractService;
import th.database.service.PlaceService;
import th.model.entities.Place;

/**
 * Service responsible for management of place entity.
 *
 * @author tomasz.huchro
 */
@Service
@Transactional
public class PlaceServiceImpl extends AbstractService<Place, PlaceDao> implements PlaceService {

    private static final Logger LOG = Logger.getLogger(PlaceServiceImpl.class.getName());

    private PlaceDao dao;

    @Autowired
    public PlaceServiceImpl(PlaceDao dao) {
        this.dao = dao;
        LOG.info("Place service created.");
    }

    public List<Place> findByCountry(String country) {
        return dao.findByCountry(country);
    }

    public List<Place> findByCity(String city) {
        return dao.findByCity(city);
    }

    public List<Place> findByIsland(String island) {
        return dao.findByIsland(island);
    }

    public List<Place> findByInformationLike(String information) {
        return dao.findByInformationLike(information);
    }

    public List<Place> findByCreationDate(Date creationDate) {
        return dao.findByCreationDate(creationDate);
    }

}
