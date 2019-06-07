package com.investment.manager.schoolProject.repositories;

import com.investment.manager.schoolProject.models.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface AssetsRepository extends CrudRepository<Portfolio, Long> {
//    List<Portfolio> findByStock(String id);
}
