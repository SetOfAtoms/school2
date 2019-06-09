package com.investment.manager.schoolProject.repositories;

import com.investment.manager.schoolProject.models.Bond;
import org.springframework.data.repository.CrudRepository;

public interface BondRepository extends CrudRepository<Bond, Long> {
}
