package com.bg.spring.service;

import java.util.List;

import com.bg.hibernate.model.Produit;

public interface ProduitService {
	public Produit getProduit(int id);
	public List<Produit> getAllProduit();
	void ajouterProduit(Produit produit);
	List<Produit> getProduitsByCategorie(int idCat, String nomProduit, Double prix);
	public void supprimerProduit(Produit produit);
}
