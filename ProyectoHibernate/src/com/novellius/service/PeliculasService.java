package com.novellius.service;

import org.hibernate.Session;

import com.novellius.dao.PeliculasDaoImpl;
import com.novellius.domain.Directores;
import com.novellius.domain.Peliculas;


public class PeliculasService {
	private PeliculasDaoImpl peliculasDao;

	public PeliculasService(Session session) {
		peliculasDao = new PeliculasDaoImpl(session);
	}
	
	public Peliculas findById(int id){
		return peliculasDao.findById(id);
	}
	
	public void save(Peliculas peliculas) {
		if (peliculas != null) {
			peliculasDao.save(peliculas);
		}
	}
	public Peliculas update(Peliculas peliculas) {
		return peliculasDao.update_peliculas(peliculas);
	}
	
	public Peliculas delete(Peliculas peliculas) {
		return peliculasDao.delete_peliculas(peliculas);
	}

	public void closeSession(){
		peliculasDao.closeSession();
	}
}
