package powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter;

import org.mapstruct.ObjectFactory;
import org.springframework.data.domain.Sort;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.exceptions.ElementNotFoundException;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.exceptions.TechnologyAlreadyExistsException;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ITechnologyRepository;
import powerup.bootcamp_platform.domain.model.Technology;
import powerup.bootcamp_platform.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort{
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public void saveTechnology(Technology technology) {
        if (technologyRepository.findByName(technology.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException();
        }
        technologyRepository.save(technologyEntityMapper.toEntity(technology));
    }
    @Override
    public Technology getTechnology(String name) {
        TechnologyEntity technology = technologyRepository.findByName(name).orElseThrow(ElementNotFoundException::new);
        return technologyEntityMapper.toModel(technology);
    }

    /*@Override
    public List<Technology> getAllTechnologies(int offset, int size, String sortField) {
        // Input validation
        if (offset < 0 || size <= 0 || sortField == null) {
            throw new IllegalArgumentException("Invalid pagination or sort parameters");
        }
        // Create a Sort object based on sort
         Sort sortObject = sortField.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("name").ascending(): Sort.by("name").descending();
        //Sort sortObject = (sort.equalsIgnoreCase("ASC")) ? Sort.by("name") : Sort.by("name").descending();
        // Create Pageable object with sorting
        Pageable paging = PageRequest.of(offset, size, sortObject);
        // Retrieve paginated and sorted technologies
        List<TechnologyEntity> tecnologiesSortingPaging = technologyRepository.findAll(paging).getContent();
        // Handle empty list
        if (tecnologiesSortingPaging.isEmpty()) {
            throw new NoDataFoundException();
        }
        // Convert entities to models and return
        return technologyEntityMapper.toModelList(tecnologiesSortingPaging);
    }*/
    @Override
    public List<Technology> getAllTechnologies(/*Integer page, Integer size*/) {
        /*Pageable paging = PageRequest.of(page, size);*/
        /*List<TechnologyEntity> technologiesPaged = technologyRepository.findAll(paging).stream();
        if (technologiesPaged.isEmpty()) {
            throw new NoDataFoundException();
        }*/
        List<TechnologyEntity> technologies = technologyRepository.findAll();
        return technologyEntityMapper.toModelList(technologies);

    }
    @Override
    public List<Technology> getAllTechnologiesPaged(Integer page, Integer size, String sort) {
        // Input validation
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Invalid pagination parameters");
        }
        // Create a Sort object based on sort
        Sort sortObject = sort.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("name").ascending(): Sort.by("name").descending();
        // Create Pageable object with sorting
        Pageable paging = PageRequest.of(page, size, sortObject);
        // Retrieve paginated and sorted technologies
        List<TechnologyEntity> technologies = technologyRepository.findAll(paging).getContent();
        if (technologies.isEmpty()) {
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(technologies);
    }
    @Override
    public Technology updateTechnology(Technology technology) {
        if (technologyRepository.findById(technology.getId()).isEmpty()) {
            throw new ElementNotFoundException();
        }
        return technologyEntityMapper.toModel(technologyRepository.save(technologyEntityMapper.toEntity(technology)));
    }
    @Override
    public void deleteTechnology(Long id) {
        if (technologyRepository.findById(id).isEmpty()) {
            throw new ElementNotFoundException();
        }
        technologyRepository.deleteById(id);
    }
}
