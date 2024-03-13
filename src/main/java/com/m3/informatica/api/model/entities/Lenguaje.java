package com.m3.informatica.api.model.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "lenguajes")
public class Lenguaje {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
