package boutique.jsf.mbean;

import boutique.hibernate.model.Produit;
import boutique.spring.service.ProduitService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class ProduitMBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{produitService}")
    private ProduitService produitService;
    private Produit produit = new Produit();
    private List<Produit> produitList;
    private String selectedCategorie;
    private String nomProduit;
    private Double prix;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public List<Produit> getProduitList() {
        if (produitList == null) {
            produitList = produitService.getAllProduit();
        }
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    public void ajouterProduit() {
        produitService.ajouterProduit(produit);
    }

    public String getSelectedCategorie() {
        return selectedCategorie;
    }

    public void setSelectedCategorie(String selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public void recherche() {
        int idCat = Integer.parseInt(selectedCategorie);

        if (selectedCategorie == null && nomProduit == null)
            produitList = produitService.getAllProduit();

        else
            //if (selectedCategorie == null || nomProduit == null || prix == null)
            produitList = produitService.getProduitsByCategorie(idCat, nomProduit);
    }
}
