package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Persona;

public interface IPersonaService {
	public void guardar (Persona persona);
	public void actualizar(Persona persona);
	public Persona consultarPorCedula(String cedula);
	public void borrarPorCedula(String cedula);
	public List <Persona> consulatTodos();

}
