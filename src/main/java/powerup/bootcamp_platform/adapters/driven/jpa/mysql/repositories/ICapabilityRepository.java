package powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.CapabilityEntity;
import java.util.Optional;

public interface ICapabilityRepository extends JpaRepository<CapabilityEntity, Long> {
    Page<CapabilityEntity> findAll(Pageable pageable);
    Optional<CapabilityEntity> findByName(String name);
}