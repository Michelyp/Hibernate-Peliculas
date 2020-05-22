package com.novellius.service;

import java.util.List;

import org.hibernate.Session;

import com.novellius.dao.PeliculasDaoImpl;
import com.novellius.domain.Peliculas;


public class PeliculasService {
	private PeliculasDaoImpl peliculasDao;

	public PeliculasService(Session session) {
		peliculasDao = new PeliculasDaoImpl(session);
	}
	
	public Peliculas findById(int id){
		return peliculasDao.findById(id);
	}
	


	public void closeSession(){
		peliculasDao.closeSession();
	}
}
