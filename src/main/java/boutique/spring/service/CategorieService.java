package boutique.spring.service;

import boutique.hibernate.model.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie getCategorie(int id);

    List<Categorie> getAllCategorie();
}
