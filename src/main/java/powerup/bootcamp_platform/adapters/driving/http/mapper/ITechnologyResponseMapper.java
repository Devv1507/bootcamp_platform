package powerup.bootcamp_platform.adapters.driving.http.mapper;

import powerup.bootcamp_platform.adapters.driving.http.dto.response.TechnologyResponse;
import powerup.bootcamp_platform.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyResponseMapper {
    @Mapping(source = "id", target = "id")
    TechnologyResponse toTechnologyResponse(Technology technology);
    List<TechnologyResponse> toTechnologyResponseList(List<Technology> technologies);
}
