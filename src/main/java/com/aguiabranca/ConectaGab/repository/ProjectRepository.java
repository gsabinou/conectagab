package com.aguiabranca.ConectaGab.repository;

import com.aguiabranca.ConectaGab.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {



}
