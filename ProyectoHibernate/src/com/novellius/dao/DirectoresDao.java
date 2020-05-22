package com.novellius.dao;

import java.util.List;

import com.novellius.domain.Directores;
import com.novellius.domain.Peliculas;

public interface DirectoresDao {
	
	public void save(Directores directores);
	public Directores findById(int ID);
	public List<Peliculas> findAll(Directores directores);
	public void update_directores(int idDire, String CompDire);
	public void delete_directores(int idDire );
	

}