package boutique.spring.dao.impl;

import boutique.hibernate.model.Categorie;
import boutique.spring.dao.CategorieDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class CategorieDaoImpl implements CategorieDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Categorie> getAllCategorie() {
        @SuppressWarnings("unchecked")
        List<Categorie> categorie = (List<Categorie>) sessionFactory.getCurrentSession().
                createCriteria(Categorie.class).list();

        return categorie;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
