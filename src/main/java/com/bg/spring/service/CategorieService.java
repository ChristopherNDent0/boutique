package com.bg.spring.service;

import java.util.List;

import com.bg.hibernate.model.Categorie;


public interface CategorieService {
	public Categorie getCategorie(int id);
	public List<Categorie> getAllCategorie();

}
