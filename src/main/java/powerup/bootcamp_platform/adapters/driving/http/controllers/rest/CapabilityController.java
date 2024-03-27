package powerup.bootcamp_platform.adapters.driving.http.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import powerup.bootcamp_platform.adapters.driving.http.dto.request.AddCapabilityRequest;
import powerup.bootcamp_platform.adapters.driving.http.dto.response.CapabilityResponse;
import powerup.bootcamp_platform.adapters.driving.http.mapper.ICapabilityRequestMapper;
import powerup.bootcamp_platform.adapters.driving.http.mapper.ICapabilityResponseMapper;
import powerup.bootcamp_platform.domain.api.ICapabilityServicePort;
import powerup.bootcamp_platform.domain.model.Capability;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/capabilities")
@RequiredArgsConstructor
public class CapabilityController {
    private final ICapabilityServicePort capabilityServicePort;
    private final ICapabilityRequestMapper capabilityRequestMapper;
    private final ICapabilityResponseMapper capabilityResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addCapability(@Valid @RequestBody AddCapabilityRequest request) {
        // Extract capability object from the request
        Capability capability = capabilityRequestMapper.addRequestToCapability(request);
        // Extract technology IDs from the request
        List<Long> technologyIds = request.getTechnologyIds();
        // Save the capability along with the technology IDs
        capabilityServicePort.saveCapability(capability, technologyIds);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /*@PostMapping("/")
    public ResponseEntity<Void> addCapability(@Valid @RequestBody AddCapabilityRequest request) {
        // Retrieve TechnologyEntity objects corresponding to the provided IDs
        Set<TechnologyEntity> technologies = new HashSet<>(technologyRepository.findAllByIdIn(request.getTechnologyIds()));

        // Create a new CapabilityEntity
        CapabilityEntity capabilityEntity = new CapabilityEntity();
        capabilityEntity.setName(request.getName());
        capabilityEntity.setDescription(request.getDescription());
        capabilityEntity.setTechnologies(technologies);

        // Convert CapabilityEntity to Capability
        Capability capability = capabilityEntityMapper.toModel(capabilityEntity);

        // Save the capability
        capabilityServicePort.saveCapability(capability);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/

    @GetMapping
    public ResponseEntity<List<CapabilityResponse>> getAllCapabilities(
            @RequestParam (defaultValue = "0") Integer page,
            @RequestParam (defaultValue = "15") Integer size,
            @RequestParam (defaultValue = "ASC") String sort) {
        return ResponseEntity.ok(capabilityResponseMapper.
                toCapabilityResponseList(capabilityServicePort.getAllCapabilities(page, size, sort)));
    }

    @PutMapping("/{capabilityId}/technologies/{technologyId}")
    public ResponseEntity<CapabilityResponse> assignTechnologyToCapability(
            @PathVariable Long technologyId,
            @PathVariable Long capabilityId
    ){
        CapabilityResponse response = capabilityResponseMapper.toCapabilityResponse(
                capabilityServicePort.assignTechnologyToCapability(capabilityId, technologyId));
        return ResponseEntity.ok(response);
    }
}
