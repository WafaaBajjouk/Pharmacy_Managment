package DAO;

import java.util.Vector;

import models.Commande;

public interface CommandeDAO {
	public void addCommande(Commande commande);
	public Vector<Vector<String>> getAllCommandes();
	public Commande getCommandeById(String id);
	public boolean UpdateCommande(Commande commande,String id);
	public boolean DeleteCommande(String id);
}