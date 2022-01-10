package DAO;

import java.util.List;
import java.util.Vector;

import models.Pharmacien;

public interface PharmacienDAO {
	public void addPharmacien(Pharmacien pharmacien);
	public Vector<Vector<String>> getAllPharmaciens();
	public Pharmacien getPharmacienById(String nom , String prenom);
	public boolean UpdatePharmacien(Pharmacien pharmacien, String cin);
	public boolean DeletePharmacien(String cin);

}
