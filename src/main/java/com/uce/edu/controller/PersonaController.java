package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	// --> http://localhost:8080/personas/buscarPorCedula/1751674027
	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model model) {
		Persona persona = this.iPersonaService.consultarPorCedula(cedula);
		model.addAttribute("persona", persona);
		return "vistaPersona";
	}

	// Actualizar --> Put
	@PutMapping("/actualizar/{cedulaPersona}")
	public String actualizar(@PathVariable("cedulaPersona") String cedula, Persona persona) { // persona es el modelo
		persona.setCedula(cedula);
		Persona perAux = this.iPersonaService.consultarPorCedula(cedula);
		perAux.setNombre(persona.getNombre());
		perAux.setApellido(persona.getApellido());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());

		this.iPersonaService.actualizar(perAux);
		return "redirect:/personas/buscarTodos";

		// cuando se necesita enviar un modeleo actualizado en la lista al controlador,
	}

	@PostMapping("/insertar")
	public String insertar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTodos";
	}

	@GetMapping("/nuevaPersona")
	public String mostrarNuevoPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "vistaNuevaPersona";
	}

	// borrar --> delete
	@DeleteMapping("/borrar/{cedula}")
	public String borrar(@PathVariable("cedula") String cedula) {
		this.iPersonaService.borrarPorCedula(cedula);
		return "redirect:/personas/buscarTodos";
	}

	
}
