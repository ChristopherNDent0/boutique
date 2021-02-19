package bg2;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bg.hibernate.model.Produit;
import com.bg.jsf.mbean.ProduitMBean;
import com.bg.spring.dao.impl.ProduitDaoImpl;

class ProduitDao {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void testAjouterProduit() throws SQLException {
		SessionFactory sessionFactory = null;
        Produit prd = new Produit("acer", 5, "text4", "", 1, 500.00);
        ProduitMBean produitMBean = new ProduitMBean();
        produitMBean.ajouterProduit();
//        List<Produit> produits = sessionFactory.getCurrentSession().createCriteria(Produit.class).addOrder(Property.forName("prix_actuel").desc()).list();
//        for (Produit p : produitMBean.getProduitList())
//        	System.out.println(p);
//        
//		// Il y a 16 produits dans la base => le id sera 17
//		assertEquals(17, prd.getIdProduit());
		// Le 17e enchere doit etre dans notre BD
		assertEquals(prd, .getProduit(prd.getIdProduit()));
    }

}
