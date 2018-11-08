package com.gbc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.gbc.exceptions.ResourceNotFoundException;
import com.gbc.models.Ingredient;
import com.gbc.models.Ingredient.INGREDIENT_TYPE;
import com.gbc.repositorys.IngredientRepository;
import com.gbc.repositorys.RecipieRepository;

@RestController
@RequestMapping("/api")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipieRepository recipieRepository;
    
    @GetMapping("/recipies/{recipieId}/ingredients")
    public Page<Ingredient> getAllIngredientsByRecipieId(@PathVariable (value = "recipieId") Long recipieId,
                                                Pageable pageable) {
        return ingredientRepository.findByRecipieId(recipieId, pageable);
    }

    @PostMapping("/recipies/{recipieId}/ingredients")
    public Ingredient createIngredient(@PathVariable (value = "recipieId") Long recipieId,
                                 @Valid @RequestBody Ingredient ingredient) {
 
        return recipieRepository.findById(recipieId).map(recipie -> {
        	ingredient.setRecipie(recipie);
            return ingredientRepository.save(ingredient);
        }).orElseThrow(() -> new ResourceNotFoundException("Recipie", "Id", recipieId));
    }

//    @PutMapping("/posts/{postId}/comments/{commentId}")
//    public Comment updateComment(@PathVariable (value = "postId") Long postId,
//                                 @PathVariable (value = "commentId") Long commentId,
//                                 @Valid @RequestBody Comment commentRequest) {
//        if(!ingredientRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return recipieRepository.findById(commentId).map(comment -> {
//            comment.setText(commentRequest.getText());
//            return recipieRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
//    }
//
//    @DeleteMapping("/posts/{postId}/comments/{commentId}")
//    public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") Long postId,
//                              @PathVariable (value = "commentId") Long commentId) {
//        if(!ingredientRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return recipieRepository.findById(commentId).map(comment -> {
//             recipieRepository.delete(comment);
//             return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + " not found"));
//    }
    @GetMapping("/ingredient/template")
    public Ingredient getIngredientTemplate() {
    	Ingredient template = new Ingredient();
    	template.setName("Marris Otter");
    	template.setIngredient_Type(INGREDIENT_TYPE.GRAIN.toString());
        return template;
    }
}