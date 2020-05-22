package com.novellius.service;

import java.util.List;

import org.hibernate.Session;

import com.novellius.dao.DirectoresDaoImpl;
import com.novellius.domain.Directores;
import com.novellius.domain.Peliculas;

public class DirectoresService {
	
	private DirectoresDaoImpl DirDao;

	public DirectoresService(Session session) {
		DirDao = new DirectoresDaoImpl(session);
	}
	
	public Directores findById(int ID){
		return DirDao.findById(ID);
	}
	
	public void save(Directores directores, List<Peliculas> peliculas) {
		if(peliculas != null){
			for(Peliculas pelicula : peliculas){
				directores.getPeliculas().add(pelicula);
			}
		}
		DirDao.save(directores);
	}
	public void update(int idDire, String CompDire) {
		 new DirectoresDaoImpl().update_directores(idDire, CompDire);
	}
	
	public void delete( int idDire) {
		new DirectoresDaoImpl().delete_directores(idDire);
	}

	public void closeSession(){
		DirDao.closeSession();
	}
}
