package powerup.bootcamp_platform.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;
import powerup.bootcamp_platform.domain.model.Technology;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class AddCapabilityRequest {
    private Long id;
    @NotBlank(message = "Name shouldn't be null or empty")
    @Size(max = 50, message = "Name should not exceed 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Name should only contain alphanumeric characters")
    private String name;
    @Size(max = 90, message = "Description should not exceed 90 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Description should only contain alphanumeric characters")
    private String description;
    @Size(max= 20, min = 3)
    private Set<TechnologyEntity> technologies;

    private List<Long> technologyIds;
    // the technologies part is missing
}
