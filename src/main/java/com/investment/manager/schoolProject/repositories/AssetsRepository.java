package com.investment.manager.schoolProject.repositories;

import com.investment.manager.schoolProject.models.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface AssetsRepository extends CrudRepository<Stock, Long> {
   Stock findByTicker(String ticker);
}
