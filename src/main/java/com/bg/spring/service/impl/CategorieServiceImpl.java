package com.bg.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bg.hibernate.model.Categorie;
import com.bg.spring.dao.CategorieDao;
import com.bg.spring.service.CategorieService;


public class CategorieServiceImpl implements CategorieService{

	@Autowired
	private CategorieDao categorieDao;
	
	@Override
	public Categorie getCategorie(int id) {
		return null;
	}

	@Override
	public List<Categorie> getAllCategorie() {
		return categorieDao.getAllCategorie();
	}

}
