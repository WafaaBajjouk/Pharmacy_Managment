package models;


public class Gerant extends Pharmacien{
	
	
	
	private String Id_gerant;
	

	public Gerant(String cin, String nom, String prenom, String email, String telephone, double salaire,
			String adresse, String id_gerant) {
		super(cin, prenom,nom, prenom, email, telephone, salaire, adresse);
		this.Id_gerant=id_gerant;
	}


	public String getId_gerant() {
		return this.Id_gerant;
	}


	public void setId_gerant(String id_gerant) {
		this.Id_gerant = id_gerant;
	}

	
}
