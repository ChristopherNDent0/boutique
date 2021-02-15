package com.bg.spring.dao;

import java.util.List;

import com.bg.hibernate.model.Produit;

public interface ProduitDao {
    public Produit getProduit(int id);
    public List<Produit> getAllProduit();
//	void ajouterProduit(Produit produit);
}

