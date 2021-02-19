package com.bg.spring.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.bg.hibernate.model.Categorie;
import com.bg.spring.dao.CategorieDao;

class CategorieDaoImplTest {

	@Test
	public void testGetCategorie() throws SQLException {

		Categorie cat = new Categorie("telephone");
		CategorieDao daoC = new CategorieDaoImpl();
		Categorie cat1 = (Categorie) daoC.getCategorie(2);
		assertEquals(cat, cat1);
	}

}
