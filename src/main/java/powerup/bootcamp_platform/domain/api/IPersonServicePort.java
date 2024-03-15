package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.Person;

public interface IPersonServicePort {
    void savePerson(Person person);
}
