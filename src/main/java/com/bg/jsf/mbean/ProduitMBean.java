package com.bg.jsf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


import com.bg.hibernate.model.Produit;
import com.bg.spring.service.ProduitService;

@ManagedBean(name="produitMBean")
@ViewScoped
public class ProduitMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// inject spring bean via DI
	@ManagedProperty("#{produitService}")
	private ProduitService produitService;
	private Produit produit = new Produit();
	private List<Produit> produitList;
	private String selectedCategorie;
	private String nomProduit;
	private Double prix;

	public ProduitMBean() {
		super();
	}

	public ProduitMBean(ProduitService produitService, Produit produit, List<Produit> produitList,
			String selectedCategorie, String nomProduit, Double prix) {
		super();
		this.produitService = produitService;
		this.produit = produit;
		this.produitList = produitList;
		this.selectedCategorie = selectedCategorie;
		this.nomProduit = nomProduit;
		this.prix = prix;
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

	public ProduitService getProduitService() {
		return produitService;
	}

	public Produit getProduit() {
		return produit;
	}

	public void ajouterProduit() {
		produitService.ajouterProduit(produit);
	}
	
	public void supprimerProduit() {
  		produitService.supprimerProduit(produit);
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
