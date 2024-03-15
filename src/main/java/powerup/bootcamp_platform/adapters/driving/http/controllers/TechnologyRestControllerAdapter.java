package powerup.bootcamp_platform.adapters.driving.http.controllers;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/technologies")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {
    private final  ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addTechnology(@Valid @RequestBody AddTechnologyRequest request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){ // to probe at least to send something
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        technologyServicePort.saveTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/search/{technologyName}")
    public ResponseEntity<TechnologyResponse> getTechnology(@PathVariable String technologyName) {
        return ResponseEntity.ok(technologyResponseMapper.toTechnologyResponse(technologyServicePort.getTechnology(technologyName)));
    }
    @GetMapping("/")
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologies(@RequestParam Integer page, @RequestParam (defaultValue = "15") Integer size, @RequestParam String sortOrder) {
        return ResponseEntity.ok(technologyResponseMapper.
                toTechnologyResponseList(technologyServicePort.getAllTechnologies(page, size, sortOrder)));
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
