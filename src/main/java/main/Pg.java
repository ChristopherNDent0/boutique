package main;

import org.springframework.context.annotation.ComponentScan;

import com.bg.hibernate.model.Produit;
import com.bg.spring.service.ProduitService;
import com.bg.spring.service.impl.ProduitServiceImpl;

@ComponentScan
public class Pg {

	public static void main(String[] args) {
		
		Produit pdt = new Produit("batterie3", 3, "text4", "http://fhifoezf.com", 3, 45.00);
		ProduitService pdtServ = new ProduitServiceImpl();
		pdtServ.ajouterProduit(pdt);
//		for ( Produit produit : pdtServ.getAllProduit())
//			System.out.println(produit);
	}
}
