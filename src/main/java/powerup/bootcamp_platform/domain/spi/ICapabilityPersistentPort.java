package powerup.bootcamp_platform.domain.spi;

import powerup.bootcamp_platform.domain.model.Capability;
import java.util.List;

public interface ICapabilityPersistentPort {
    void saveCapability(Capability capability);
    Capability getCapability(String name);
    List<Capability> getAllCapabilities(Integer page, Integer size, String sortField);
    Capability updateCapability(Capability capability);
    void deleteCapability(Long id);
}
