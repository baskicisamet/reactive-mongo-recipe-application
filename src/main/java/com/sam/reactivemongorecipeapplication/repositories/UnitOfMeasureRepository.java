package com.sam.reactivemongorecipeapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sam.reactivemongorecipeapplication.domain.UnitOfMeasure;

import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
