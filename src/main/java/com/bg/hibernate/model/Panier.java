package com.bg.hibernate.model;


import java.util.HashMap;

public class Panier {
	
	public HashMap<Produit, Integer> panier;

	public Panier(HashMap<Produit, Integer> panier) {
		this.panier = panier;
	}

	public Panier() {
	}

	public HashMap<Produit, Integer> getPanier() {
		return panier;
	}

	public void setPanier(HashMap<Produit, Integer> panier) {
		this.panier = panier;
	}
	
}
