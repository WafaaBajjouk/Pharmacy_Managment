package Implementation;

import java.sql.*;
import java.util.Vector;

import DAO.PharmacienDAO;
import app.ConnexionSingleton;
import models.Pharmacien;

public class PharmacienImp implements PharmacienDAO{
	Connection conn = ConnexionSingleton.getInstance();
	
    @Override
	public void addPharmacien(Pharmacien pharmacien) {
		try {
			PreparedStatement stm= conn.prepareStatement("insert into Pharmaciens values (?,?,?,?,?,?,?,?)");
			stm.setString(1,pharmacien.getCin());
			stm.setString(2,pharmacien.getPassword());
			stm.setString(3,pharmacien.getNom());
			stm.setString(4,pharmacien.getPrenom());
			stm.setString(5,pharmacien.getEmail());
			stm.setString(6, pharmacien.getTelephone());
			stm.setDouble(7,pharmacien.getSalaire());
			stm.setString(8, pharmacien.getAdresse());
	
			stm.executeUpdate();
			System.out.println("Pharmacien bien ajoute!");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Vector<Vector<String>>  getAllPharmaciens() {
		
	    Vector<Vector<String>> rows = new Vector<Vector<String>>();
		
		try {

			Statement stm= conn.createStatement();
			ResultSet res= stm.executeQuery("Select * from Pharmaciens");
			
			while(res.next()) {
			  	Vector<String> row = new Vector<String>();
		    	row.addElement(res.getString("CIN"));
		    	row.addElement(res.getString("Password"));
		    	row.addElement(res.getString("Nom"));
		    	row.addElement(res.getString("Prénom"));
		    	row.addElement(res.getString("Email"));
		    	row.addElement(res.getString("Telephone"));
		    	row.addElement(res.getString("Salaire"));
		    	row.addElement(res.getString("Adresse"));
		    	
		    	rows.addElement(row);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
		
	}

	@Override
	public Pharmacien getPharmacienById(String nom , String prenom) {
		Pharmacien p=new Pharmacien();
		
		try {			
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from pharmacien where nom=? and prenom=?;");
	         preparedStatement.setString(1, nom);
	         preparedStatement.setString(2, prenom);
			
			ResultSet res= preparedStatement.executeQuery();
			
			
			while(res.next()) {
				
				p.setCin(res.getString("cin"));
				p.setPassword(res.getString("password"));
				p.setNom(res.getString("nom"));
				p.setPrenom(res.getString("prenom"));
				p.setEmail(res.getString("email"));
				p.setTelephone(res.getString("telephone"));
				p.setSalaire(res.getDouble("salaire"));
				p.setAdresse(res.getString("adresse"));				
			}
			
			System.out.println(p);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return p;

	}

	@Override
	public boolean UpdatePharmacien(Pharmacien pharmacien, String cin) {
		
		final String sql="UPDATE pharmaciens SET cin=? , password=?, nom=?, prénom =? , email=? , telephone=? , salaire=? , adresse=? WHERE cin=? " ;
		 PreparedStatement preparedStatement;
		try {
			
		  preparedStatement = conn.prepareStatement(sql);
		
	      preparedStatement.setString(1,pharmacien.getCin());
	      preparedStatement.setString(2,pharmacien.getPassword());
	      preparedStatement.setString(3,pharmacien.getNom());
	      preparedStatement.setString(4,pharmacien.getPrenom());
	      preparedStatement.setString(5,pharmacien.getEmail());
	      preparedStatement.setString(6,pharmacien.getTelephone());
	      preparedStatement.setDouble(7,pharmacien.getSalaire());
	      preparedStatement.setString(8,pharmacien.getAdresse());
	      
	      preparedStatement.setString(9,cin);

          preparedStatement.executeUpdate();
          System.out.println("le pharmacien modifier: ");

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean DeletePharmacien(String cin) {
		try {
			 PreparedStatement preparedStatement;
			 preparedStatement = conn.prepareStatement("DELETE FROM pharmaciens where cin= ?");
			  preparedStatement.setString(1, cin);
				
			preparedStatement.executeUpdate();
			 
            System.out.println("le pharmacien suprimee: ");
            
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}