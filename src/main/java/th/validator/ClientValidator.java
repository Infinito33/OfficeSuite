package th.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import th.model.entities.Client;

import java.util.regex.Pattern;

@Component
public class ClientValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "client.lastname.empty");
        Client client = (Client) target;

        Pattern mailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        if(client.getEmail() == null || (client.getEmail().isEmpty() || !mailPattern.matcher(client.getEmail()).matches())) {
            errors.rejectValue("email", "client.email.invalid");
        }

        Pattern phonePattern = Pattern.compile("[0-9]{7,9}");
        if(client.getPhone() == null || !phonePattern.matcher("" + client.getPhone()).matches()) {
            errors.rejectValue("phone", "client.phone.invalid");
        }

        if(client.getInformation().length() > 1000) {
            errors.rejectValue("information", "information.length");
        }
    }
}
