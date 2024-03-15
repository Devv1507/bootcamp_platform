package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.User;
import java.util.List;

public interface IUserServicePort {
    void saveUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers(); // need more thinking
    User getTeacher(Long id);
    User getStudent(Long id);
}
