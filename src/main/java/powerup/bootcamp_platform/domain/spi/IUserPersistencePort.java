package powerup.bootcamp_platform.domain.spi;

import powerup.bootcamp_platform.domain.model.User;
import java.util.List;

public interface IUserPersistencePort {
    void saveUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers(); // need more thinking
    User getTeacher(Long id);
    User getStudent(Long id);
}
