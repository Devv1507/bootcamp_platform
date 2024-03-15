package powerup.bootcamp_platform.adapters.driving.http.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import powerup.bootcamp_platform.adapters.driving.http.controllers.TechnologyRestControllerAdapter;
import powerup.bootcamp_platform.domain.api.ITechnologyServicePort;

@AllArgsConstructor
@Getter
public class AddTechnologyRequest {
        @NotNull
        private Long id;
        @NotBlank(message = "username shouldn't be null or empty")
        @Size(max = 50, message = "Name should not exceed 50 characters")
        @Pattern(regexp = "^[a-zA-Z0-9]{1,50}$", message = "Name should only contain alphanumeric characters")
        private String name;
        @Size(max = 90, message = "Description should not exceed 90 characters")
        @Pattern(regexp = "^[a-zA-Z0-9]{1,90}$", message = "Description should only contain alphanumeric characters")
        private String description;
        private String address;
}
