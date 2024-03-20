package powerup.bootcamp_platform.domain.api.usecases;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import powerup.bootcamp_platform.domain.api.ITechnologyServicePort;
import powerup.bootcamp_platform.domain.spi.ITechnologyPersistencePort;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TechnologyUseCaseTest {
    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;
    @InjectMocks
    private ITechnologyServicePort technologyServicePort;

    @Test
    void saveTechnology() {
    }
}