package com.aguiabranca.ConectaGab.service;

import com.aguiabranca.ConectaGab.dto.GuideCreationDTO;
import com.aguiabranca.ConectaGab.dto.GuideExhibitionDTO;
import com.aguiabranca.ConectaGab.exceptions.GuidelineNotFoundException;
import com.aguiabranca.ConectaGab.model.StrategicGuideline;
import com.aguiabranca.ConectaGab.repository.StrategicGuidelineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuidelineService {

    @Autowired
    private StrategicGuidelineRepository guidelineRepository;

    public GuideExhibitionDTO create(GuideCreationDTO guideCreationDTO) {
        StrategicGuideline strategicGuideline = new StrategicGuideline();
        BeanUtils.copyProperties(guideCreationDTO, strategicGuideline);
        strategicGuideline.setData(LocalDate.now());

        StrategicGuideline guideline = guidelineRepository.save(strategicGuideline);
        return new GuideExhibitionDTO(guideline);
    }

    public GuideExhibitionDTO findById(String id) {
        Optional<StrategicGuideline> guideline = guidelineRepository.findById(id);

        if (guideline.isPresent()) {
            return new GuideExhibitionDTO(guideline.get());
        } else {
            throw new GuidelineNotFoundException("Estratégia da empresa não encontrada");
        }
    }

    public List<GuideExhibitionDTO> getHistory() {
        return guidelineRepository
                .findAll()
                .stream()
                .map(GuideExhibitionDTO::new)
                .toList();
    }

    public GuideExhibitionDTO update(GuideCreationDTO guideCreationDTO, String id) {
        Optional<StrategicGuideline> guidelineOptional = guidelineRepository.findById(id);

        if (guidelineOptional.isPresent()) {
            StrategicGuideline guideline = new StrategicGuideline();
            BeanUtils.copyProperties(guideCreationDTO, guideline);

            guideline.setData(guidelineOptional.get().getData());
            guideline.setId(id);

            return new  GuideExhibitionDTO(guidelineRepository.save(guideline));
        } else {
            throw new GuidelineNotFoundException("Estratégia da empresa não encontrada");
        }
    }

    public void delete(String id) {
        Optional<StrategicGuideline> guidelineOptional = guidelineRepository.findById(id);

        if (guidelineOptional.isPresent()) {
            guidelineRepository.delete(guidelineOptional.get());
        } else  {
            throw new GuidelineNotFoundException("Estratégia da empresa não encontrada");
        }
    }

    public List<GuideExhibitionDTO> findALl() {
        return guidelineRepository
                .findByAtivoTrue()
                .stream()
                .map(GuideExhibitionDTO::new)
                .toList();

    }
}