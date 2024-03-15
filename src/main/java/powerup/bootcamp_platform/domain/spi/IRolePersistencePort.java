package powerup.bootcamp_platform.domain.spi;

import powerup.bootcamp_platform.domain.model.Role;
import java.util.List;

public interface IRolePersistencePort {
    List<Role> getAllRoles();
}
