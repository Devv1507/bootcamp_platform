package powerup.bootcamp_platform.domain.api.usecases;

import powerup.bootcamp_platform.domain.model.Person;
import powerup.bootcamp_platform.domain.api.IPersonServicePort;
import powerup.bootcamp_platform.domain.spi.IPersonPersistencePort;

public class PersonUseCase implements IPersonServicePort {
    private final IPersonPersistencePort personPersistencePort;

    public PersonUseCase(IPersonPersistencePort IPersonPersistencePort) {
        this.personPersistencePort = IPersonPersistencePort;
    }

    @Override
    public void savePerson(Person person) {
        personPersistencePort.savePerson(person);
    }
}
