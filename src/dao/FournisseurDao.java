package dao;

import java.util.List;

import models.Fournisseur;


public interface FournisseurDao {
	public void addFournisseur(Fournisseur fournisseur);
	public List<Fournisseur> getAllFournisseurs();
	public Fournisseur getFournisseurByName(String nom , String prenom);
	public boolean UpdateFournisseur(Fournisseur Fournisseur,String cin, String prenom);
	public boolean DeleteFournisseur(String cin);
}
