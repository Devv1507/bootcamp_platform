package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.Bootcamp;
import java.util.List;

public interface IBootcampServicePort {
    void saveBootcamp(Bootcamp bootcamp);
    void deleteBootcamp(Bootcamp bootcamp);
    List<Bootcamp> getAllBootcamps(); // need more thinking
    Bootcamp getTeacher(Long id);
    Bootcamp getParticipants(Long id);
    Bootcamp getHomeworks(Long id);
}
