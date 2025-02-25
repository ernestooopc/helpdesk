package com.helpdesk.demo.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.helpdesk.demo.model.PersistentLogin;

public interface PersistentLoginRepository extends MongoRepository<PersistentLogin, String> {
    Optional<PersistentLogin> findByUsername(String username);
    void deleteByUsername(String username);
}