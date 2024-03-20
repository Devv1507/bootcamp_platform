package powerup.bootcamp_platform.adapters.driving.http.controllers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ExceptionResponse {
    private final String message;
    private final String status;
    private final LocalDateTime timestamp;
    private List<ValidationError> errors;

    // to validation purpose
    @Getter
    @RequiredArgsConstructor
    private static class ValidationError {
        private final String field;
        private final String message;
    }
    public void addValidationError(String field, String message){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }
}
