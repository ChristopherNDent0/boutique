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

	public Produit getProduit() {
		return produit;
	}

	public void ajouterProduit(Produit produit) {
		produitService.ajouterProduit(produit);
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
}
