package com.aguiabranca.ConectaGab.service;

import com.aguiabranca.ConectaGab.dto.IdeaCreationDTO;
import com.aguiabranca.ConectaGab.dto.IdeaExhibitionDTO;
import com.aguiabranca.ConectaGab.exceptions.GuidelineNotFoundException;
import com.aguiabranca.ConectaGab.exceptions.IdeaNotFoundException;
import com.aguiabranca.ConectaGab.exceptions.UserNotFoundException;
import com.aguiabranca.ConectaGab.model.Idea;
import com.aguiabranca.ConectaGab.model.IdeaStatus;
import com.aguiabranca.ConectaGab.model.StrategicGuideline;
import com.aguiabranca.ConectaGab.model.User;
import com.aguiabranca.ConectaGab.repository.IdeaRepository;
import com.aguiabranca.ConectaGab.repository.StrategicGuidelineRepository;
import com.aguiabranca.ConectaGab.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StrategicGuidelineRepository guidelineRepository;

    public IdeaExhibitionDTO create(String userId, IdeaCreationDTO ideaCreationDTO) {
        Idea idea = new  Idea();
        BeanUtils.copyProperties(ideaCreationDTO, idea);

        Optional<User> author = userRepository.findById(userId);
        if (author.isPresent()) {
            idea.setAutor(author.get());
        } else {
            throw new UserNotFoundException("Autor não encontrado");
        }

        idea.setDataCriacao(LocalDate.now());
        idea.setStatus(IdeaStatus.CADASTRADA);

        Idea savedIdea = ideaRepository.save(idea);
        return new IdeaExhibitionDTO(savedIdea);
    }

    public List<IdeaExhibitionDTO> listAll() {
        return ideaRepository
                .findAll()
                .stream()
                .map(IdeaExhibitionDTO::new)
                .toList();
    }

    public IdeaExhibitionDTO findById(String ideaId) {
        Optional<Idea> idea = ideaRepository.findById(ideaId);

        if (idea.isPresent()) {
            return new IdeaExhibitionDTO(idea.get());
        } else {
            throw new IdeaNotFoundException("Ideia não encontrada");
        }
    }

    public IdeaExhibitionDTO updateById(String ideaId, IdeaCreationDTO ideaCreationDTO) {
        Optional<Idea> optionalIdea = ideaRepository.findById(ideaId);

        if (optionalIdea.isPresent()) {

            if (ideaCreationDTO.estrategia() != null) {
                Optional<StrategicGuideline> guidelineOptional = guidelineRepository
                        .findById(ideaCreationDTO.estrategia().getId());

                if (guidelineOptional.isEmpty()) {
                    throw new GuidelineNotFoundException("Estratégia não encontrada");
                }
            }

            Idea idea = new Idea();
            BeanUtils.copyProperties(ideaCreationDTO, idea);
            idea.setDataCriacao(LocalDate.now());

            Idea updatedIdea = ideaRepository.save(idea);
            return new IdeaExhibitionDTO(updatedIdea);
        } else {
            throw new IdeaNotFoundException("Ideia não encontrada");
        }

    }

    public void deleteById(String ideaId) {
        Optional<Idea> idea = ideaRepository.findById(ideaId);

        if (idea.isPresent()) {
            ideaRepository.delete(idea.get());
        } else {
            throw new IdeaNotFoundException("Ideia não encontrada");
        }
    }

    public List<IdeaExhibitionDTO> listByPrioridade(String prioridade) {
        return ideaRepository
                .findByPrioridade(prioridade)
                .stream()
                .map(IdeaExhibitionDTO::new)
                .toList();
    }

}
