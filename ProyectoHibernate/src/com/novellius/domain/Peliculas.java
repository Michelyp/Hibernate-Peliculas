package com.novellius.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Peliculas")
public class Peliculas {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Director")
	private int director;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "Directores",
	joinColumns = { @JoinColumn(name = "idDire") }
	
)
	private Directores directores;
	public Peliculas() {
	}

	public Peliculas(String nombre, int director) {
		super();
		this.nombre = nombre;
		this.director = director;
	}



	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Directores getDirector() {
		return directores;
	}


	public void setDirector(Directores directores) {
		this.directores = directores;
	}

	@Override
	public String toString() {
		return "Peliculas [Id=" + Id + ", Nombre=" + nombre + ", Director=" +  "]";
	}
	
	

	

	
}
