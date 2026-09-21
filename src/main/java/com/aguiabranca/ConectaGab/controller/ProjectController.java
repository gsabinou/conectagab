package com.aguiabranca.ConectaGab.controller;

import com.aguiabranca.ConectaGab.dto.ProjectCreationDTO;
import com.aguiabranca.ConectaGab.dto.ProjectExhibitionDTO;
import com.aguiabranca.ConectaGab.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/projects/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjectExhibitionDTO> create(
            @PathVariable String userId,@RequestBody ProjectCreationDTO projectCreationDTO) {
        return ResponseEntity.ok(projectService.create(userId, projectCreationDTO));
    }

    @GetMapping("/projects/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProjectExhibitionDTO> getById(
            @PathVariable String projectId) {
        return ResponseEntity.ok(projectService.findById(projectId));
    }

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectExhibitionDTO> getAll() {
        return projectService.findAll();
    }

    @PutMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProjectExhibitionDTO> update(
            @RequestBody ProjectCreationDTO projectDTO) {
        return ResponseEntity.ok(projectService.update(projectDTO));
    }

    @DeleteMapping("/projects/{projectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String projectId) {
        projectService.delete(projectId);
    }

}
