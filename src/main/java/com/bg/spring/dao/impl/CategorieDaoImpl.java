package com.bg.spring.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.bg.hibernate.model.Categorie;
import com.bg.spring.dao.CategorieDao;

public class CategorieDaoImpl implements CategorieDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Categorie> getAllCategorie() {
		@SuppressWarnings("unchecked")
		List<Categorie> categorie = (List<Categorie>) sessionFactory.getCurrentSession().
		createCriteria(Categorie.class).list();

		return categorie;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}