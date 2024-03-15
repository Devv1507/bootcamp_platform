package powerup.bootcamp_platform.domain.api;

import powerup.bootcamp_platform.domain.model.Role;
import java.util.List;

public interface IRoleServicePort {
    List<Role> getAllRoles();
}


/*
administrator
students - participants
teachers
 */