package powerup.bootcamp_platform.domain.api.usecases;

import powerup.bootcamp_platform.domain.api.ICapabilityTechnologyCollaborationServicePort;
import powerup.bootcamp_platform.domain.model.Capability;
import powerup.bootcamp_platform.domain.spi.ICapabilityTechnologyCollaborationPersistencePort;

public class CapabilityTechnologyCollaborationUseCase implements ICapabilityTechnologyCollaborationServicePort {
    private final ICapabilityTechnologyCollaborationPersistencePort capabilityTechnologyCollaborationPersistencePort;

    public CapabilityTechnologyCollaborationUseCase(ICapabilityTechnologyCollaborationPersistencePort capabilityTechnologyCollaborationPersistencePort) {
        this.capabilityTechnologyCollaborationPersistencePort = capabilityTechnologyCollaborationPersistencePort;
    }

    @Override
    public Capability assignTechnologyToCapability(Long capabilityId, Long technologyId) {
        return capabilityTechnologyCollaborationPersistencePort.assignTechnologyToCapability(capabilityId, technologyId);
    }
}
