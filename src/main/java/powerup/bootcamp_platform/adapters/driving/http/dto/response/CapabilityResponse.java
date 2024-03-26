package powerup.bootcamp_platform.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CapabilityResponse {
    private final Long id;
    private final String name;
    private final String description;
    // List technologies
}
