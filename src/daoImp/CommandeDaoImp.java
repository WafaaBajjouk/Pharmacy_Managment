 package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.ConnexionSingleton;
import dao.CommandeDao;
import models.Commande;

public class CommandeDaoImp implements CommandeDao {
	Connection conn=ConnexionSingleton.getInstance();


	@Override
	public void addCommande(Commande commande) {
		try {
			
			
		PreparedStatement stm= conn.prepareStatement("insert into Commandes values (?,?,?,?,?,?);");
		
		stm.setString(1,commande.getId_commande());
		stm.setString(2,commande.getId_fournisseur());
		stm.setInt(3,commande.getMedicament());
		stm.setInt(4,commande.getQuantite_totale());
		stm.setDouble(5,commande.getPrix_total());
		stm.setString(6,commande.getDate_commande());

		stm.executeUpdate();
		System.out.println("Commande bien ajoute!");
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public List<Commande> getAllCommandes() {
		
		List<Commande> Commandes = new ArrayList<Commande>();
		
		
		try {
		
		Statement stm= conn.createStatement();
		
		
		ResultSet res= stm.executeQuery("Select * from Commandes;");
		
		while(res.next()) {
			Commande c=new Commande();
			c.setId_commande(res.getString("Id_commande"));
			c.setId_fournisseur(res.getString("Id_fournisseur"));
			c.setMedicament(res.getInt("Id_medicament"));
			c.setQuantite_totale(res.getInt("Quantite_total"));
			c.setPrix_total(res.getDouble("Prix_total"));
			c.setDate_commande(res.getString("Date_commande"));
			Commandes.add(c);

		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.print("Affichage");
		for(int i=0; i<Commandes.size() ; i++) {
		      System.out.println(Commandes.get(i));
		}

				return Commandes;
	}

	@Override
	public Commande getCommandeById(String id) {
		Commande c=new Commande();
		try {
						
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from Commandes where Id_Commande=?;");
	         preparedStatement.setString(1, id);

			
			ResultSet res= preparedStatement.executeQuery();
			
			
			while(res.next()) {
				c.setId_commande(res.getString("Id_commande"));
				c.setId_fournisseur(res.getString("Id_fournisseur"));
				c.setMedicament(res.getInt("Id_medicament"));
				c.setQuantite_totale(res.getInt("Quantite_total"));
				c.setPrix_total(res.getDouble("Prix_total"));
				c.setDate_commande(res.getString("Date_commande"));
				
			}
			
			System.out.println(c);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return c;

	}

	@Override
	public boolean UpdateCommande(Commande commande, String id) {
		final String sql="UPDATE Commandes SET Id_commande=? , Id_fournisseur=?, Id_medicament =?, Quantite_total=? , Prix_total=? , date_commande=?  WHERE Id_commande=? " ;
		 PreparedStatement stm;
		try {
			
		  stm = conn.prepareStatement(sql);
		  
			stm.setString(1,commande.getId_commande());
			stm.setString(2,commande.getId_fournisseur());
			stm.setInt(3,commande.getMedicament());
			stm.setInt(4,commande.getQuantite_totale());
			stm.setDouble(5,commande.getPrix_total());
			stm.setString(6,commande.getDate_commande());
			
			stm.setString(7,id);


         stm.executeUpdate();
         System.out.println("la commande modifier: ");


	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean DeleteCommande(String id) {
		
		Statement statement;
		try {
			 PreparedStatement preparedStatement;
			 preparedStatement = conn.prepareStatement("DELETE FROM commandes where id_commande= ?");
			  preparedStatement.setString(1,id);
				
			preparedStatement.executeUpdate();
			 
            System.out.println("la commande est suprimee: ");
            
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	}

}
