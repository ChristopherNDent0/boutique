package boutique.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private int idCategorie;

    @Column(name = "libelle")
    private String libelle;


    public Categorie() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Categorie(int idCategorie, String libelle) {
        super();
        this.idCategorie = idCategorie;
        this.libelle = libelle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie [idCategorie=" + idCategorie + ", libelle=" + libelle + "]";
    }

}
