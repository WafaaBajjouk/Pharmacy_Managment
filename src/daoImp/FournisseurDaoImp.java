package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.ConnexionSingleton;
import dao.FournisseurDao;
import models.Fournisseur;

public class FournisseurDaoImp implements FournisseurDao{

	Connection conn=ConnexionSingleton.getInstance();



		@Override
		public Fournisseur getFournisseurByName(String nom , String prenom) {
			Fournisseur f = new Fournisseur();
			try {
				
				PreparedStatement preparedStatement = conn.prepareStatement("Select * from Fournisseurs where nom=? and Prénom=?;");
		         preparedStatement.setString(1, nom);
		         preparedStatement.setString(2, prenom);
				
				ResultSet res= preparedStatement.executeQuery();
					
				while(res.next()) {	
					f.setId_fournisseur(res.getString("id_fournisseur"));
					f.setNom(res.getString("nom"));
					f.setPrenom(res.getString("Prénom"));
					f.setEmail_fournisseur(res.getString("email_fournisseur"));
					f.setTelephone_fournisseur(res.getString("telephone_fournisseur"));
					f.setSociete(res.getString("societe"));
					f.setId_contrat(res.getString("id_contrat"));
					f.setTelephone_societe(res.getString("telephone_societe"));
					f.setEmail_societe(res.getString("email_societe"));
					f.setAdresse_societe(res.getString("adresse_societe"));				
				}
				
				System.out.println(f);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}	
			return f;
		}

		@Override
		public boolean UpdateFournisseur(Fournisseur fournisseur, String nom, String prenom) {
			
			final String sql="UPDATE Fournisseurs SET id_fournisseur=? , nom=?, Prénom=?, email_fournisseur =? , telephone_fournisseur=? , societe=? , id_contrat=? , telephone_societe=? , email_societe=? , adresse_societe=? WHERE nom=? and Prénom=? " ;
			 PreparedStatement preparedStatement;
			try {
				
			  preparedStatement = conn.prepareStatement(sql);
			
		      preparedStatement.setString(1,fournisseur.getId_fournisseur());
		      preparedStatement.setString(2,fournisseur.getNom());
		      preparedStatement.setString(3,fournisseur.getPrenom());
		      preparedStatement.setString(4,fournisseur.getEmail_fournisseur());
		      preparedStatement.setString(5,fournisseur.getTelephone_fournisseur());
		      preparedStatement.setString(6,fournisseur.getSociete());
		      preparedStatement.setString(7,fournisseur.getId_contrat());
		      preparedStatement.setString(8,fournisseur.getTelephone_societe());
		      preparedStatement.setString(9,fournisseur.getEmail_societe());
		      preparedStatement.setString(10,fournisseur.getAdresse_societe());
		      
		      preparedStatement.setString(11,nom);
		      preparedStatement.setString(12,prenom);
		      
		      

	          preparedStatement.executeUpdate();
	          System.out.println("le pharmacien modifier: ");


		      
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
			return false;
		}

		@Override
		public boolean DeleteFournisseur(String id_fournisseur) {
			
			Statement statement;
			try {
				 PreparedStatement preparedStatement;
				 preparedStatement = conn.prepareStatement("DELETE FROM Fournisseurs where id_fournisseur= ?");
				  preparedStatement.setString(1, id_fournisseur);
					
				preparedStatement.executeUpdate();
				 
	            System.out.println("le fournisseur est bien supprimée !!!");
	            
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}



		@Override
		public void addFournisseur(Fournisseur fournisseur) {
			try {
				
				PreparedStatement stm= conn.prepareStatement("insert into Fournisseurs values (?,?,?,?,?,?,?,?,?,?);");
				stm.setString(1,fournisseur.getId_fournisseur());
				stm.setString(2,fournisseur.getNom());
				stm.setString(3,fournisseur.getPrenom());
				stm.setString(4,fournisseur.getEmail_fournisseur());
				stm.setString(5,fournisseur.getTelephone_fournisseur());
				stm.setString(6, fournisseur.getSociete());
				stm.setString(7,fournisseur.getId_contrat());
				stm.setString(8, fournisseur.getTelephone_societe());
				stm.setString(9, fournisseur.getEmail_societe());
				stm.setString(10, fournisseur.getAdresse_societe());
				
				stm.executeUpdate();
				System.out.println("Fournisseur est bien ajouté !!!");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}



		@Override
		public List<Fournisseur> getAllFournisseurs() {
			List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
			
			try {
			
			Statement stm= conn.createStatement();
			ResultSet res= stm.executeQuery("Select * from Fournisseurs;");
			
			while(res.next()) {
				Fournisseur f=new Fournisseur();
				
				f.setId_fournisseur(res.getString("id_fournisseur"));
				f.setNom(res.getString("nom"));
				f.setPrenom(res.getString("Prénom"));
				f.setEmail_fournisseur(res.getString("email_fournisseur"));
				f.setTelephone_fournisseur(res.getString("telephone_fournisseur"));
				f.setSociete(res.getString("societe"));
				f.setId_contrat(res.getString("id_contrat"));
				f.setTelephone_societe(res.getString("telephone_societe"));
				f.setEmail_societe(res.getString("email_societe"));
				f.setAdresse_societe(res.getString("adresse_societe"));
				
				fournisseurs.add(f);

			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.print("Affichage");
			for(int i=0; i<fournisseurs.size() ; i++) {
			      System.out.println(fournisseurs.get(i));
			}

					return fournisseurs;
			
		}


}
