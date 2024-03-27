package powerup.bootcamp_platform.configuration;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter.CapabilityTechnologyCollaborationAdapter;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter.CapabityAdapter;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ICapabilityEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ICapabilityRepository;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ITechnologyRepository;
import powerup.bootcamp_platform.domain.api.ICapabilityServicePort;
import powerup.bootcamp_platform.domain.api.ICapabilityTechnologyCollaborationServicePort;
import powerup.bootcamp_platform.domain.api.ITechnologyServicePort;
import powerup.bootcamp_platform.domain.api.usecases.CapabilityTechnologyCollaborationUseCase;
import powerup.bootcamp_platform.domain.api.usecases.CapabilityUseCase;
import powerup.bootcamp_platform.domain.spi.ICapabilityPersistentPort;
import powerup.bootcamp_platform.domain.spi.ICapabilityTechnologyCollaborationPersistencePort;
import powerup.bootcamp_platform.domain.spi.ITechnologyPersistencePort;
import powerup.bootcamp_platform.domain.api.usecases.TechnologyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    private final ICapabilityRepository capabilityRepository;
    private final ICapabilityEntityMapper capabilityEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    }
    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }
    @Bean
    public ICapabilityPersistentPort capabilityPersistentPort() {
        return new CapabityAdapter(capabilityRepository,
                capabilityEntityMapper, technologyRepository, technologyEntityMapper);
    }
    @Bean
    public ICapabilityServicePort capabilityServicePort(){
        return new CapabilityUseCase(capabilityPersistentPort());
    }

    /*@Bean
    public ICapabilityTechnologyCollaborationPersistencePort capabilityTechnologyCollaborationPersistencePort() {
        return new CapabilityTechnologyCollaborationAdapter(capabilityRepository, technologyRepository, capabilityEntityMapper);
    }
    @Bean
    public ICapabilityTechnologyCollaborationServicePort capabilityTechnologyCollaborationServicePort(){
        return new CapabilityTechnologyCollaborationUseCase(capabilityTechnologyCollaborationPersistencePort());
    }*/
}
