package com.bg.spring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(produit);
		sessionFactory.getCurrentSession().getTransaction().commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	@Override
	public List<Produit> getProduitByPrice(Double prix) {
		@SuppressWarnings("unchecked")
		List<Produit> produits = (List<Produit>) sessionFactory.getCurrentSession()
				.createQuery("from produits" + " where prix <= ?").list();
		return produits;
	}

	@Transactional
	@Override
	public List<Produit> filtrerProduits(int idCat, String nomProduit) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Produit.class);

		criteria.add(Restrictions.or(Restrictions.eq("idCategorie", idCat))
				.add(Restrictions.ilike("nom", nomProduit, MatchMode.ANYWHERE))).list();

		@SuppressWarnings("unchecked")
		List<Produit> produits = (List<Produit>) criteria.list();
		return produits;

	}

	@Transactional
	@Override
	public List<Produit> filtrerProduits(int idCat, String nomProduit, Double prix) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Produit.class);

		criteria.add(Restrictions.eq("idCategorie", idCat))
				.add(Restrictions.ilike("nom", nomProduit, MatchMode.ANYWHERE)).add(Restrictions.eq("prixActuel", prix))
				.addOrder(Order.asc("prixActuel")).list();

		@SuppressWarnings("unchecked")
		List<Produit> produits = (List<Produit>) criteria.list();
		return produits;

	}

}
