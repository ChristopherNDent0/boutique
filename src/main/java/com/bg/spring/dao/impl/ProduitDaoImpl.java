package com.bg.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.bg.hibernate.model.Produit;
import com.bg.spring.dao.ProduitDao;

public class ProduitDaoImpl implements ProduitDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public Produit getProduit(int id) {
		Produit produit = (Produit) sessionFactory.getCurrentSession().get(Produit.class, id);
		return produit;
	}

	@Transactional
	@Override
	public List<Produit> getAllProduit() {
		@SuppressWarnings("unchecked")
		List<Produit> produit = (List<Produit>) sessionFactory.getCurrentSession().createCriteria(Produit.class).list();
		// or below query
		/*
		 * @SuppressWarnings("unchecked") List<Produit> produit =
		 * (List<Produit>)sessionFactory.getCurrentSession().createQuery(
		 * "from Produit").list();
		 */
		return produit;
	}

	@Override
	@Transactional
	public void ajouterProduit(Produit produit) {
		
//		sessionFactory.getCurrentSession().save(produit);
//		sessionFactory.close();
		System.out.println("yo1");
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(produit);
		sessionFactory.getCurrentSession().getTransaction().commit();	
		session.close();
		System.out.println("yo2");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
