package th.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import th.model.entities.Trip;

@Component
public class TripValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Trip.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "trip.date.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", "trip.cost.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profit", "trip.profit.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organisator", "trip.organisator.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persons", "trip.persons.empty");

        Trip trip = (Trip) target;

        if (trip.getCost() < 1) {
            errors.rejectValue("cost", "trip.cost.wrong");
        }

        if (trip.getPersons() < 1) {
            errors.rejectValue("persons", "trip.persons.wrong");
        }

        if (trip.getKidsAmount() == 1 && trip.getKidAge1() < 1) {
            errors.rejectValue("kidAge1", "trip.kidAge1.wrong");
        } else if (trip.getKidsAmount() == 2 && trip.getKidAge1() < 1 && trip.getKidAge2() < 1) {
            errors.rejectValue("kidAge1", "trip.kidAge1.wrong");
            errors.rejectValue("kidAge2", "trip.kidAge2.wrong");
        } else if (trip.getKidsAmount() == 3 && trip.getKidAge1() < 1 && trip.getKidAge2() < 1 && trip.getKidAge3() < 1) {
            errors.rejectValue("kidAge1", "trip.kidAge1.wrong");
            errors.rejectValue("kidAge2", "trip.kidAge2.wrong");
            errors.rejectValue("kidAge3", "trip.kidAge3.wrong");
        } else if (trip.getKidsAmount() == 4 && trip.getKidAge1() < 1 && trip.getKidAge2() < 1 && trip.getKidAge3() < 1 && trip.getKidAge4() < 1) {
            errors.rejectValue("kidAge1", "trip.kidAge1.wrong");
            errors.rejectValue("kidAge2", "trip.kidAge2.wrong");
            errors.rejectValue("kidAge3", "trip.kidAge3.wrong");
            errors.rejectValue("kidAge4", "trip.kidAge4.wrong");
        }
    }
}
