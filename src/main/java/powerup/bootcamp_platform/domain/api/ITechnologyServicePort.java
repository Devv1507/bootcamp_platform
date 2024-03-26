package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.Technology;
import java.util.List;

public interface ITechnologyServicePort {
    void saveTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologies(/*Integer page, Integer size*/); /*add ascesding order here?*/

    List<Technology> getAllTechnologiesPaged(Integer page, Integer size, String sortField);

    Technology updateTechnology(Technology technology);
    void deleteTechnology(Long id);
}
