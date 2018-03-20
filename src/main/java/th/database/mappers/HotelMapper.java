package th.database.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import th.database.dto.HotelDto;
import th.model.entities.Hotel;

/**
 * DTO mapper for {@link Hotel} entity class.
 *
 * @author tomasz.huchro, 2016-09-03.
 * @version 1.0
 */
@Component
public class HotelMapper extends ConfigurableMapper {

    private static final Logger LOG = Logger.getLogger(HotelMapper.class.getName());

    public HotelMapper() {
        LOG.info("Hotel mapper created.");
    }

    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(
                factory.classMap(Hotel.class, HotelDto.class)
                        .field("place.city", "city")
                        .field("place.country", "country")
                        .byDefault().toClassMap());
    }

    public List<HotelDto> getHotelDtoList(
            List<Hotel> hotelList) {
        List<HotelDto> hotelDtoList = new ArrayList<>();

        for (Hotel hotel : hotelList) {
            hotelDtoList.add(getHotelDto(hotel));
        }
        return hotelDtoList;
    }

    public HotelDto getHotelDto(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        map(hotel, hotelDto);
        return hotelDto;
    }

}
