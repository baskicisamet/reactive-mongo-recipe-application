package com.sam.reactivemongorecipeapplication.services;

import java.util.Set;

import com.sam.reactivemongorecipeapplication.commands.RecipeCommand;
import com.sam.reactivemongorecipeapplication.domain.Recipe;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Flux<Recipe> getRecipes();

    Mono<Recipe> findById(String id);

    Mono<RecipeCommand> findCommandById(String id);

    Mono<RecipeCommand> saveRecipeCommand(RecipeCommand command);

    Mono<Void> deleteById(String idToDelete);
}
