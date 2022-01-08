package models;

public class Fournisseur {
	
	private String Id_fournisseur;
	private String Nom;
	private String Prenom;
	private String Email_fournisseur;
	private String Telephone_fournisseur;
	private String Societe;
	private String Id_contrat;
	private String Telephone_societe;
	private String Email_societe;
	private String Adresse_societe;
	
	//constructor
	public Fournisseur(String cin, String nom, String prenom, String email_fournisseur, String telephone_fournisseur,
			String societe, String id_contrat, String telephone_societe, String email_societe, String adresse_societe) {
//		super();
		this.Id_fournisseur= cin;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Email_fournisseur = email_fournisseur;
		this.Telephone_fournisseur = telephone_fournisseur;
		this.Societe = societe;
		this.Id_contrat = id_contrat;
		this.Telephone_societe = telephone_societe;
		this.Email_societe = email_societe;
		this.Adresse_societe = adresse_societe;
	}
	
	
	
	
	// Getters and setters 

	@Override
	public String toString() {
		return "Fournisseur [Id_fournisseur=" + Id_fournisseur + ", Nom=" + Nom + ", Prenom=" + Prenom
				+ ", Email_fournisseur=" + Email_fournisseur + ", Telephone_fournisseur=" + Telephone_fournisseur
				+ ", Societe=" + Societe + ", Id_contrat=" + Id_contrat + ", Telephone_societe=" + Telephone_societe
				+ ", Email_societe=" + Email_societe + ", Adresse_societe=" + Adresse_societe + "]";
	}




	public Fournisseur() {
		// TODO Auto-generated constructor stub
	}



	public String getId_fournisseur() {
		return this.Id_fournisseur;
	}

	public void setId_fournisseur(String id_fournisseur) {
		this.Id_fournisseur = id_fournisseur;
	}

	
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}
	public String getPrenom() {
		return this.Prenom;
	}
	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}
	public String getEmail_fournisseur() {
		return this.Email_fournisseur;
	}
	public void setEmail_fournisseur(String email_fournisseur) {
		this.Email_fournisseur = email_fournisseur;
	}
	public String getTelephone_fournisseur() {
		return this.Telephone_fournisseur;
	}
	public void setTelephone_fournisseur(String telephone_fournisseur) {
		this.Telephone_fournisseur = telephone_fournisseur;
	}
	public String getSociete() {
		return this.Societe;
	}
	public void setSociete(String societe) {
		this.Societe = societe;
	}
	public String getId_contrat() {
		return this.Id_contrat;
	}
	public void setId_contrat(String id_contrat) {
		this.Id_contrat = id_contrat;
	}
	public String getTelephone_societe() {
		return this.Telephone_societe;
	}
	public void setTelephone_societe(String telephone_societe) {
		this.Telephone_societe = telephone_societe;
	}
	public String getEmail_societe() {
		return this.Email_societe;
	}
	public void setEmail_societe(String email_societe) {
		this.Email_societe = email_societe;
	}
	public String getAdresse_societe() {
		return this.Adresse_societe;
	}
	public void setAdresse_societe(String adresse_societe) {
		this.Adresse_societe = adresse_societe;
	}
	
	
	
	
	

}
