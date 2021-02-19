package com.bg.spring.dao.impl;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.bg.hibernate.model.Produit;
import com.bg.spring.dao.ProduitDao;

class ProduitDaoImplTest {
	private SessionFactory sessionFactory;

//	@BeforeEach
//	void testSession() throws SQLException {
//		sessionFactory.openSession().isConnected();
//	}

	@Test
	public void testFiltrerProduits() throws SQLException {

		Produit prd = new Produit("batterie", 3, "text4", "", 3, 45.00);
		ProduitDao daoP = new ProduitDaoImpl();
		Produit prd1 = (Produit) daoP.filtrerProduits(3, "batterie");
		assertEquals(prd, prd1);
	}

	}
