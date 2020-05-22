package com.novellius.service;

import java.util.List;

import org.hibernate.Session;

import com.novellius.dao.DirectoresDaoImpl;
import com.novellius.domain.Directores;
import com.novellius.domain.Peliculas;

public class DirectoresService {
	
	private DirectoresDaoImpl inmuebleDao;

	public DirectoresService(Session session) {
		inmuebleDao = new DirectoresDaoImpl(session);
	}
	
	public Directores findById(int ID){
		return inmuebleDao.findById(ID);
	}
	
	public void save(Directores directores, List<Peliculas> peliculas) {
		if(peliculas != null){
			for(Peliculas pelicula : peliculas){
				directores.getPeliculas().add(pelicula);
			}
		}
		inmuebleDao.save(directores);
	}

	public void closeSession(){
		inmuebleDao.closeSession();
	}//Te das cuenta que es muy diferente? su crud
}
