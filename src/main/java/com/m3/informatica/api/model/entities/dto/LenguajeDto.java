package com.m3.informatica.api.model.entities.dto;


public class LenguajeDto {
	private int id;

	
	private String nombre;
	private String codigo;
	private boolean compilado;
	
	private int anioCreacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isCompilado() {
		return compilado;
	}

	public void setCompilado(boolean compilado) {
		this.compilado = compilado;
	}

	public int getAnioCreacion() {
		return anioCreacion;
	}

	public void setAnioCreacion(int anioCreacion) {
		this.anioCreacion = anioCreacion;
	}

	
	
	
}
