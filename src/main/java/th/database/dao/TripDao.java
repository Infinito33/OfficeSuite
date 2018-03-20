package th.database.dao;

import th.model.entities.Trip;

import java.util.Date;
import java.util.List;

/**
 * Interface for trip data access methods.
 *
 * @author tomasz.huchro
 */
public interface TripDao extends IDao<Trip> {

    List<Trip> findByDate(Date date);

    List<Trip> findByCost(int cost);

    List<Trip> findByProfit(int profit);

    List<Trip> findByOrganisator(String organisator);

    List<Trip> findByPeriod(int period);

    List<Trip> findByFood(String food);

    List<Trip> findByTransport(String transport);

    List<Trip> findByPersons(int persons);

    List<Trip> findByCreationDate(Date creationDate);

    List findByClientId(int id);

}