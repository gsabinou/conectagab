package com.aguiabranca.ConectaGab.repository;

import com.aguiabranca.ConectaGab.model.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IdeaRepository extends MongoRepository<Idea, String> {

    List<Idea> findByPrioridade(String prioridade);

}
