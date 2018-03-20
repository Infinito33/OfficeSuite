package th.database.dao;

import th.model.entities.Place;

import java.util.Date;
import java.util.List;

/**
 * Interface for place data access methods.
 *
 * @author tomasz.huchro
 */
public interface PlaceDao extends IDao<Place> {

    List<Place> findByCountry(String country);

    List<Place> findByCity(String city);

    List<Place> findByIsland(String island);

    List<Place> findByInformationLike(String information);

    List<Place> findByCreationDate(Date creationDate);

}