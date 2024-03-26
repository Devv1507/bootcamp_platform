package powerup.bootcamp_platform.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
public class AddTechnologyRequest {
        @NotNull
        private Long id;
        @NotBlank(message = "username shouldn't be null or empty")
        @Size(max = 50, message = "Name should not exceed 50 characters")
        @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Name should only contain alphanumeric characters")
        private String name;
        @Size(max = 90, message = "Description should not exceed 90 characters")
        @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Description should only contain alphanumeric characters")
        private String description;
}
