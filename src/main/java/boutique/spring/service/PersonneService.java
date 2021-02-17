package boutique.spring.service;

import boutique.hibernate.model.Personne;

import java.util.List;

public interface PersonneService {
    Personne personneInfo(int idPersonne);

    List<Personne> personneInfoList();
}
