package com.novellius.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.novellius.domain.Directores;
import com.novellius.domain.Directores_;
import com.novellius.domain.Peliculas;
import com.novellius.domain.Peliculas_;
import com.novellius.util.HibernateUtil;

public class DirectoresDaoImpl implements DirectoresDao{

	private Session session;

	
	public DirectoresDaoImpl() {
		super();
	}

	public DirectoresDaoImpl(Session session) {
		super();
		this.session = session;
	}

	@Override
	public void save(Directores directores) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(directores);
			
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
	public Directores findById(int id) {
		Transaction tx = null;
		Directores director = null;
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Directores> criteria = builder.createQuery(Directores.class);
			Root<Directores> root = criteria.from(Directores.class);
			
			criteria.where(
					builder.equal(root.get(Directores_.idDire), id)
					);
			
			director = session.createQuery(criteria).getSingleResult();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return director;
	}

	@Override
	public List<Peliculas> findAll(Directores directores) {
		Transaction tx = null;
		List<Peliculas> peliculas = new ArrayList<>();
		try {
			tx = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Peliculas> criteria = builder.createQuery(Peliculas.class);
			Root<Peliculas> root = criteria.from(Peliculas.class);
			
			Join<Peliculas, Directores> join = root.join(Peliculas_.director);
			
			criteria.where(
					builder.equal(join.get(Directores_.idDire), directores.getIdDire())
					);
			
			peliculas = session.createQuery(criteria).getResultList();
			
			tx.commit();
		} 
		catch (Exception e) {
			if(tx != null){
				tx.rollback();
				peliculas = null;
			}
			e.printStackTrace();
		}		return peliculas;
	}

	public void closeSession() {
		session.close();		
	}

	@Override
	public void update_directores(int idDire, String CompDire) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Directores director = session.get(Directores.class, idDire );
			if(director != null){
				director.setCompDire("Sikelia");
				session.beginTransaction();
				session.update(director);
				session.getTransaction().commit();
			}else{
				System.out.println("Director doesn't exist with provided Id..");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}		
	

	@Override
	public void delete_directores(int idDire) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Directores director = session.get(Directores.class, idDire);
			if(director != null){
				session.beginTransaction();
				session.delete(director);
				session.getTransaction().commit();
			}else{
				System.out.println("Director doesn't exist with provideded Id..");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}		
	
	
	
	
	
}