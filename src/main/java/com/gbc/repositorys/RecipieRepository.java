package com.gbc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbc.models.Recipie;

@Repository
public interface RecipieRepository extends JpaRepository<Recipie, Long> {

}