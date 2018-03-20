package th.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import th.model.entities.Polisazycie;

@Component
public class PolisazycieValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Polisazycie.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "policyNumber", "polisazycie.number.empty");

        Polisazycie polisazycie = (Polisazycie) target;

        if(polisazycie.getPolicyNumber() < 1) {
            errors.rejectValue("policyNumber", "polisazycie.number.wrong");
        }

        if(polisazycie.getInformation().length() > 1000) {
            errors.rejectValue("information", "information.invalid");
        }




    }
}
