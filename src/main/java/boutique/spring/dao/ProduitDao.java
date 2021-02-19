package boutique.spring.dao;

import boutique.hibernate.model.Produit;

import java.util.List;

public interface ProduitDao {
    Produit getProduit(int id);

    List<Produit> getAllProduit();

    void ajouterProduit(Produit produit);

    List<Produit> getProduitsByCategorie(int idCat, String nomProduit);
}

