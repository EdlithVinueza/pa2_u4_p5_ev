package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Persona;
import com.uce.edu.service.IPersonaService;

@Controller
//-->  http://localhost:8080/personas/buscarTodos
@RequestMapping("/personas") // le doy una parte del pat
public class PersonaController {
	@Autowired
	private IPersonaService iPersonaService;

	// Diferentes tipos de request
	// se los conoce como verbos o metodos HTTP

	// Buscar-->Get

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model model) {
		List<Persona> list = this.iPersonaService.consulatTodos();
		model.addAttribute("personas", list);
		return "vistaListaPersona";
	}
	
	// Path
	// Get
	@GetMapping("/buscar")
	public String buscarPorCedula(String cedula) {
		return "";
	}

	// Actualizar --> Put
	@PutMapping("/actualziar")
	public String actualizar() {
		return "";
	}

	// borrar --> delete
	@DeleteMapping("/borrar")
	public String borrar() {
		return "";
	}

	// guardar -->Post
	@PostMapping("/guardar")
	public String guardar() {
		return "";
	}

}
