package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.Technology;
import java.util.List;

public interface ITechnologyServicePort {
    void saveTechnology(Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologies(Integer page, Integer size, String sortOrder); /*add ascesding order here?*/
    List<Technology> getAllTechnologiesByAddress(String address, Integer page, Integer size);
    Technology updateTechnology(Technology technology);
    void deleteTechnology(Long id);
}
