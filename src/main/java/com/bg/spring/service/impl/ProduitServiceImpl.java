package com.bg.spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.bg.hibernate.model.Produit;
import com.bg.spring.dao.ProduitDao;
import com.bg.spring.service.ProduitService;

public class ProduitServiceImpl implements ProduitService {
	@Autowired
	private ProduitDao produitDao;

	@Override
	public Produit getProduit(int id) {
		return produitDao.getProduit(id);
	}

	@Override
	public List<Produit> getAllProduit() {
		return produitDao.getAllProduit();
	}

//	public boolean ajouterProduit(Produit produit) {
//		if (produit == null) {
//			produitDao.ajouterProduit(produit);
//			return true;
//		}
//		return false;
//	}

	public ProduitDao getProduitDao() {
		return produitDao;
	}
}
