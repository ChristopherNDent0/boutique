package com.bg.hibernate.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produit")
	private int idProduit;
	@Column
	private String nom;
	@Column
	private int stock;
	@Column
	private String description;
	@Column(name = "url_image")
	private String urlImage;
	@Column(name = "id_categorie")
//  @OneToMany(cascade = CascadeType.ALL)
//	@JoinTable( name="Produit", joinColumns = { @JoinColumn(name="id_categorie")}, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID")})
//	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Categorie.class)
//	@JoinColumn(name = "id_catgeorie")
	private int idCategorie;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "prix_actuel")
	private Double prixActuel;

	public Produit() {
	}

	public Produit(String nom, int stock, String description, String urlImage, int idCategorie, Double prixActuel) {
		this.nom = nom;
		this.stock = stock;
		this.description = description;
		this.urlImage = urlImage;
		this.idCategorie = idCategorie;
		this.prixActuel = prixActuel;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public Double getPrixActuel() {
		return prixActuel;
	}

	public void setPrixActuel(Double prixActuel) {
		this.prixActuel = prixActuel;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nom=" + nom + ", stock=" + stock + ", description=" + description
				+ ", urlImage=" + urlImage + ", idCategorie=" + idCategorie + ", prixActuel=" + prixActuel + "]";
	}
}