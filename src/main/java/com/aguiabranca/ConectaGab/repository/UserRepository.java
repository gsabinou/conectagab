package com.aguiabranca.ConectaGab.repository;

import com.aguiabranca.ConectaGab.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserById(String id);

    UserDetails findByEmail(String email);

}
