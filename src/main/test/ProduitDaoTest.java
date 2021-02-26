import boutique.hibernate.model.Produit;
import boutique.jsf.mbean.ProduitMBean;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

class ProduitDaoTest {

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
//        assertEquals(prd, .getProduit(prd.getIdProduit()));
    }

}