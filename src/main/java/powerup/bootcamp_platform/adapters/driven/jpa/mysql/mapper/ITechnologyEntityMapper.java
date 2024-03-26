package powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.TechnologyEntity;
import powerup.bootcamp_platform.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ITechnologyEntityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    TechnologyEntity toEntity(Technology technology);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    Technology toModel(TechnologyEntity technologyEntity);

    List<Technology> toModelList(List<TechnologyEntity> technologyEntities);
}
