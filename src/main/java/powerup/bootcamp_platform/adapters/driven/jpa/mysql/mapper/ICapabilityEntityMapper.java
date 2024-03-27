package powerup.bootcamp_platform.adapters.driven.jpa.mysql.mapper;

import powerup.bootcamp_platform.adapters.driven.jpa.mysql.entities.CapabilityEntity;
import powerup.bootcamp_platform.domain.model.Capability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapabilityEntityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "technologies", target = "technologies")
    CapabilityEntity toEntity(Capability capability);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "technologies", target = "technologies")
    Capability toModel(CapabilityEntity capabilityEntity);

    List<Capability> toModelList(List<CapabilityEntity> capabilityEntities);
}
