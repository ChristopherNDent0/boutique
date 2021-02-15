package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bg.hibernate.model.Produit;
import com.bg.spring.service.ProduitService;
import com.bg.spring.service.impl.ProduitServiceImpl;

public class Pg {

	public static void main(String[] args) {
		
		Produit pdt = new Produit("batterie3", 3, "text4", null, 3, 45.00);
		ProduitService pdtServ = new ProduitServiceImpl();
		pdtServ.ajouterProduit(pdt);
//		for ( Produit produit : pdtServ.getAllProduit())
//			System.out.println(produit);
	}
}
