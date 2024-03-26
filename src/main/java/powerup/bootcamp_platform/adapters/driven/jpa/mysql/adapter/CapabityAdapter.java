package powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.CapabilityEntity;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.exceptions.TechnologyAlreadyExistsException;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ICapabilityEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ICapabilityRepository;
import powerup.bootcamp_platform.domain.model.Capability;
import powerup.bootcamp_platform.domain.spi.ICapabilityPersistentPort;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

@RequiredArgsConstructor
public class CapabityAdapter implements ICapabilityPersistentPort {
    private final ICapabilityRepository capabilityRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;

    @Override
    public void saveCapability(Capability capability) {
        if (capabilityRepository.findByName(capability.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException(); /// problem here
        }
        capabilityRepository.save(capabilityEntityMapper.toEntity(capability));
    }

    @Override
    public Capability getCapability(String name) {
        return null;
    }

    @Override
    public List<Capability> getAllCapabilities(Integer page, Integer size, String sort) {
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Invalid pagination parameters");
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
        return null;
    }

    @Override
    public void deleteCapability(Long id) {

    }
}
