package powerup.bootcamp_platform.domain.spi;

import powerup.bootcamp_platform.domain.model.Technology;
import java.util.List;

public interface ITechnologyPersistencePort {
    void saveTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologies(/*Integer page, Integer size*/); // Implement pagination

    List<Technology> getAllTechnologiesPaged(Integer page, Integer size, String sortField);




    Technology updateTechnology(Technology technology);
    void deleteTechnology(Long id);
}

/*boolean existsByName(String name); /*keep thinking*/