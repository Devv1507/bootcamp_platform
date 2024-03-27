package powerup.bootcamp_platform.domain.api.usecases;

import powerup.bootcamp_platform.domain.api.ICapabilityServicePort;
import powerup.bootcamp_platform.domain.model.Capability;
import powerup.bootcamp_platform.domain.spi.ICapabilityPersistentPort;

import java.util.List;

public class CapabilityUseCase implements ICapabilityServicePort {
    private final ICapabilityPersistentPort capabilityPersistentPort;

    public CapabilityUseCase(ICapabilityPersistentPort capabilityPersistentPort) {
        this.capabilityPersistentPort = capabilityPersistentPort;
    }

    @Override
    public void saveCapability(Capability capability, List<Long> technologyIds) {
        capabilityPersistentPort.saveCapability(capability, technologyIds);
    }

    @Override
    public Capability getCapability(String name) {
        return capabilityPersistentPort.getCapability(name);
    }

    @Override
    public List<Capability> getAllCapabilities(Integer page, Integer size, String sort) {
        return capabilityPersistentPort.getAllCapabilities(page, size, sort);
    }

    @Override
    public Capability updateCapability(Capability capability) {
        return capabilityPersistentPort.updateCapability(capability);
    }

    @Override
    public void deleteCapability(Long id) {
        capabilityPersistentPort.deleteCapability(id);
    }

   @Override
    public Capability assignTechnologyToCapability(Long capabilityId, Long technologyId) {
        return capabilityPersistentPort.assignTechnologyToCapability(capabilityId, technologyId);
    }


    /*@Override
    public void saveCapabilityByTechnologiesId(Long technologyId, Capability capability) {
        capabilityPersistentPort.saveCapabilityByTechnologiesId(technologyId, capability);
    }*/
}
