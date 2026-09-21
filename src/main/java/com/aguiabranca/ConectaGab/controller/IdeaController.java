package com.aguiabranca.ConectaGab.controller;

import com.aguiabranca.ConectaGab.dto.IdeaCreationDTO;
import com.aguiabranca.ConectaGab.dto.IdeaExhibitionDTO;
import com.aguiabranca.ConectaGab.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    @PostMapping("/ideas/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<IdeaExhibitionDTO> save(
            @PathVariable String userId, @RequestBody IdeaCreationDTO idea) {
        return ResponseEntity.ok(ideaService.create(userId, idea));
    }

    @GetMapping("/ideas")
    @ResponseStatus(HttpStatus.OK)
    public List<IdeaExhibitionDTO> findAll() {
        return ideaService.listAll();
    }

    @GetMapping("/ideas/{ideaId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<IdeaExhibitionDTO> findById(@PathVariable String ideaId) {
        return ResponseEntity.ok(ideaService.findById(ideaId));
    }

    @PutMapping("/ideas/{ideaId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<IdeaExhibitionDTO> update(
            @PathVariable String ideaId, @RequestBody IdeaCreationDTO idea) {
        return ResponseEntity.ok(ideaService.updateById(ideaId, idea));
    }

    @DeleteMapping("/ideas/{ideaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String ideaId) {
        ideaService.deleteById(ideaId);
    }

    @GetMapping("/ideas/priority/{prioridade}")
    @ResponseStatus(HttpStatus.OK)
    public List<IdeaExhibitionDTO> findByPrioridade(
            @PathVariable String prioridade
    ) {
        return ideaService.listByPrioridade(prioridade);
    }

}
