package com.sam.reactivemongorecipeapplication.services;

import java.util.Set;

import com.sam.reactivemongorecipeapplication.commands.RecipeCommand;
import com.sam.reactivemongorecipeapplication.domain.Recipe;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);
}
