package com.bg.jsf.mbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.bg.hibernate.model.Produit;
import com.bg.spring.service.ProduitService;

@ManagedBean
@ViewScoped
public class ProduitMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// inject spring bean via DI
	@ManagedProperty("#{produitService}")
	private ProduitService produitService;
	private Produit produit;
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

	public String getSelectedCategorie() {
		return selectedCategorie;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public void setSelectedCategorie(String selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
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
		
	
		if (selectedCategorie == null && nomProduit == null && prix == null)
			produitList = produitService.getAllProduit();
		
		else
			//if (selectedCategorie == null || nomProduit == null || prix == null)
				produitList = produitService.getProduitsByCategorie(idCat,nomProduit,prix);	
		
	}
}
