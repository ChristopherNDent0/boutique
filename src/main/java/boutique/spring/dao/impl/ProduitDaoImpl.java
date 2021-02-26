package boutique.spring.dao.impl;

import boutique.hibernate.model.Produit;
import boutique.spring.dao.ProduitDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class ProduitDaoImpl implements ProduitDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public Produit getProduit(int id) {
        Produit produit = (Produit) sessionFactory.getCurrentSession().get(Produit.class, id);
        return produit;
    }

    @Transactional
    @Override
    public List<Produit> getAllProduit() {
        @SuppressWarnings("unchecked")
        List<Produit> produit = (List<Produit>) sessionFactory.getCurrentSession().
                createCriteria(Produit.class).list();
        // or below query
        /*
         * @SuppressWarnings("unchecked") List<Produit> produit =
         * (List<Produit>)sessionFactory.getCurrentSession().createQuery(
         * "from Produit").list();
         */
        return produit;
    }

    @Override
    @Transactional
    public void ajouterProduit(Produit produit) {
        Session session = sessionFactory.openSession();
        try {
            final Transaction transaction = session.beginTransaction();
            try {
                session.save(produit);
                transaction.commit();

            } catch (Exception ex) {
                // Log the exception here
                transaction.rollback();
                throw ex;
            }
        } finally {
            session.close();
        }
    }

    @Transactional
    @Override
    public List<Produit> getProduitsByCategorie(int idCat, String nomProduit) {
        //Restrictions.or(Restrictions.isEmpty("nomproduit"),Restrictions.eq("prix", 0));
        @SuppressWarnings("unchecked")
//		List<Produit> produits = (List<Produit>) sessionFactory.getCurrentSession().
//		createCriteria(Produit.class).add(Restrictions.eqOrIsNull("idCategorie",idCat))
//		.add(Restrictions.ilike("nom", nomProduit,MatchMode.ANYWHERE)).list();

//		List<Produit> produits = (List<Produit>) sessionFactory.getCurrentSession().
//		createCriteria(Produit.class).add( Restrictions.or(
//	    Restrictions.eq("idCategorie",idCat)).add(Restrictions.ilike("nom", nomProduit,MatchMode.ANYWHERE)))
//		.add((Criterion) ((Criteria) Restrictions.like("prix_actuel", prix)).addOrder(Property.
//		forName("prix_actuel").desc()).list());

        List<Produit> produits = (List<Produit>) sessionFactory.getCurrentSession().
                createCriteria(Produit.class).add(Restrictions.or(
                Restrictions.eq("idCategorie", idCat)).add(Restrictions.ilike("nom", nomProduit, MatchMode.ANYWHERE)))
                .list();

        return produits;
//		
    }
}
