package powerup.bootcamp_platform.domain.api.usecases;

import powerup.bootcamp_platform.domain.model.Role;
import powerup.bootcamp_platform.domain.api.IRoleServicePort;
import powerup.bootcamp_platform.domain.spi.IRolePersistencePort;
import java.util.List;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public List<Role> getAllRoles() {
        return rolePersistencePort.getAllRoles();
    }

}
