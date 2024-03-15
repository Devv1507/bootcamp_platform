package powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;


public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {
    /*
    @Query("SELECT COUNT(t) > 0 FROM TechnologyEntity t WHERE t.name = :name")
    boolean existsByName(String name);
    Optional<TechnologyEntity> save(TechnologyEntity technologyEntity);
     */
    Optional<TechnologyEntity> findByNameContaining(String name);
    Optional<TechnologyEntity> findByName(String name); // abstract method to apply to different models
    Page<TechnologyEntity> findAll(Pageable pageable);  // Implement pagination using Pageable interface
    Page<TechnologyEntity> findAllByAddress(String address, Pageable pageable);

}