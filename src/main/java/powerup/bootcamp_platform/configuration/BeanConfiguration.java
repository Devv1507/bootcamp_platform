package powerup.bootcamp_platform.configuration;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.repositories.ITechnologyRepository;
import powerup.bootcamp_platform.domain.api.ITechnologyServicePort;
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

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    }
    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }
}
