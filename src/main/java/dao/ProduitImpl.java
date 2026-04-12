package dao;

import java.util.*;

public class ProduitImpl implements ProduitDAO {

    private List<Produit> produits = new ArrayList<>();

    public void init(){
        addProduit(new Produit("PC 1","Sony",7000.0));
        addProduit(new Produit("PC 2","HP",6000.0));
    }

    public void addProduit(Produit p) {
        p.setIdProduit((long) (produits.size()+1));
        produits.add(p);
    }

    public void deleteProduit(Long id) {
        produits.remove(getProduitById(id));
    }

    public Produit getProduitById(Long id) {
        for(Produit p:produits){
            if(p.getIdProduit()== id) return p;
        }
        return null;
    }

    public List<Produit> getAllProduits() {
        return produits;
    }

    public void updateProduit(Produit p) {
        for(Produit pr:produits){
            if(pr.getIdProduit() == p.getIdProduit()){
                pr.setNom(p.getNom());
                pr.setDescription(p.getDescription());
                pr.setPrix(p.getPrix());
            }
        }
    }
}