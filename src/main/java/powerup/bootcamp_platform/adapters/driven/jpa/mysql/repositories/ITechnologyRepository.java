package powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories;


import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.ContentHandler;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {
    Page<TechnologyEntity> findAll(Pageable pageable);
    Optional<TechnologyEntity> findByName(String name); // abstract method to apply to different models
    List<TechnologyEntity> findTechnologiesByCapabilitiesId(Long capabilityId);

    Set<TechnologyEntity> findAllByIdIn(List<Long> technologyIds);
    Optional<TechnologyEntity> findById(Long id);


}