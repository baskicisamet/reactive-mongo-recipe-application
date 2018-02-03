package com.sam.reactivemongorecipeapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sam.reactivemongorecipeapplication.domain.Category;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
