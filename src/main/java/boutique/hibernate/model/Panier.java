package boutique.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;

    private int idProduit;
    private String nomProduit;
    private int quantiteProduit;
    private String descriptionProduit;
    private String urlProduit;

}
