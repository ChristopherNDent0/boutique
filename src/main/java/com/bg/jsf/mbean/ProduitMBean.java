package com.bg.jsf.mbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

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
	private Double selectedPrix;

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

	public Double getSelectedPrix() {
		//if (this.selected==null) return this.getMyUsers().get(0);
		//if (this.selectedPrix == null) return this.getProduit();
		return selectedPrix;
	}

	public void setSelectedPrix(Double selectedPrix) {
		this.selectedPrix = selectedPrix;
	}

	//@SuppressWarnings("static-access")
//	public SelectItem[] getItemsAvailableSelectOne() {
//		 
//        List<Produit> liste = produitService.getAllProduit();
//        SelectItem[] items = new SelectItem[liste.size()];
//        for (int i=0;i<liste.size(); i++) {
////            items[i] = new SelectItem(liste.get(i),liste.get(i).getPrixActuel().toString(selectedPrix));
//        	 items[i] = new SelectItem(liste.get(i),liste.get(i).getPrixActuel().toString());
//        }
//        return items;
//    }
	public void recherche() {
			
			int idCat = Integer.parseInt(selectedCategorie);
				produitList = produitService.filtrerProduits(idCat, nomProduit);
	}		
}

