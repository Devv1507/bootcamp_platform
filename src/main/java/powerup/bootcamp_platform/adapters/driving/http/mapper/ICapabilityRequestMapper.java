package powerup.bootcamp_platform.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import powerup.bootcamp_platform.adapters.driving.http.dto.request.AddCapabilityRequest;
import powerup.bootcamp_platform.domain.model.Capability;
import powerup.bootcamp_platform.domain.model.Technology;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICapabilityRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "technologies", source = "technologies")
    Capability addRequestToCapability(AddCapabilityRequest addCapabilityRequest, List<Technology> technologies);

    @Mapping(target = "id", ignore = true)
    Capability addRequestToCapability(AddCapabilityRequest addCapabilityRequest);

    void updateCapabilityFromRequest(AddCapabilityRequest addCapabilityRequest, @MappingTarget Capability capability);
}
