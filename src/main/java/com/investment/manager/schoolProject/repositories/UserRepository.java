package com.investment.manager.schoolProject.repositories;

import com.investment.manager.schoolProject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<com.investment.manager.schoolProject.models.User, Long> {
    User findByUsername(String username);
}