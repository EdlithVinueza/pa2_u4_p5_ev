package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IPersonaRepository;
import com.uce.edu.repository.modelo.Persona;
@Service
public class IPersonaServiceImpl implements IPersonaService {
	@Autowired
	IPersonaRepository iPersonaRepository;

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.insertar(persona);

	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.actualizar(persona);

	}

	@Override
	public Persona consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaRepository.consultarPorCedula(cedula);
	}

	@Override
	public void borrarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.eliminarPorCedula(cedula);

	}

	@Override
	public List<Persona> consulatTodos() {
		// TODO Auto-generated method stub
		return this.iPersonaRepository.consulatTodos();
	}

}
