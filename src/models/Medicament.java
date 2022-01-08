package models;

public class Medicament {


	private int id; 
	private String marque;
	private String dci;
	private String Presentation;
	private String classe; //class
	private String dosage;
	private String forme;
	private String titulaire;
	private double ppv;
	private double PBase_Remb;
	private String st_comm;
	private int quantite;
	
	
	
	public Medicament(int id_medicament, String marque, String dci,
			String prestentation, String cla, String dosage, String forme,String titulaire,
			double ppv, double pbase_remp, String st_comm, int quantite) {
		super();
		this.id = id_medicament;
		this.marque = marque;
		this.dci = dci;
		this.Presentation = prestentation;
		this.classe = cla;
		this.dosage = dosage;
		this.forme = forme;
		this.titulaire=titulaire;
		this.ppv = ppv;
		this.PBase_Remb = pbase_remp;
		this.st_comm = st_comm;
		this.quantite = quantite;
	}
	
	
	
	@Override
	public String toString() {
		return "Medicament [id_medicament=" + id + ", marque=" + marque + ", dci=" + dci + ", prestentation="
				+ Presentation + ", cla=" + classe + ", dosage=" + dosage + ", forme=" + forme + ", titulaire="
				+ titulaire + ", ppv=" + ppv + ", pbase_remp=" + PBase_Remb + ", st_comm=" + st_comm + ", quantite="
				+ quantite + "]";
	}



	public Medicament() {
		// TODO Auto-generated constructor stub
	}

	public int getId_medicament() {
		return id;
	}
	public String getTitulaire() {
		return titulaire;
	}
	public String getMarque() {
		return marque;
	}
	public String getDci() {
		return dci;
	}

	
	public String getPrestentation() {
		return Presentation;
	}
	public String getCla() {
		return classe;
	}

	public String getDosage() {
		return dosage;
	}
	public String getForme() {
		return forme;
	}

	public double getPpv() {
		return ppv;
	}
	public double getPbase_remp() {
		return PBase_Remb;
	}
	public String getSt_comm() {
		return st_comm;
	}
	public int getQuantite() {
		return quantite;
	}


	public void setId_medicament(int id_medicament) {
		this.id = id_medicament;
	}
	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public void setDci(String dci) {
		this.dci = dci;
	}

	
	public void setPrestentation(String prestentation) {
		this.Presentation = prestentation;
	}
	public void setCla(String cla) {
		this.classe = cla;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public void setForme(String forme) {
		this.forme = forme;
	}

	public void setPpv(double ppv) {
		this.ppv = ppv;
	}
	public void setPbase_remp(double pbase_remp) {
		this.PBase_Remb = pbase_remp;
	}
	public void setSt_comm(String st_comm) {
		this.st_comm = st_comm;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
}
