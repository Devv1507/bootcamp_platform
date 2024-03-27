package powerup.bootcamp_platform.domain.spi;

import powerup.bootcamp_platform.domain.model.Capability;

public interface ICapabilityTechnologyCollaborationPersistencePort {
    Capability assignTechnologyToCapability(Long capabilityId, Long technologyId);
}
