package powerup.bootcamp_platform.domain.api.usecases;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import powerup.bootcamp_platform.domain.exceptions.TechnologyAlreadyExistsException;
import powerup.bootcamp_platform.domain.model.Technology;
import powerup.bootcamp_platform.domain.spi.ITechnologyPersistencePort;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TechnologyUseCaseTest {
    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;
    @InjectMocks
    private TechnologyUseCase technologyUseCase;
    @Test
    void saveTechnology_NewTechnologySucces() {
        // GIVEN
        Technology technology = new Technology(1L, "Java","Java programming language");

        // Stub the behavior of technologyPersistencePort.saveTechnology() to do nothing
        doNothing().when(technologyPersistencePort).saveTechnology(any(Technology.class));

        // WHEN
        technologyUseCase.saveTechnology(technology);

        // THEN
        // Verify that the saveTechnology method was called with the correct argument
        verify(technologyPersistencePort, times(1)).saveTechnology(technology);
        /*assertThat().isPresent().contains();*/
    }


    @Test
    void saveTechnology_ExistingTechnology_ExceptionThrown() {
        // Arrange
        Technology existingTechnology = new Technology(1L, "Java", "Java programming language");
        existingTechnology.setName("Java");
        existingTechnology.setDescription("Java programming language");

        // Stub the behavior of technologyPersistencePort.saveTechnology() to throw TechnologyAlreadyExistsException
        doThrow(TechnologyAlreadyExistsException.class).when(technologyPersistencePort).saveTechnology(any(Technology.class));

        // Act and Assert
        assertThrows(TechnologyAlreadyExistsException.class, () -> {
            technologyUseCase.saveTechnology(existingTechnology);
        });
    }
}