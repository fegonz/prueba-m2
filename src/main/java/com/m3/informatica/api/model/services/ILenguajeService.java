package com.m3.informatica.api.model.services;



import com.m3.informatica.api.model.entities.Lenguaje;


public interface ILenguajeService {
	
	

	
	public Lenguaje findById(Long id);
	
	public Lenguaje save(Lenguaje lenguaje);
	
	public void delete(Long id);

}
