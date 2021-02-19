package boutique.jsf.manager;

import boutique.hibernate.model.Produit;

import javax.faces.bean.ManagedBean;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
public class PanierManager implements Serializable {
    private static final long serialVersionUID = 1L;


    private List<ColumnModel> columns;
    private List<Produit> produits;

    private String columnName;

    public PanierManager() {
        createDynamicColumns();
        addProduit();
    }

    private void addProduit() {
        produits = new ArrayList<Produit>();

        Produit w1 = new Produit("Spanky", 1, "flap", "#", 1, 101.00);
        Produit w3 = new Produit("Sparky", 11, "Soot", "#", 2, 110.00);
        Produit w2 = new Produit("Spooly", 111, "Nail", "#", 3, 100.10);
        Produit w4 = new Produit("Spammy", 1111, "Thread", "#", 4, 110.11);

        produits.add(w1);
        produits.add(w2);
        produits.add(w3);
        produits.add(w4);
    }


    private void createDynamicColumns() {

        columns = new ArrayList<ColumnModel>();
        columns.add(new ColumnModel("Nom", "nom"));
        columns.add(new ColumnModel("Stock", "stock"));
        columns.add(new ColumnModel("Image", "urlImage"));
        columns.add(new ColumnModel("Categorie", "idCategorie"));
        columns.add(new ColumnModel("Prix", "prixActuel"));
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    static public class ColumnModel implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String header;
        private final String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
    }
}