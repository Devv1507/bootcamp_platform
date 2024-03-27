package powerup.bootcamp_platform.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;
import powerup.bootcamp_platform.domain.model.Technology;

import java.util.Set;

@AllArgsConstructor
@Getter
public class CapabilityResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final Set<TechnologyEntity> technologies;
    // List technologies
}
