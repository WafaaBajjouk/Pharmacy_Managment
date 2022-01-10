package DAO;

import java.util.Vector;

import models.Fournisseur;

public interface FournisseurDAO {
	public void addFournisseur(Fournisseur fournisseur);
	public Vector<Vector<String>> getAllFournisseurs();
	public Fournisseur getFournisseurByName(String nom , String prenom);
	public boolean UpdateFournisseur(Fournisseur fournisseur, String cin);
	public boolean DeleteFournisseur(String id_fournisseur);
}
