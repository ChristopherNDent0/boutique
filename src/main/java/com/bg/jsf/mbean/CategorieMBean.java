package com.bg.jsf.mbean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.bg.hibernate.model.Categorie;
import com.bg.spring.service.CategorieService;

@ManagedBean
@ViewScoped
public class CategorieMBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{categorieService}")
	private CategorieService categorieService;
	private Categorie categorie;
	private List<Categorie> categorieList;
	
	public List<Categorie> getCategorieList() {
		
		categorieList = categorieService.getAllCategorie();
		
		return categorieList;
	}

	public void setCategorieService(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setCategorieList(List<Categorie> categorieList) {
		this.categorieList = categorieList;
	}

}
