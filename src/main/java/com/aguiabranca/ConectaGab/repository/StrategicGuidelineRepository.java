package com.aguiabranca.ConectaGab.repository;

import com.aguiabranca.ConectaGab.model.StrategicGuideline;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StrategicGuidelineRepository extends MongoRepository<StrategicGuideline, String> {

    List<StrategicGuideline> findByAtivoTrue();

}
