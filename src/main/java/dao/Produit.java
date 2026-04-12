package dao;

public class Produit{
	private long idProduit;
	private String nom;
	private String description;
	private Double prix;
	
	public Produit() {}

    public Produit(String nom, String description, Double prix) {
        this.setNom(nom);
        this.setDescription(description);
        this.setPrix(prix);
    }

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
    
    
}