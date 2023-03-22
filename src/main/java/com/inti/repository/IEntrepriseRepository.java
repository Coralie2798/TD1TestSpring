package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
