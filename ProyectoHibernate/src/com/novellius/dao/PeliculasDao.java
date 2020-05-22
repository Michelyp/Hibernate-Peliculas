package com.novellius.dao;

import com.novellius.domain.Directores;
import com.novellius.domain.Peliculas;

public interface PeliculasDao {

	public void save(Peliculas peliculas);
	public Peliculas findById(int id);
	Peliculas update_peliculas(Peliculas peliculas);
	Peliculas delete_peliculas(Peliculas peliculas);
	
}
