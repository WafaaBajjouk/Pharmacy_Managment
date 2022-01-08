package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.ConnexionSingleton;
import dao.MedicamentDao;
import models.Medicament;

public class MedicamentDaoImp implements MedicamentDao{
	Connection conn=ConnexionSingleton.getInstance();


	@Override
	public void addCommande(Medicament medicament) {
		try {
			
			
			PreparedStatement stm= conn.prepareStatement("insert into Médicaments values (?,?,?,?,?,?,?,?,?,?,?,?);");
			stm.setInt(1, medicament.getId_medicament());
			stm.setString(2, medicament.getMarque());
			stm.setString(3, medicament.getDci());
			stm.setString(4, medicament.getPrestentation());
			stm.setString(5, medicament.getCla());
			stm.setString(6, medicament.getDosage());
			stm.setString(7, medicament.getForme());
			stm.setString(8, medicament.getTitulaire());
			stm.setDouble(9, medicament.getPpv());
			stm.setDouble(10, medicament.getPbase_remp());
			stm.setString(11, medicament.getSt_comm());
			stm.setInt(12, medicament.getQuantite());

			stm.executeUpdate();
			System.out.println("Medicament bien ajoute!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Medicament> getAllMedicaments() {
     List<Medicament> medicaments = new ArrayList<Medicament>();
		
		
		try {
		
		Statement stm= conn.createStatement();
		
		
		ResultSet res= stm.executeQuery("Select * from Médicaments;");
		
		while(res.next()) {
			Medicament m=new Medicament();
			
			m.setId_medicament(res.getInt("id"));
			m.setMarque(res.getString("marque"));
			m.setDci(res.getString("dci"));
			m.setPrestentation(res.getString("Presentation"));
			m.setCla(res.getString("classe"));
			m.setDosage(res.getString("dosage"));
			m.setForme(res.getString("forme"));
			m.setTitulaire(res.getString("titulaire"));
			m.setPpv(res.getDouble("ppv"));
			m.setPbase_remp(res.getDouble("PBase_Remb"));
			m.setSt_comm(res.getString("st_comm"));
			m.setQuantite(res.getInt("quantite"));
			
			medicaments.add(m);

		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.print("Affichage");
		for(int i=0; i<medicaments.size() ; i++) {
		      System.out.println(medicaments.get(i));
		}

				return medicaments;
	}

	@Override
	public Medicament getMedicamentById(int id) {
		Medicament m=new Medicament();
		try {
						
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from Médicaments where id=?;");
	         preparedStatement.setInt(1, id);
			
			ResultSet res= preparedStatement.executeQuery();
			
			
			while(res.next()) {				
				m.setId_medicament(res.getInt("id"));
				m.setMarque(res.getString("marque"));
				m.setDci(res.getString("dci"));
				m.setPrestentation(res.getString("Presentation"));
				m.setCla(res.getString("classe"));
				m.setDosage(res.getString("dosage"));
				m.setForme(res.getString("forme"));
				m.setTitulaire(res.getString("titulaire"));
				m.setPpv(res.getDouble("ppv"));
				m.setPbase_remp(res.getDouble("PBase_Remb"));
				m.setSt_comm(res.getString("st_comm"));
				m.setQuantite(res.getInt("quantite"));
				
			}
			
			System.out.println(m);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return m;
	}

	@Override
	public boolean UpdateMedicament(Medicament medicament ,int id) {
		final String sql="UPDATE Médicaments SET id=? , marque=? ,dci=? , Presentation=? , classe=?, dosage=?, forme=?, titulaire=? , ppv=? , PBase_Remb=?, st_comm=? , quantite=? WHERE id=? " ;
		 PreparedStatement preparedStatement;
		try {
			
		  preparedStatement = conn.prepareStatement(sql);
		
	      preparedStatement.setInt(1,medicament.getId_medicament());
	      preparedStatement.setString(2,medicament.getMarque());
	      preparedStatement.setString(3,medicament.getDci());
	      preparedStatement.setString(4,medicament.getPrestentation());
	      preparedStatement.setString(5,medicament.getCla());
	      preparedStatement.setString(6,medicament.getDosage());
	      preparedStatement.setString(7,medicament.getForme());
	      preparedStatement.setString(8,medicament.getTitulaire());
	      preparedStatement.setDouble(9,medicament.getPpv());
	      preparedStatement.setDouble(10,medicament.getPbase_remp());
	      preparedStatement.setString(11,medicament.getSt_comm());
	      preparedStatement.setInt(12,medicament.getQuantite());

	      preparedStatement.setInt(13,id);

         preparedStatement.executeUpdate();
         System.out.println("le medicament est modifier: ");


	      
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean DeleteMedicament(int id) {
		Statement statement;
		try {
			 PreparedStatement preparedStatement;
			 preparedStatement = conn.prepareStatement("DELETE FROM Médicaments where id= ?");
			  preparedStatement.setInt(1, id);
				
			preparedStatement.executeUpdate();
			 
            System.out.println("le medicament est suprimee: ");
            
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
