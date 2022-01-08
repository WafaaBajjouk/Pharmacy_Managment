package dao;

import java.util.List;

import models.Commande;

public interface CommandeDao {
	public void addCommande(Commande commande);
	public List<Commande> getAllCommandes();
	public Commande getCommandeById(String id);
	public boolean UpdateCommande(Commande commande,String id);
	public boolean DeleteCommande(String id);
}
