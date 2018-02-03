package com.sam.reactivemongorecipeapplication.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sam.reactivemongorecipeapplication.domain.UnitOfMeasure;


public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
