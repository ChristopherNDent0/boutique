package boutique.spring.dao;

import boutique.hibernate.model.Personne;

import java.util.List;

public interface PersonneDao {
    Personne personneInfo(int idPersonne);

    List<Personne> personneInfoList();
}
