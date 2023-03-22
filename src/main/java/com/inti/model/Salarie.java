package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Salarie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	@Exclude
	@ManyToOne @JoinColumn(name="id_entreprise")
	private Entreprise entreprise;
	
	public Salarie(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		
		
		
	}
	
	

}
