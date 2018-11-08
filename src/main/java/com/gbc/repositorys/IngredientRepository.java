package com.gbc.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbc.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	Page<Ingredient> findByRecipieId(Long recipieId, Pageable pageable);
}