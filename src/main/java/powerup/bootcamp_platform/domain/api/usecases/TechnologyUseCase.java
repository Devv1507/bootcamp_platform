package powerup.bootcamp_platform.domain.api.usecases;

import powerup.bootcamp_platform.domain.model.Technology;
import powerup.bootcamp_platform.domain.api.ITechnologyServicePort;
import powerup.bootcamp_platform.domain.spi.ITechnologyPersistencePort;
import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;
    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }
    @Override
    public void saveTechnology(Technology technology) {
        technologyPersistencePort.saveTechnology(technology);
    }
    @Override
    public Technology getTechnology(String name){
        return technologyPersistencePort.getTechnology(name);
    }
    /*@Override
    public List<Technology>  getAllTechnologies(Integer page, Integer size, String sort) {
        return technologyPersistencePort.getAllTechnologies(page, size, sort);
    }*/
    @Override
    public List<Technology>  getAllTechnologies(/*Integer page, Integer size*/) {
        return technologyPersistencePort.getAllTechnologies(/*page, size*/);
    }

    @Override
    public List<Technology>  getAllTechnologiesPaged(Integer page, Integer size, String sort) {
        return technologyPersistencePort.getAllTechnologiesPaged(page, size, sort);
    }




    @Override
    public Technology updateTechnology(Technology technology){
        return technologyPersistencePort.updateTechnology(technology);
    }
    @Override
    public void deleteTechnology(Long id){
        technologyPersistencePort.deleteTechnology(id);
    }
}
    /*


    try {
        technologyUseCase.createTechnology(technology);
    } catch (TechnologyNameAlreadyExistsException e) {
        // Handle duplicate name error (return 409 Conflict)
    } catch (ArgumentNotValidException e) {
        // Handle specific validation errors based on exception type (return 400 Bad Request)
    }

     */

/*

    In your TechnologyUseCase class (domain layer), catch the TechnologyNameAlreadyExistsException
     and translate it into a domain-specific message or error code for the API layer.
    Similarly, catch the ArgumentNotValidException subclasses and translate them appropriately.

 */
