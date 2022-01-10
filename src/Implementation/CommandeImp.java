 package Implementation;

import java.sql.*;
import java.util.Vector;

import DAO.CommandeDAO;
import DAO.CommandeDAO;
import app.ConnexionSingleton;
import models.Commande;

public class CommandeImp implements CommandeDAO{
	Connection conn = ConnexionSingleton.getInstance();


	@Override
	public void addCommande(Commande commande) {
		try {
			
			PreparedStatement stm= conn.prepareStatement("INSERT INTO Commandes VALUES (?,?,?,?,?,?)");
			
			stm.setString(1,commande.getId_commande());
			stm.setString(2,commande.getId_fournisseur());
			stm.setInt(3,commande.getMedicament());
			stm.setInt(4,commande.getQuantite_totale());
			stm.setDouble(5,commande.getPrix_total());
			stm.setDate(6,(Date) commande.getDate_commande());
	
			stm.executeUpdate();
			System.out.println("Commande est bien ajoutée !!!");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Vector<Vector<String>> getAllCommandes() {
		
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		
		try {
		
			Statement stm= conn.createStatement();
			ResultSet res= stm.executeQuery("SELECT * FROM Commandes");
			
			while(res.next()) {
				Vector<String> row = new Vector<String>();
				
				row.addElement(res.getString("Id_commande"));
				row.addElement(res.getString("Id_fournisseur"));
				row.addElement(String.valueOf(res.getInt("Id_medicament")));
				row.addElement(String.valueOf(res.getInt("Quantite_total")));
				row.addElement(String.valueOf(res.getDouble("Prix_total")));
				row.addElement(String.valueOf(res.getDate("Date_commande")));
				
				rows.addElement(row);
	
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public Commande getCommandeById(String id) {
		
		Commande c=new Commande();
		try {
						
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Commandes WHERE Id_Commande=?");
	        preparedStatement.setString(1, id);

			ResultSet res= preparedStatement.executeQuery();
			
			while(res.next()) {
				
				c.setId_commande(res.getString("Id_commande"));
				c.setId_fournisseur(res.getString("Id_fournisseur"));
				c.setMedicament(res.getInt("Id_medicament"));
				c.setQuantite_totale(res.getInt("Quantite_total"));
				c.setPrix_total(res.getDouble("Prix_total"));
				c.setDate_commande(res.getDate("Date_commande"));
				
			}
			
			System.out.println(c);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		
		return c;

	}

	@Override
	public boolean UpdateCommande(Commande commande, String id) {
		final String sql="UPDATE Commandes SET Id_fournisseur=?, Id_medicament =?, Quantite_total=? , Prix_total=? , date_commande=?  WHERE Id_commande=? " ;
		PreparedStatement stm;
		try {
			
			stm = conn.prepareStatement(sql);
			  
			stm.setString(1,commande.getId_fournisseur());
			stm.setInt(2,commande.getMedicament());
			stm.setInt(3,commande.getQuantite_totale());
			stm.setDouble(4,commande.getPrix_total());
			stm.setDate(5,(Date) commande.getDate_commande());
				
			stm.setString(6,id);
	
	
	        stm.executeUpdate();
	        System.out.println("la commande est modifiée !!! ");
		      
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean DeleteCommande(String id) {
		try {
			 PreparedStatement preparedStatement;
			 preparedStatement = conn.prepareStatement("DELETE FROM commandes WHERE id_commande= ?");
			 preparedStatement.setString(1,id);
				
			 preparedStatement.executeUpdate();
			 
             System.out.println("la commande est supprimée !!! ");
            
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}

}