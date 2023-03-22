package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Entreprise;
import com.inti.model.Salarie;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EntrepriseRepository {

	Entreprise e1, savedEntreprise;
	
	@Autowired
	IEntrepriseRepository ier;
	
	@BeforeEach
	public void setUp()
	{
		e1= new Entreprise("Sopra steria", "Paris");
		savedEntreprise=ier.save(e1);
	}
	
	@Test @DisplayName("test pour l'enregistrement d'entreprise")
	public void saveEntreprise() {
		assertThat(savedEntreprise).isNotNull();
		assertThat(savedEntreprise.getId()).isGreaterThan(0);
	}
	
	@Test @DisplayName("test d'affichage d'une entreprise")
	public void getEntreprise()
	{
		Entreprise e2=ier.getReferenceById(savedEntreprise.getId());
		
		assertThat(e2).isNotNull();
		assertThat(e2.getId()).isEqualTo(savedEntreprise.getId());
		assertThat(e2.getNom()).isEqualTo(savedEntreprise.getNom());
		assertThat(e2.getAdresse()).isEqualTo(savedEntreprise.getAdresse());
		assertThat(e2).isEqualTo(savedEntreprise);
		
		
	}
	
	@Test
	public void deleteEntreprise()
	{
		ier.delete(savedEntreprise);
		
		Assertions.assertThrows(Exception.class, ()-> ier.getReferenceById(savedEntreprise.getId()));
	}
	
	@Test
	public void updateEntreprise()
	{
		savedEntreprise.setNom("Thales");
		savedEntreprise.setAdresse("Lyon");
		
		Entreprise emodified= ier.save(savedEntreprise);
		assertThat(emodified).isNotNull();
		assertThat(emodified.getAdresse()).isEqualTo("Thales");
		assertThat(emodified.getAdresse()).isEqualTo("Lyon");
		
	}
	
	@Test
	public void getAllEntreprises()
	{
		Entreprise e3=new Entreprise("Danone","Rennes");
		Entreprise e4= new Entreprise("Tissium","Paris");
		
		ier.save(e3);
		ier.save(e4);
		
		List<Entreprise>listeE=ier.findAll();
	
		
		assertThat(listeE).isNotEmpty();
		assertThat(listeE).hasSize(3);
		assertThat(listeE.get(0).getClass()).hasSameClassAs(Entreprise.class);
		assertThat(listeE.get(1).toString()).hasToString(e3.toString());
	}
}
