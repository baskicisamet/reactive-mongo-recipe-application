package com.sam.reactivemongorecipeapplication.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sam.reactivemongorecipeapplication.domain.Recipe;
import com.sam.reactivemongorecipeapplication.repositories.reactive.RecipeReactiveRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
@Service
public class ImageServiceImpl implements ImageService {


    private final RecipeReactiveRepository recipeReactiveRepository;;

    public ImageServiceImpl( RecipeReactiveRepository recipeReactiveRepository) {
        this.recipeReactiveRepository = recipeReactiveRepository;
    }

    @Override
    public Mono<Void> saveImageFile(String recipeId, MultipartFile file) {
    	
    	
    	Mono<Recipe> recipeMono = recipeReactiveRepository.findById(recipeId)
    		.map(recipe -> {
    			Byte[] byteObjects;
    			try {
    				byteObjects = new Byte[file.getBytes().length];
    				
    				int i = 0;
    				
    				for(byte b : file.getBytes()) {
    					byteObjects[i++] = b;
    				}
    				recipe.setImage(byteObjects);
    				return recipe;
    				
    			
    			}catch(IOException e) {
    				e.printStackTrace();
    				throw new RuntimeException(e);
    			}
    		});
    	
    	recipeReactiveRepository.save(recipeMono.block()).block();
    	
    	
    	
    	
    	return Mono.empty();

//        try {
//            Recipe recipe = recipeReactiveRepository.findById(recipeId).get();
//
//            Byte[] byteObjects = new Byte[file.getBytes().length];
//
//            int i = 0;
//
//            for (byte b : file.getBytes()){
//                byteObjects[i++] = b;
//            }
//
//            recipe.setImage(byteObjects);
//
//            recipeReactiveRepository.save(recipe);
//        } catch (IOException e) {
//            //todo handle better
//            log.error("Error occurred", e);
//
//            e.printStackTrace();
//        }
    }
}
