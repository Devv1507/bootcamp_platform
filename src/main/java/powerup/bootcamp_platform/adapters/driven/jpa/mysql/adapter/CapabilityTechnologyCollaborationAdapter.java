package powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.CapabilityEntity;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ICapabilityEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ICapabilityRepository;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ITechnologyRepository;
import powerup.bootcamp_platform.domain.model.Capability;
import powerup.bootcamp_platform.domain.spi.ICapabilityPersistentPort;
import powerup.bootcamp_platform.domain.spi.ICapabilityTechnologyCollaborationPersistencePort;

import java.util.List;

public class CapabilityTechnologyCollaborationAdapter implements ICapabilityTechnologyCollaborationPersistencePort {
    private final ICapabilityRepository capabilityRepository;
    private final ITechnologyRepository technologyRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;

    public CapabilityTechnologyCollaborationAdapter(ICapabilityRepository capabilityRepository,
                                                    ITechnologyRepository technologyRepository,
                                                    ICapabilityEntityMapper capabilityEntityMapper) {
        this.capabilityRepository = capabilityRepository;
        this.technologyRepository = technologyRepository;
        this.capabilityEntityMapper = capabilityEntityMapper;
    }

    @Override
    public Capability assignTechnologyToCapability(Long capabilityId, Long technologyId) {
        CapabilityEntity capability = capabilityRepository.findById(capabilityId).get();
        TechnologyEntity technology = technologyRepository.findById(technologyId).get();
        capability.getTechnologies().add(technology);
        return capabilityEntityMapper.toModel(capabilityRepository.save(capability));
    }
}
