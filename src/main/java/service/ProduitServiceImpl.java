package service;

import dao.ProduitDAO;
import dao.ProduitImpl;
import model.Produit;
import java.util.List;

public class ProduitServiceImpl implements ProduitService {

    private static ProduitServiceImpl instance;
    private ProduitDAO dao;

    private ProduitServiceImpl() {
        dao = new ProduitImpl();
    }

    public static ProduitServiceImpl getInstance() {
        if (instance == null)
            instance = new ProduitServiceImpl();
        return instance;
    }

    @Override
    public void addProduit(Produit p) {
        dao.addProduit(p);
    }

    @Override
    public void deleteProduit(Long id) {
        dao.deleteProduit(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return dao.getAllProduits();
    }

    @Override
    public Produit getProduitById(Long id) {
        return dao.getProduitById(id);
    }

    @Override
    public void updateProduit(Produit p) {
        dao.updateProduit(p);
    }
}