package com.novellius.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.novellius.domain.Directores;
import com.novellius.domain.Peliculas;
import com.novellius.domain.Peliculas_;
import com.novellius.util.HibernateUtil;

public class PeliculasDaoImpl implements PeliculasDao {

	private Session session;
	
	public PeliculasDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void save(Peliculas peliculas) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(peliculas);
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}		
	}

	@Override
	public Peliculas findById(int id) {
		Transaction tx = null;
		Peliculas pelicula = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Peliculas> criteria = builder.createQuery(Peliculas.class);
			Root<Peliculas> root = criteria.from(Peliculas.class);
			
			criteria.where(
					builder.equal(root.get(Peliculas_.id), id)
					);
			
			pelicula = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return pelicula;
	}
	@Override
	public Peliculas update_peliculas(Peliculas peliculas) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Peliculas pelicula = session.get(Peliculas.class, peliculas.getId());
			if(pelicula != null){
				pelicula.setNombre("");
				session.beginTransaction();
				session.update(pelicula);
				session.getTransaction().commit();
			}else{
				System.out.println("Pelicula doesn't exist with provided Id..");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return peliculas;
	}		
	@Override
	public Peliculas delete_peliculas(Peliculas peliculas) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Peliculas pelicula = session.get(Peliculas.class, peliculas.getId());
			if(pelicula != null){
				session.beginTransaction();
				session.delete(pelicula);
				session.getTransaction().commit();
			}else{
				System.out.println("Director doesn't exist with provideded Id..");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return peliculas;
	
	}
	public void closeSession(){
		session.close();
	}

}