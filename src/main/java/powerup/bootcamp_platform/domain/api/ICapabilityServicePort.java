package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.Capability;
import java.util.List;

public interface ICapabilityServicePort {
    void saveCapability(Capability capability, List<Long> technologyIds);
    Capability getCapability(String name);
    List<Capability> getAllCapabilities(Integer page, Integer size, String sortField);
    Capability updateCapability(Capability capability);
    void deleteCapability(Long id);

    Capability assignTechnologyToCapability(Long capabilityId, Long technologyId);

    /*void saveCapabilityByTechnologiesId(Long technologyId, Capability capability);*/
}
