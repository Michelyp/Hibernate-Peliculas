package com.novellius.domain;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Directores")
public class Directores {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int idDire;
	
	@Column(name="Nombre")
	private String NomDire;
	

	@Column(name="Compania")
	private String CompDire;
	
	@OneToMany(targetEntity=Peliculas.class, mappedBy ="directores")
	private List<Peliculas> peliculas = new ArrayList<>();
	public Directores() {
		
	}

	public Directores(String nomDire, String compDire) {
		super();
		NomDire = nomDire;
		CompDire = compDire;
	}

	public List<Peliculas> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(List<Peliculas> peliculas) {
		this.peliculas = peliculas;
	}
	
	
	public int getIdDire() {
		return idDire;
	}


	public void setIdDire(int idDire) {
		this.idDire = idDire;
	}


	public String getNomDire() {
		return NomDire;
	}


	public void setNomDire(String nomDire) {
		NomDire = nomDire;
	}


	public String getCompDire() {
		return CompDire;
	}


	public void setCompDire(String compDire) {
		CompDire = compDire;
	}

	@Override
	public String toString() {
		return "Directores [idDire=" + idDire + ", NomDire=" + NomDire + ", CompDire=" + CompDire + ", peliculas="
				+ peliculas + "]";
	}

	
	
}
