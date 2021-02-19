package com.bg.spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bg.hibernate.model.Produit;
import com.bg.spring.dao.ProduitDao;
import com.bg.spring.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	private ProduitDao produitDao;

	public void setProduitDao(ProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	public ProduitServiceImpl() {
		super();
	}

	public ProduitServiceImpl(ProduitDao produitDao) {
		super();
		this.produitDao = produitDao;
	}

	@Override
	public Produit getProduit(int id) {
		return produitDao.getProduit(id);
	}

	@Override
	public List<Produit> getAllProduit() {
		return produitDao.getAllProduit();
	}

	public ProduitDao getProduitDao() {
		return produitDao;
	}

	@Override
	public void ajouterProduit(Produit produit) {
		if (produit != null) {
			produitDao.ajouterProduit(produit);
		}
	}

	@Override
	public List<Produit> getProduitsByCategorie(int idCat, String nomProduit, Double prix) {
		return produitDao.getProduitsByCategorie(idCat, nomProduit, prix);

	}

	@Override
	public void supprimerProduit(Produit produit) {
			produitDao.supprimerProduit(produit);
	}
}