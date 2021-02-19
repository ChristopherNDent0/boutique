package boutique.spring.service.impl;

import boutique.hibernate.model.Categorie;
import boutique.spring.dao.CategorieDao;
import boutique.spring.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieDao categorieDao;

    @Override
    public Categorie getCategorie(int id) {
        return null;
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieDao.getAllCategorie();
    }
}
