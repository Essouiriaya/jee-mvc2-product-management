package dao;

import model.Produit;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProduitImpl implements ProduitDAO {

    public void addProduit(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(p);

        tx.commit();
        session.close();
    }

    public void deleteProduit(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Produit p = session.get(Produit.class, id);
        if (p != null) {
            session.delete(p);
        }

        tx.commit();
        session.close();
    }

    public Produit getProduitById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Produit p = session.get(Produit.class, id);

        session.close();
        return p;
    }

    public List<Produit> getAllProduits() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Produit> list = session.createQuery("from Produit", Produit.class).list();

        session.close();
        return list;
    }

    public void updateProduit(Produit p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(p);

        tx.commit();
        session.close();
    }
}