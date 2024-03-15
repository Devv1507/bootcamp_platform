package powerup.bootcamp_platform.adapters.driving.http.dto.response;

import powerup.bootcamp_platform.domain.util.DomainConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TechnologyResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final String address;
}