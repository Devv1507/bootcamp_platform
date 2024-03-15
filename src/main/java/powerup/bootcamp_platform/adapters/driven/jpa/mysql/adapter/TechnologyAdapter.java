package powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter;

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
        TechnologyEntity technology = technologyRepository.findByNameContaining(name).orElseThrow(ElementNotFoundException::new);
        return technologyEntityMapper.toModel(technology);
    }
    @Override
    public List<Technology> getAllTechnologies(int page, int size, String sortOrder) {
        Pageable pagination = PageRequest.of(page, size);
        List<TechnologyEntity> tecnologies = technologyRepository.findAll(pagination).getContent();
        if (tecnologies.isEmpty()) {
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(tecnologies);
    }
    @Override
    public List<Technology> getAllTechnologiesByAddress(String address, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<TechnologyEntity> products = technologyRepository.findAllByAddress(address, pagination).getContent();
        if (products.isEmpty()) {
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toModelList(products);
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
