package com.bg.spring.service;

import java.util.List;

import com.bg.hibernate.model.Produit;

public interface ProduitService {
	public Produit getProduit(int id);
	public List<Produit> getAllProduit();
	boolean ajouterProduit(Produit produit);
}
