package boutique.spring.service;

import boutique.hibernate.model.Produit;

import java.util.List;

public interface ProduitService {
    Produit getProduit(int id);

    List<Produit> getAllProduit();

    void ajouterProduit(Produit produit);

    List<Produit> getProduitsByCategorie(int idCat, String nomProduit);
}
