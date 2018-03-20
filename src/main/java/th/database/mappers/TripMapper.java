package th.database.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import th.database.dto.TripDto;
import th.model.entities.Trip;

/**
 * DTO mapper for {@link th.model.entities.Trip} entity class.
 *
 * @author tomasz.huchro, 2016-09-03.
 * @version 1.0
 */
@Component
public class TripMapper extends ConfigurableMapper {

    private static final Logger LOG = Logger.getLogger(TripMapper.class.getName());

    public TripMapper() {
        LOG.info("Trip mapper created.");
    }

    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(
                factory.classMap(Trip.class, TripDto.class)
                        .field("client.name", "clientName")
                        .field("client.lastname", "clientLastname")
                        .field("hotel.hotelName", "hotelName")
                        .field("place.country", "country")
                        .byDefault().toClassMap());
    }

    public List<TripDto> getTripDtoList(
            List<Trip> tripList) {
        List<TripDto> tripDtoList = new ArrayList<>();

        for (Trip trip : tripList) {
            tripDtoList.add(getTripDto(trip));
        }
        return tripDtoList;
    }

    public TripDto getTripDto(Trip trip) {
        TripDto tripDto = new TripDto();
        map(trip, tripDto);
        return tripDto;
    }
}