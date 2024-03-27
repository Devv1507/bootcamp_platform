package powerup.bootcamp_platform.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import powerup.bootcamp_platform.adapters.driving.http.dto.response.CapabilityResponse;
import powerup.bootcamp_platform.domain.model.Capability;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICapabilityResponseMapper {
    @Mapping(source = "id", target = "id")
    CapabilityResponse toCapabilityResponse(Capability capability);
    List<CapabilityResponse> toCapabilityResponseList(List<Capability> capabilities);
}
