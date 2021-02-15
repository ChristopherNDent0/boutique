package com.bg.spring.dao.impl;

import com.bg.hibernate.model.Produit;
import com.bg.spring.dao.ProduitDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<Produit> produit = (List<Produit>) sessionFactory.getCurrentSession()
				.createCriteria(Produit.class).list();
        // or below query
        /*
         * @SuppressWarnings("unchecked") List<Produit> produit =
         * (List<Produit>)sessionFactory.getCurrentSession().createQuery(
         * "from Produit").list();
         */
        return produit;
    }

//	@Override
//	public void ajouterProduit(Produit produit) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(produit);
//		session.close();
//	}

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
