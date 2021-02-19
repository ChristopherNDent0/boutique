package boutique.spring.service.impl;

import boutique.hibernate.model.Produit;
import boutique.spring.dao.ProduitDao;
import boutique.spring.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public List<Produit> getProduitsByCategorie(int idCat, String nomProduit) {
        return produitDao.getProduitsByCategorie(idCat, nomProduit);
    }
}
