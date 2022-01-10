package DAO;




import models.Medicament;

import java.util.Vector;


public interface MedicamentDAO {
	public void addMedicament(Medicament medicament);
	public Vector<Vector<String>> getAllMedicaments();
	public Medicament getMedicamentById(int id);
	public boolean UpdateMedicament(Medicament medicament, int id);
	public boolean DeleteMedicament(int id);
}