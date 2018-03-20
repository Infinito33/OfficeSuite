package th.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import th.model.entities.Place;

@Component
public class PlaceValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Place.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "place.country.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "place.city.empty");

        Place place = (Place) target;

        if(place.getInformation().length() > 1000) {
            errors.rejectValue("information", "information.invalid");
        }
    }
}
