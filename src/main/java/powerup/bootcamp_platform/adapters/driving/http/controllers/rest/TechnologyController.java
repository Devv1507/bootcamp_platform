package powerup.bootcamp_platform.adapters.driving.http.controllers.rest;

import powerup.bootcamp_platform.adapters.driving.http.dto.request.AddTechnologyRequest;
import powerup.bootcamp_platform.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import powerup.bootcamp_platform.adapters.driving.http.dto.response.TechnologyResponse;
import powerup.bootcamp_platform.adapters.driving.http.mapper.ITechnologyRequestMapper;
import powerup.bootcamp_platform.adapters.driving.http.mapper.ITechnologyResponseMapper;
import powerup.bootcamp_platform.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/technologies")
@RequiredArgsConstructor
public class TechnologyController {
    private final  ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addTechnology(@Valid @RequestBody AddTechnologyRequest request) {
        technologyServicePort.saveTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/search/{technologyName}")
    public ResponseEntity<TechnologyResponse> getTechnology(@PathVariable String technologyName) {
        return ResponseEntity.ok(technologyResponseMapper.toTechnologyResponse(technologyServicePort.getTechnology(technologyName)));
    }
    @GetMapping
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologies(
            /*@RequestParam Integer page,
            @RequestParam (defaultValue = "15") Integer size
            @RequestParam (defaultValue = "ASC") String sort*/ ) {
        return ResponseEntity.ok(technologyResponseMapper.
                toTechnologyResponseList(technologyServicePort.getAllTechnologies(/*page, size*/)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologiesPaged(
            @RequestParam (defaultValue = "0") Integer page,
            @RequestParam (defaultValue = "15") Integer size,
            @RequestParam (defaultValue = "ASC") String sort) {
        return ResponseEntity.ok(technologyResponseMapper.
                toTechnologyResponseList(technologyServicePort.getAllTechnologiesPaged(page, size, sort)));
    }

    @PutMapping("/")
    public ResponseEntity<TechnologyResponse> updateTechnology(@RequestBody UpdateTechnologyRequest request) {
        return ResponseEntity.ok(technologyResponseMapper.toTechnologyResponse(
                technologyServicePort.updateTechnology(technologyRequestMapper.updateRequestToTechnology(request))
        ));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        technologyServicePort.deleteTechnology(id);
        return ResponseEntity.noContent().build();
    }
}
