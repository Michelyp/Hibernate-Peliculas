package com.novellius.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.novellius.domain.Directores;
import com.novellius.domain.Peliculas;
import com.novellius.service.DirectoresService;
import com.novellius.service.PeliculasService;
import com.novellius.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		DirectoresService directorService = new DirectoresService(session);
		PeliculasService peliculasService = new PeliculasService(session);
		//create
		List<Peliculas> peliculas = new ArrayList<>();
		Directores director = new Directores("Gabriel", "MGM");
		directorService.save(director, peliculas);
		
		
		
		peliculasService.save(new Peliculas ("El Bromas",director.getIdDire()));
		peliculasService.save(new Peliculas ("1917",director.getIdDire()));
		
		
		List<Peliculas> peliculas2 = new ArrayList<>();
		Directores director2 = new Directores("Romy", "MORALE");
		directorService.save(director2, peliculas2);
		/*peliculasService.save(new Peliculas ("El Prisas",director2.getIdDire()));
		peliculasService.save(new Peliculas ("Parasite",director2.getIdDire()));*/
		
		
		/*peliculas2.add(new Peliculas("Parasite", director2));
		peliculas2.add(new Peliculas("El Prisas", director2 ));
		peliculas2.add(new Peliculas("1917", director2));*/
		
		//read
		directorService.findById(director.getIdDire());
		directorService.findById(director2.getIdDire());
		
		
		//update
		
		directorService.update(director2.getIdDire(),"Sikelia");
		System.out.println(director.toString());
		
		//delete
		directorService.delete(director2.getIdDire());
		
		directorService.closeSession();

	}


}
