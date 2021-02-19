package boutique.spring.service;

import boutique.hibernate.model.Produit;

import java.util.List;


public interface ProduitService {
	public Produit getProduit(int id);
	public List<Produit> getAllProduit();
	boolean ajouterProduit(Produit produit);
}
