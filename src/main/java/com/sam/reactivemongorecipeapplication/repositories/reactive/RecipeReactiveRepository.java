package com.sam.reactivemongorecipeapplication.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sam.reactivemongorecipeapplication.domain.Recipe;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
	
	

}
