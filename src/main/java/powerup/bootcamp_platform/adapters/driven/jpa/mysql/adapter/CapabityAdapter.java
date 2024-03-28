package powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.CapabilityEntity;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.exceptions.ElementNotFoundException;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ICapabilityEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ICapabilityRepository;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ITechnologyRepository;
import powerup.bootcamp_platform.domain.spi.ICapabilityPersistentPort;
import powerup.bootcamp_platform.domain.exceptions.TechnologyAlreadyExistsException;
import powerup.bootcamp_platform.domain.model.Capability;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CapabityAdapter implements ICapabilityPersistentPort {
    private final ICapabilityRepository capabilityRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    /*@Override
    public void saveCapability(Capability capability) {
        if (capabilityRepository.findByName(capability.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException(); /// problem here
        }
        capabilityRepository.save(capabilityEntityMapper.toEntity(capability));
    }*/
    @Override
    public void saveCapability(Capability capability, List<Long> technologyIds) {
        // Check if the capability already exists
        if (capabilityRepository.findByName(capability.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException();
        }
        // Map Capability to CapabilityEntity
        CapabilityEntity capabilityEntity = capabilityEntityMapper.toEntity(capability);
        // Retrieve TechnologyEntity objects corresponding to the provided IDs
        Set<TechnologyEntity> technologies = new HashSet<>();
        for (Long technologyId : technologyIds) {
            TechnologyEntity technologyEntity = technologyRepository.findById(technologyId)
                    .orElseThrow(() -> new ElementNotFoundException());
            technologies.add(technologyEntity);
        }
        capabilityEntity.setTechnologies(technologies);
        // Save the capability
        capabilityRepository.save(capabilityEntity);
    }

    @Override
    public Capability getCapability(String name) {
        return null;
    }

    @Override
    public List<Capability> getAllCapabilities(Integer page, Integer size, String sort) {
        if (page < 0 || size <= 0) { // think about the use of constants variables recommendation of Session 20/03
            throw new IllegalArgumentException("Invalid pagination parameters"); // needed some fixes
        }
        // Create a Sort object based on sort
        Sort sortObject = sort.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("name").ascending(): Sort.by("name").descending();
        // Create Pageable object with sorting
        Pageable paging = PageRequest.of(page, size, sortObject);
        // Retrieve paginated and sorted technologies
        List<CapabilityEntity> capabilities = capabilityRepository.findAll(paging).getContent();
        if (capabilities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return capabilityEntityMapper.toModelList(capabilities);
    }

    @Override
    public Capability updateCapability(Capability capability) {
        if (capabilityRepository.findById(capability.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        return capabilityEntityMapper.toModel(capabilityRepository.save(capabilityEntityMapper.toEntity(capability)));
    }

    @Override
    public void deleteCapability(Long id) {

    }

    @Override
    public Capability assignTechnologyToCapability(Long capabilityId, Long technologyId) {
        CapabilityEntity capability = capabilityRepository.findById(capabilityId).get();
        TechnologyEntity technology = technologyRepository.findById(technologyId).get();
        capability.getTechnologies().add(technology);
        return capabilityEntityMapper.toModel(capabilityRepository.save(capability));
    }
}