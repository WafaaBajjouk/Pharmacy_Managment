package daoImp;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import app.ConnexionSingleton;
import models.Pharmacien;

public class PharmacienDaoImp implements dao.PharmacienDao{
	
	Connection conn=ConnexionSingleton.getInstance();


	public void addPharmacien(Pharmacien pharmacien) {
		try {
			
		
		PreparedStatement stm= conn.prepareStatement("insert into Pharmacien values (?,?,?,?,?,?,?,?);");
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
	}}



	@Override
	public List<Pharmacien> getAllPharmaciens() {
		
		List<Pharmacien> pharmaciens = new ArrayList<Pharmacien>();
		
		
		try {
		
		Statement stm= conn.createStatement();
		
		
		ResultSet res= stm.executeQuery("Select * from Pharmacien;");
		
		while(res.next()) {
			Pharmacien p=new Pharmacien();
			
			p.setCin(res.getString("cin"));
			p.setPassword(res.getString("password"));
			p.setNom(res.getString("nom"));
			p.setPrenom(res.getString("prenom"));
			p.setEmail(res.getString("email"));
			p.setTelephone(res.getString("telephone"));
			p.setSalaire(res.getDouble("salaire"));
			p.setAdresse(res.getString("adresse"));
			
			pharmaciens.add(p);

		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.print("Affichage");
		for(int i=0; i<pharmaciens.size() ; i++) {
		      System.out.println(pharmaciens.get(i));
		}

				return pharmaciens;

	}

	@Override
	public Pharmacien getPharmacienById(String nom , String prenom) {
		Pharmacien p=new Pharmacien();
		try {
			
//			PreparedStatement stm= conn.prepareStatement("Select * from pharmacien where cin="+Cin+";");
			
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from pharmacien where nom=? and prenom=?;");
	         preparedStatement.setString(1, nom);
	         preparedStatement.setString(2, prenom);
			
			ResultSet res= preparedStatement.executeQuery();
			
			
			while(res.next()) {
//				p=new Pharmacien();
				
				p.setCin(res.getString("cin"));
				p.setPassword(res.getString("password"));
				p.setNom(res.getString("nom"));
				p.setPrenom(res.getString("prenom"));
				p.setEmail(res.getString("email"));
				p.setTelephone(res.getString("telephone"));
				p.setSalaire(res.getDouble("salaire"));
				p.setAdresse(res.getString("adresse"));
//				
//				String c=res.getString("cin");
//				String ps=res.getString("password");
//				String n=res.getString("nom");
//				String pr=res.getString("prenom");
//				String e=res.getString("email");
//				String t=res.getString("telephone");
//				Double s=res.getDouble("salaire");
//				String a=res.getString("adresse");
				
//				p=new Pharmacien(c,ps,n,pr,e,t,s,a);
				
				
			}
			
			System.out.println(p);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return p;

	}

	@Override
	public boolean UpdatePharmacien(Pharmacien pharmacien, String nom, String prenom) {
		
		final String sql="UPDATE pharmacien SET cin=? , password=?, nom=?, prenom =? , email=? , telephone=? , salaire=? , adresse=? WHERE nom=? and prenom=? " ;
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
	      
	      preparedStatement.setString(9,nom);
	      preparedStatement.setString(10,prenom);

          preparedStatement.executeUpdate();
          System.out.println("le pharmacien modifier: ");


	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean DeletePharmacien(String cin) {
		
		Statement statement;
		try {
			 PreparedStatement preparedStatement;
			 preparedStatement = conn.prepareStatement("DELETE FROM pharmacien where cin= ?");
			  preparedStatement.setString(1, cin);
				
			preparedStatement.executeUpdate();
			 
            System.out.println("le pharmacien suprimee: ");
            
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	






}
