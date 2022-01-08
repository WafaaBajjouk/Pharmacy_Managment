package dao;

import java.util.List;

import models.Pharmacien;

public interface PharmacienDao {
	public void addPharmacien(Pharmacien pharmacien);
	public List<Pharmacien> getAllPharmaciens();
	public Pharmacien getPharmacienById(String nom , String prenom);
	public boolean UpdatePharmacien(Pharmacien pharmacien,String cin, String prenom);
	public boolean DeletePharmacien(String cin);

}
