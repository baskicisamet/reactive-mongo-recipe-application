package com.sam.reactivemongorecipeapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sam.reactivemongorecipeapplication.domain.Recipe;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
