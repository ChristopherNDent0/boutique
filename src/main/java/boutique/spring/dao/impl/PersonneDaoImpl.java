package boutique.spring.dao.impl;

import boutique.hibernate.model.Personne;
import boutique.spring.dao.PersonneDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PersonneDaoImpl implements PersonneDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Transactional
    @Override
    public Personne personneInfo(int idPersonne) {
        return (Personne) sessionFactory.getCurrentSession().get(Personne.class, idPersonne);
    }

    @Transactional
    @Override
    public List<Personne> personneInfoList() {
        @SuppressWarnings("unchecked")
        List<Personne> personneList = (List<Personne>) sessionFactory.getCurrentSession()
                .createCriteria(Personne.class).list();
        return personneList;
    }
}
