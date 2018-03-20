package th.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import th.database.service.HotelService;
import th.model.entities.Hotel;

@Component
public class HotelConverter implements Converter<String, Hotel> {

    @Autowired
    private HotelService hotelService;

    @Override
    public Hotel convert(String id) {
        return hotelService.findById(Integer.parseInt(id));
    }
}
