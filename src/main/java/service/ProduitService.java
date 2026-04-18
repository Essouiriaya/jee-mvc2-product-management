package service;

import java.util.List;
import model.Produit;

public interface ProduitService {
    void addProduit(Produit p);
    void deleteProduit(Long id);
    List<Produit> getAllProduits();
    Produit getProduitById(Long id);
    void updateProduit(Produit p);
}