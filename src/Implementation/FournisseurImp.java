package Implementation;
import java.sql.*;
import java.util.Vector;

import DAO.FournisseurDAO;
import app.ConnexionSingleton;
import models.Fournisseur;

public class FournisseurImp implements FournisseurDAO{
    	Connection conn = ConnexionSingleton.getInstance();
     
    	@Override
    	public void addFournisseur(Fournisseur fournisseur) {
    		try {
			
				PreparedStatement stm= conn.prepareStatement("INSERT INTO Fournisseurs VALUES (?,?,?,?,?,?,?,?,?,?)");
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
		public Vector<Vector<String>> getAllFournisseurs() {
			
			Vector<Vector<String>> rows = new Vector<Vector<String>>();
			
			try {
			
				Statement stm= conn.createStatement();
				ResultSet res= stm.executeQuery("SELECT * FROM Fournisseurs");
				
				while(res.next()) {
					
					Vector<String> row = new Vector<String>();
					
					row.addElement(res.getString("id_fournisseur"));
					row.addElement(res.getString("nom"));
					row.addElement(res.getString("prénom"));
					row.addElement(res.getString("email_fournisseur"));
					row.addElement(res.getString("telephone_fournisseur"));
					row.addElement(res.getString("societe"));
					row.addElement(res.getString("id_contrat"));
					row.addElement(res.getString("telephone_societe"));
					row.addElement(res.getString("email_societe"));
					row.addElement(res.getString("adresse_societe"));
					
					rows.addElement(row);
	
				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}

			return rows;

		}

		@Override
		public Fournisseur getFournisseurByName(String nom , String prenom) {
			
			Fournisseur f = new Fournisseur();
			
			try {
				
				PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Fournisseurs WHERE nom=? and prenom=?");
		         preparedStatement.setString(1, nom);
		         preparedStatement.setString(2, prenom);
				
				ResultSet res= preparedStatement.executeQuery();
					
				while(res.next()) {	
					
					f.setId_fournisseur(res.getString("id_fournisseur"));
					f.setNom(res.getString("nom"));
					f.setPrenom(res.getString("prenom"));
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
		public boolean UpdateFournisseur(Fournisseur fournisseur, String id) {
			
			final String sql="UPDATE Fournisseurs SET nom=?, prenom=?, email_fournisseur =? , telephone_fournisseur=? , societe=? , id_contrat=? , telephone_societe=? , email_societe=? , adresse_societe=? WHERE id_fournisseur = ? " ;
			 PreparedStatement preparedStatement;
			 
			try {
				
			  preparedStatement = conn.prepareStatement(sql);
			
		      preparedStatement.setString(1,fournisseur.getNom());
		      preparedStatement.setString(2,fournisseur.getPrenom());
		      preparedStatement.setString(3,fournisseur.getEmail_fournisseur());
		      preparedStatement.setString(4,fournisseur.getTelephone_fournisseur());
		      preparedStatement.setString(5,fournisseur.getSociete());
		      preparedStatement.setString(6,fournisseur.getId_contrat());
		      preparedStatement.setString(7,fournisseur.getTelephone_societe());
		      preparedStatement.setString(8,fournisseur.getEmail_societe());
		      preparedStatement.setString(9,fournisseur.getAdresse_societe());
		      
		      preparedStatement.setString(10,fournisseur.getId_fournisseur());

	          preparedStatement.executeUpdate();
	          System.out.println("le pharmacien modifier: ");

			} catch (SQLException e) {
				e.printStackTrace();
			}
					
			return false;
		}

		@Override
		public boolean DeleteFournisseur(String id_fournisseur) {
			try {
				 PreparedStatement preparedStatement;
				 preparedStatement = conn.prepareStatement("DELETE FROM Fournisseurs WHERE id_fournisseur= ?");
				 preparedStatement.setString(1, id_fournisseur);
					
				 preparedStatement.executeUpdate();
				 
	             System.out.println("le fournisseur est bien supprimée !!!");
	            
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
			
		}
}