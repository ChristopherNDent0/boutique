package boutique.spring.service.impl;

import boutique.hibernate.model.Personne;
import boutique.spring.dao.PersonneDao;
import boutique.spring.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneDao personneDao;

    public PersonneDao getPersonneDao() {
        return personneDao;
    }

    @Override
    public Personne personneInfo(int idPersonne) {
        return personneDao.personneInfo(idPersonne);
    }

    @Override
    public List<Personne> personneInfoList() {
        return personneDao.personneInfoList();
    }
}
