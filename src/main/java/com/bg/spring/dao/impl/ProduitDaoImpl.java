package com.bg.spring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bg.hibernate.model.Produit;
import com.bg.spring.dao.ProduitDao;

@Repository
public class ProduitDaoImpl implements ProduitDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ProduitDaoImpl() {
		super();
	}

	public ProduitDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

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
//		Transaction transaction = null;
//
//		Session session = sessionFactory.openSession();
//
//		try {
//			transaction = session.beginTransaction();
//
//			session.save(produit);
//			transaction.commit();
//
//			System.out.println("Le nouveau produit a été enregistré");
//
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}

//		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		long count = session.createSQLQuery("insert into `boutique_avec_tarif`(`id_produit`,`nom`,`stock`,`description`,`url_image`,`id_categorie`,`url_image`,`prix_actuel`) values (\"batterie3\", 3, \"text4\", \"http://fhifoezf.com\", 3, 45.00)");
//		session.getTransaction().commit();
//		Transaction tx = null;
//		Session session = sessionFactory.getCurrentSession();
//		try {
//			tx = session.beginTransaction();
//			session.save(produit);
//			tx.commit();
//			session.close();
//		} catch (Exception ex) {
//			System.out.println(ex);
//			tx.rollback();
//		}
		Session session = sessionFactory.openSession();
		try {
			final Transaction transaction = session.beginTransaction();
			try {
				session.save(produit);
				transaction.commit();

			} catch (Exception ex) {
				// Log the exception here
				transaction.rollback();
				throw ex;
			}
		} finally {
			session.close();
//			sessionFactory.close();
		}
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        session.save(produit);
//        sessionFactory.getCurrentSession().getTransaction().commit();    
//        session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	@Override
	public List<Produit> getProduitsByCategorie(int idCat, String nomProduit, Double prix) {
		// Restrictions.or(Restrictions.isEmpty("nomproduit"),Restrictions.eq("prix",
		// 0));
		@SuppressWarnings("unchecked")
//		List<Produit> produits = (List<Produit>) sessionFactory.getCurrentSession().
//		createCriteria(Produit.class).add(Restrictions.eqOrIsNull("idCategorie",idCat))
//		.add(Restrictions.ilike("nom", nomProduit,MatchMode.ANYWHERE)).list();

//		List<Produit> produits = (List<Produit>) sessionFactory.getCurrentSession().
//		createCriteria(Produit.class).add( Restrictions.or(
//	    Restrictions.eq("idCategorie",idCat)).add(Restrictions.ilike("nom", nomProduit,MatchMode.ANYWHERE)))
//		.add((Criterion) ((Criteria) Restrictions.like("prix_actuel", prix)).addOrder(Property.
//		forName("prix_actuel").desc()).list());

		List<Produit> produits = (List<Produit>) sessionFactory.getCurrentSession().createCriteria(Produit.class)
				.add(Restrictions.or(Restrictions.eq("idCategorie", idCat))
						.add(Restrictions.ilike("nom", nomProduit, MatchMode.ANYWHERE)))
				.add(Property.forName("prix_actuel").like(prix)).addOrder(Property.forName("prix_actuel").desc())
				.list();

		return produits;
	}

	@Override
	@Transactional
	public void supprimerProduit(Produit pdt) {
		Session session = sessionFactory.openSession();
		try {
			final Transaction transaction = session.beginTransaction();
			try {
//				session.merge(pdt);
//				session.load(Produit.class, pdt.getIdProduit());
				Object produit = session.get(Produit.class, pdt.getIdProduit());
				session.delete(produit);
				transaction.commit();
			} catch (Exception ex) {
				// Log the exception here
				transaction.rollback();
				throw ex;
			}
		} finally {
			session.close();
			//sessionFactory.close();
		}
	}
}