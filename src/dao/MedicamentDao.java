package dao;

import java.util.List;


import models.Medicament;

public interface MedicamentDao {

	public void addCommande(Medicament medicament);
	public List<Medicament> getAllMedicaments();
	public Medicament getMedicamentById(int id);
	public boolean UpdateMedicament(Medicament medicament, int id);
	public boolean DeleteMedicament(int id);
}
