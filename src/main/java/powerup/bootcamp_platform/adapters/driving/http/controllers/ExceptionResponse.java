package powerup.bootcamp_platform.adapters.driving.http.controllers;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ExceptionResponse {
    private final String message;
    private final String status;
    private final LocalDateTime timestamp;
    private List<ValidationError> errors;

    // to validation purpose
    @Getter
    @Setter
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
