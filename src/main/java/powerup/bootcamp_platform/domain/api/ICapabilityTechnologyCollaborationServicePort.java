package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.Capability;

public interface ICapabilityTechnologyCollaborationServicePort {
    Capability assignTechnologyToCapability(Long capabilityId, Long technologyId);
}
