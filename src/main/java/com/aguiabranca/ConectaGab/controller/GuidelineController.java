package com.aguiabranca.ConectaGab.controller;

import com.aguiabranca.ConectaGab.dto.GuideCreationDTO;
import com.aguiabranca.ConectaGab.dto.GuideExhibitionDTO;
import com.aguiabranca.ConectaGab.service.GuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GuidelineController {

    @Autowired
    private GuidelineService guidelineService;

    @PostMapping("/guidelines")
    @ResponseStatus(HttpStatus.CREATED)
    public GuideExhibitionDTO create(
            @RequestBody GuideCreationDTO guideCreationDTO) {
        return guidelineService.create(guideCreationDTO);
    }

    @GetMapping("/guidelines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GuideExhibitionDTO> getById(
            @PathVariable String id) {
        return ResponseEntity.ok(guidelineService.findById(id));
    }

    @GetMapping("/guidelines/history")
    @ResponseStatus(HttpStatus.OK)
    public List<GuideExhibitionDTO> getHistory() {
        return guidelineService.getHistory();
    }

    @PutMapping("/guidelines/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GuideExhibitionDTO> update(
            @PathVariable String id,
            @RequestBody GuideCreationDTO guideCreationDTO) {
        return ResponseEntity.ok(guidelineService.update(guideCreationDTO, id));
    }

    @DeleteMapping("/guidelines/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        guidelineService.delete(id);
    }

    @GetMapping("/guidelines")
    @ResponseStatus(HttpStatus.OK)
    public List<GuideExhibitionDTO> listAll() {
        return guidelineService.findALl();
    }

}
