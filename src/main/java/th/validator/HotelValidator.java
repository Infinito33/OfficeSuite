package th.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import th.model.entities.Hotel;

@Component
public class HotelValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Hotel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hotelName", "hotel.name.empty");
        Hotel hotel = (Hotel) target;

        if(hotel.getRating() < 0 || hotel.getRating() > 10) {
            errors.rejectValue("rating", "hotel.rating.invalid");
        }

        if(hotel.getInformation().length() > 1000) {
            errors.rejectValue("information", "information.invalid");
        }
    }
}
