package models;

import java.sql.Date;

public class Commande {

	private String Id_commande;
	private String Id_fournisseur;
	private int medicament;
	private int Quantite_totale;
	private double Prix_total;
	private java.util.Date date_commande;
	
	
	// constructor
	public Commande(String id_commande, String id_fournisseur, int medicament, int quantite_totale,
			double prix_total, Date date_commande) {
//		super();
		this.Id_commande = id_commande;
		this.Id_fournisseur = id_fournisseur;
		this.medicament = medicament;
		this.Quantite_totale = quantite_totale;
		this.Prix_total = prix_total;
		this.date_commande = date_commande;
	}

	// getters and setters 

	
	
	public Commande() {
	}


	@Override
	public String toString() {
		return "Commande [Id_commande=" + Id_commande + ", Id_fournisseur=" + Id_fournisseur + ", medicament="
				+ medicament + ", Quantite_totale=" + Quantite_totale + ", Prix_total=" + Prix_total
				+ ", date_commande=" + date_commande + "]";
	}

	public String getId_commande() {
		return this.Id_commande;
	}


	public void setId_commande(String id_commande) {
		this.Id_commande = id_commande;
	}


	public String getId_fournisseur() {
		return this.Id_fournisseur;
	}


	public void setId_fournisseur(String id_fournisseur) {
		this.Id_fournisseur = id_fournisseur;
	}


	public int getMedicament() {
		return this.medicament;
	}


	public void setMedicament(int medicament) {
		this.medicament = medicament;
	}


	public int getQuantite_totale() {
		return this.Quantite_totale;
	}


	public void setQuantite_totale(int quantite_totale) {
		this.Quantite_totale = quantite_totale;
	}


	public double getPrix_total() {
		return this.Prix_total;
	}


	public void setPrix_total(double prix_total) {
		this.Prix_total = prix_total;
	}


	public java.util.Date getDate_commande() {
		return date_commande;
	}


	public void setDate_commande(java.util.Date date) {
		this.date_commande = date;
	}
	

	
	
	
	
	
	
	
	
}
