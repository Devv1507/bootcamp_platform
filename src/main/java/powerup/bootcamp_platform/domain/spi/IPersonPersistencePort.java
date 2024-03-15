package powerup.bootcamp_platform.domain.spi;

import powerup.bootcamp_platform.domain.model.Person;

public interface IPersonPersistencePort {
    void savePerson(Person person);
}
