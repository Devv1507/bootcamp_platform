package powerup.bootcamp_platform.domain.spi;

import powerup.bootcamp_platform.domain.model.Technology;
import java.util.List;

public interface ITechnologyPersistencePort {
    void saveTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologies(int page, int size, String sortOrder); // Implement pagination
    List<Technology> getAllTechnologiesByAddress(String address, Integer page, Integer size);
    Technology updateTechnology(Technology technology);
    void deleteTechnology(Long id);
}

/*boolean existsByName(String name); /*keep thinking*/