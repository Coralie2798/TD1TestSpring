package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Entreprise {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	
	@Exclude
	@OneToMany (mappedBy = "entreprise")
	private List<Salarie> listeS;
	
	public Entreprise(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		
		
		
	}
	
	
	
}
