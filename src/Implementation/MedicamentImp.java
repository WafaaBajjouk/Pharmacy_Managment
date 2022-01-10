package Implementation;

import java.sql.*;
import java.util.Vector;

import DAO.MedicamentDAO;
import app.ConnexionSingleton;
import models.Medicament;

public class MedicamentImp implements MedicamentDAO{
	
	Connection conn = ConnexionSingleton.getInstance();

	@Override
	public void addMedicament(Medicament medicament) {
		try {
			
			PreparedStatement stm= conn.prepareStatement("INSERT INTO Médicaments VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
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
			System.out.println("Médicament bien ajouté !!! ");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Vector<Vector<String>> getAllMedicaments() {
		
		Vector<Vector<String>> rows = new Vector<Vector<String>>();

		try {		
			Statement stm= conn.createStatement();	
			ResultSet res= stm.executeQuery("SELECT * FROM Médicaments");
			
			while(res.next()) {
				Vector<String> row = new Vector<String>();
				
				row.addElement(String.valueOf(res.getInt("id")));
				row.addElement(res.getString("marque"));
				row.addElement(res.getString("dci"));
				row.addElement(res.getString("Presentation"));
				row.addElement(res.getString("classe"));
				row.addElement(res.getString("dosage"));
				row.addElement(res.getString("forme"));
				row.addElement(res.getString("titulaire"));
				row.addElement(String.valueOf(res.getDouble("ppv")));
				row.addElement(String.valueOf(res.getDouble("PBase_Remb")));
				row.addElement(res.getString("st_comm"));
				row.addElement(String.valueOf(res.getInt("quantite")));
				
				rows.addElement(row);
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		return rows;
		
	}

	@Override
	public Medicament getMedicamentById(int id) {
		
		Medicament m=new Medicament();
		try {
						
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Médicaments WHERE id=?");
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
		
		final String sql = "UPDATE Médicaments SET marque=? ,dci=? , Presentation=? , classe=?, dosage=?, forme=?, titulaire=? , ppv=? , PBase_Remb=?, st_comm=? , quantite=? WHERE id=? " ;
		PreparedStatement preparedStatement;
		
		try {
			
		  preparedStatement = conn.prepareStatement(sql);
		
	      preparedStatement.setString(1,medicament.getMarque());
	      preparedStatement.setString(2,medicament.getDci());
	      preparedStatement.setString(3,medicament.getPrestentation());
	      preparedStatement.setString(4,medicament.getCla());
	      preparedStatement.setString(5,medicament.getDosage());
	      preparedStatement.setString(6,medicament.getForme());
	      preparedStatement.setString(7,medicament.getTitulaire());
	      preparedStatement.setDouble(8,medicament.getPpv());
	      preparedStatement.setDouble(9,medicament.getPbase_remp());
	      preparedStatement.setString(10,medicament.getSt_comm());
	      preparedStatement.setInt(11,medicament.getQuantite());

	      preparedStatement.setInt(12,id);

          preparedStatement.executeUpdate();
          System.out.println("Le médicament est modifié !!! ");
  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean DeleteMedicament(int id) {
		
		try {
			
			 PreparedStatement preparedStatement;
			 preparedStatement = conn.prepareStatement("DELETE FROM Médicaments WHERE id= ?");
			 preparedStatement.setInt(1, id);
				
			 preparedStatement.executeUpdate();
			 
             System.out.println("Le médicament est supprimé !!! ");
            
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}