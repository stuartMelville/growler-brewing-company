package com.gbc.controllers;

import com.gbc.exceptions.ResourceNotFoundException;
import com.gbc.models.Recipie;
import com.gbc.repositorys.RecipieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RecipieController {

    @Autowired
    RecipieRepository recipieRepository;

    // Get All Recipies
    @GetMapping("/recipies")
    public Page<Recipie> getAllRecipies(Pageable pageable) {
        return recipieRepository.findAll(pageable);
    }

    // Create a new Recipie
    @PostMapping("/recipies")
    public Recipie createRecipie(@Valid @RequestBody Recipie recipie) {
        return recipieRepository.save(recipie);
    }

    // Get a Single Recipie
    @GetMapping("/recipies/{recipieId}")
    public Recipie getRecipieById(@PathVariable(value = "recipieId") Long recipieId) {
        return recipieRepository.findById(recipieId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipie", "id", recipieId));
    }
    // Get a Single Recipie example
    @GetMapping("/recipies/template")
    public Recipie getRecipieTemplate() {
    	Recipie template = new Recipie();
    	template.setName("First Brew");
    	template.setMashTime("60");
    	template.setMashTemperature("67");
    	template.setMashVolume("36");
//    	List<Ingredient> ingredientList = new ArrayList<Ingredient>();
//    	Ingredient ingredientTemplate = new Ingredient();
//    	ingredientTemplate.setName("Maris Otter");
//    	ingredientTemplate.setType(INGREDIENT_TYPE.GRAIN);
//    	ingredientList.add(ingredientTemplate);
//    	template.getMashGrain().addAll(ingredientList);
        return template;
    }
    
    // Update a Recipie
    @PutMapping("/recipies/{recipieId}")
    public Recipie updateRecipie(	@PathVariable(value = "recipieId") Long recipieId,
    						@Valid @RequestBody Recipie recipieRequest) {

    	return recipieRepository.findById(recipieId).map(recipie -> {
    		recipie.setName(recipieRequest.getName());
    		recipie.setMashTime(recipieRequest.getMashTime());
    		recipie.setMashTemperature(recipieRequest.getMashTemperature());
    		recipie.setMashVolume(recipieRequest.getMashVolume());
            return recipieRepository.save(recipie);
        }).orElseThrow(() -> new ResourceNotFoundException("Recipie", "id", recipieId ));
    }

    // Delete a Recipies
    @DeleteMapping("/recipies/{recipieId}")
    public ResponseEntity<?> deleteRecipie(@PathVariable(value = "recipieId") Long recipieId) {
        return recipieRepository.findById(recipieId).map(recipie -> {
        	recipieRepository.delete(recipie);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Recipie", "id", recipieId ));
    }
    
}