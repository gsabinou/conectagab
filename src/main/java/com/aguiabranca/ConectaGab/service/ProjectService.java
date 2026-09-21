package com.aguiabranca.ConectaGab.service;

import com.aguiabranca.ConectaGab.dto.ProjectCreationDTO;
import com.aguiabranca.ConectaGab.dto.ProjectExhibitionDTO;
import com.aguiabranca.ConectaGab.exceptions.IdeaNotFoundException;
import com.aguiabranca.ConectaGab.exceptions.ProjectNotFoundException;
import com.aguiabranca.ConectaGab.model.Project;
import com.aguiabranca.ConectaGab.model.StatusPrazo;
import com.aguiabranca.ConectaGab.model.User;
import com.aguiabranca.ConectaGab.repository.ProjectRepository;
import com.aguiabranca.ConectaGab.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public ProjectExhibitionDTO create(String userId, ProjectCreationDTO projectCreationDTO) {
        Project project = new Project();
        Optional<User> user = userRepository.findUserById(userId);

        if (user.isPresent()) {
            BeanUtils.copyProperties(projectCreationDTO, project);
            project.setAutor(user.get());
            calculateEconomiaEstimada(project);

            Project createdProject = projectRepository.save(project);
            return new ProjectExhibitionDTO(createdProject);
        } else {
            throw new IdeaNotFoundException("Usuário não encontrado");
        }
    }

    public ProjectExhibitionDTO update(ProjectCreationDTO projectCreationDTO) {
        Optional<Project> optionalProject = projectRepository.findById(projectCreationDTO.id());

        if (optionalProject.isPresent()) {
            Project project = new Project();
            BeanUtils.copyProperties(projectCreationDTO, project);

            Project updatedProject = projectRepository.save(project);
            return new ProjectExhibitionDTO(updatedProject);
        } else {
            throw new ProjectNotFoundException("Projeto não encontrado");
        }
    }

    public void delete(String id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isPresent()) {
            projectRepository.deleteById(id);
        } else {
            throw new ProjectNotFoundException("Projeto não encontrado");
        }
    }

    public ProjectExhibitionDTO findById(String id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isPresent()) {
            return new ProjectExhibitionDTO(optionalProject.get());
        } else {
            throw new ProjectNotFoundException("Projeto não encontrado");
        }
    }

    public List<ProjectExhibitionDTO> findAll() {
        return projectRepository
                .findAll()
                .stream()
                .map(ProjectExhibitionDTO::new)
                .toList();
    }

    public void calculateEconomiaEstimada (Project project) {
        Double economiaEstimada = project.getRetornoEstimado() - project.getInvestimentoEstimado();
        project.setEconomiaEstimada(economiaEstimada);
    }

}
