package com.sam.reactivemongorecipeapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sam.reactivemongorecipeapplication.domain.Category;

import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
