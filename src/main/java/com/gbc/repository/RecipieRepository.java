package com.gbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbc.model.Recipie;

@Repository
public interface RecipieRepository extends JpaRepository<Recipie, Long> {

}