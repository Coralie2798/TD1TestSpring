package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.inti.repository.IEntrepriseRepository;

@Controller 
public class EntrepriseController {

	@Autowired
	IEntrepriseRepository ier;
	
	
}
