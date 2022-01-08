package app;

import java.sql.Connection;

import dao.CommandeDao;
import dao.FournisseurDao;
import dao.MedicamentDao;
import dao.PharmacienDao;
import daoImp.CommandeDaoImp;
import daoImp.FournisseurDaoImp;
import daoImp.MedicamentDaoImp;
import daoImp.PharmacienDaoImp;
import models.Commande;
import models.Fournisseur;
import models.Medicament;
import models.Pharmacien;

public class Main {
	
public static void main(String [] args ) {
	
	Connection conn= ConnexionSingleton.getInstance();
	
//	PharmacienDao pd= new PharmacienDaoImp();
//    Pharmacien p=new Pharmacien("BLooo","12883","wajfaa","bauk","WAGMAIL.COM","0765",35.9,"Casablanca");
////   pd.addPharmacien(p);
//   pd.getAllPharmaciens();
//   String cin="BL156164";
   String nom="nom";
   String prenom="prenom";
//   pd.getPharmacienById(nom,prenom);
//   
//   pd.UpdatePharmacien(p,nom,prenom);
//   
//   pd.getAllPharmaciens();
//   
////   pd.DeletePharmacien(cin);
	
	MedicamentDao md= new MedicamentDaoImp();
//	Medicament m= new Medicament(4,"MARQUE","DCI","PRESTATION","CLASS","DOSSAGE","FORM","TITULAIRE",78.08,78.66,"ST_COMM",8);
//	md.addCommande(m);
	
//	md.getAllMedicaments();
//	md.getMedicamentById(3);
//	md.DeleteMedicament(36);
//	md.UpdateMedicament(m, 36);
	
	CommandeDao cd= new CommandeDaoImp();
	Commande c= new Commande("IDu","Iou",4,4,30.53,"12-09-2021");
//	cd.addCommande(c);
	cd.getAllCommandes();
	String id="IDu";
//	cd.getCommandeById(id);
//	cd.UpdateCommande(c, id);
	cd.DeleteCommande(id);
//	
//	
//	FournisseurDao fd= new FournisseurDaoImp();
//	Fournisseur f= new Fournisseur("IDfou","nom111","prenom111","email","tel","socoiete","id","tele_soociete","emaili_societe","adressei_societe");
//	fd.addFournisseur(f);
//	fd.getAllFournisseurs();
//	fd.DeleteFournisseur(nom);
//	fd.getFournisseurByName(nom, prenom);
//	fd.UpdateFournisseur(f, nom, prenom);
	

}
}
