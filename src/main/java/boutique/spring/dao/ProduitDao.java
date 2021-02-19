package boutique.spring.dao;

import boutique.hibernate.model.Produit;

import java.util.List;


public interface ProduitDao {
    public Produit getProduit(int id);
    public List<Produit> getAllProduit();
	void ajouterProduit(Produit produit);
}

