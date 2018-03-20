package th.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import th.model.entities.S7;

@Component
public class S7Validator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return S7.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
