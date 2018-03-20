package th.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import th.database.service.PlaceService;
import th.model.entities.Place;

@Component
public class PlaceConverter implements Converter<String, Place> {

    @Autowired
    private PlaceService placeService;

    @Override
    public Place convert(String id) {
        return placeService.findById(Integer.parseInt(id));
    }
}
