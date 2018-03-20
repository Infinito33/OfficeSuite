package th.database.service;

import th.model.entities.Place;

import java.util.Date;
import java.util.List;

public interface PlaceService extends IService<Place> {

    List<Place> findByCountry(String country);

    List<Place> findByCity(String city);

    List<Place> findByIsland(String island);

    List<Place> findByInformationLike(String information);

    List<Place> findByCreationDate(Date creationDate);
}
