package powerup.bootcamp_platform.adapters.driving.http.mapper;

import powerup.bootcamp_platform.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import powerup.bootcamp_platform.adapters.driving.http.dto.request.AddTechnologyRequest;
import powerup.bootcamp_platform.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyRequestMapper {
    @Mapping(target = "id", source = "id")
    Technology addRequestToTechnology(AddTechnologyRequest addTechnologyRequest);
    @Mapping(target = "id", source = "id")
    Technology updateRequestToTechnology(UpdateTechnologyRequest updateTechnologyRequest);

}


