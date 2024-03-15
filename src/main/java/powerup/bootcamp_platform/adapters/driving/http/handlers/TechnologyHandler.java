package powerup.bootcamp_platform.adapters.driving.http.handlers;


import org.springframework.validation.Errors;
import powerup.bootcamp_platform.adapters.driving.http.dto.request.AddTechnologyRequest;/*
public class ExampleValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz){
        return AddTechnologyRequest.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        AddTechnologyRequest res = (AddTechnologyRequest) target;
        if (res.getName() == null || res.getName().trim().isEmpty()) {
            errors.rejectValue("param1", "field.required", "El campo param1 es requerido");
        }
        if (res.getDescription() == null ) {
            errors.rejectValue("param2", "field.invalid", "El campo param2 es inválido");
        }
    }
}
*/