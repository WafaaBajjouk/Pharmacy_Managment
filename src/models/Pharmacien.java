package models;


public class Pharmacien {

	
	private String Cin;
	private String Password;
	private String Nom;
	private String Prenom;
	private String Email;
	private String Telephone;
	private double Salaire;
	private String Adresse;
	
	
	public Pharmacien(String cin,String password, String nom, String prenom, String email, String telephone, double salaire,
			String adresse) {
//		super();
		this.Cin = cin;
		this.Password=password;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Email = email;
		this.Telephone = telephone;
		this.Salaire = salaire;
		this.Adresse = adresse;
	}

	
	//getters and setters 
	
	

	public Pharmacien() {
	}


	@Override
	public String toString() {
		return "Pharmacien [Cin=" + Cin + ", Password=" + Password + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email="
				+ Email + ", Telephone=" + Telephone + ", Salaire=" + Salaire + ", Adresse=" + Adresse + "]";
	}


	public String getCin() {
		return this.Cin;
	}


	public void setCin(String cin) {
		this.Cin = cin;
	}
	

	public String getPassword() {
		return this.Password;
	}


	public void setPassword(String password) {
		this.Password = password;
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


	public String getEmail() {
		return this.Email;
	}


	public void setEmail(String email) {
		this.Email = email;
	}


	public String getTelephone() {
		return this.Telephone;
	}


	public void setTelephone(String telephone) {
		this.Telephone = telephone;
	}


	public double getSalaire() {
		return this.Salaire;
	}


	public void setSalaire(double salaire) {
		this.Salaire = salaire;
	}


	public String getAdresse() {
		return this.Adresse;
	}


	public void setAdresse(String adresse) {
		this.Adresse = adresse;
	}

	
}
