package Interface_graphique;

import java.awt.EventQueue;


import java.sql.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import app.ConnexionSingleton;

import java.awt.*;
import java.awt.event.*;

public class Gérant implements ActionListener{
		
	    JTable tableP;	
	    JTable tableM = new JTable();
	    JTable tableF = new JTable();
	    JTable tableC = new JTable();
		Connection conn= ConnexionSingleton.getInstance();

		JFrame frame;
		private JPanel pharmPanel, medPanel, fournPanel, comdPanel;
		private JButton pharmaciens, médicaments, fournisseurs, commandes;
		private JButton ajouter, modifier, supprimer;
		private JButton modifier_1;
		
		//panel des pharmaciens
		private JLabel gerant;
		private JLabel gerantp;
		private JButton ajouterP;
		private JButton modifierP;
		private JLabel lcin, lpwd, lnomP, lprénomP, lemailP, ltelP, lsalaire, ladrP;
		private JTextField cin, pwd, nomP, prénomP, emailP, telP, salaire, adresseP;

		
		//panel des médicaments
		private JLabel lidM, lmrq, ldci, lpres, lcls, ldsg, lfrm, ltit, lppv, lpbr, lcomm, lqt;
		private JTextField idM, marque, dci, présentation, classe, dosage, forme, titulaire, ppv, pb_remb, st_comm, quantité;

		//panel des fournisseurs
		private JLabel lidF, lnomF, lprénomF, lemailF, ltelF, lsocieté, lidContrat, ltelS, lemailS, ladresseS;
		private JTextField idF, nomF, prénomF, emailF, telF, société, idContrat, telS, emailS, adresseS;
		
		//panel des commandes
		private JLabel lidC, lidCF, lidCM, lqtT, lppvT, ldate;
		private JTextField idC, idCF, idCM, qtT, ppvT;
		private JDateChooser date;

		
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Gérant window = new Gérant();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}


		public Gérant() {
			initialize();
		}

		
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 800, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.ORANGE);
			panel.setBounds(0, 0, 786, 463);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
		//	this.displayDataPharmacien();
			
			//les boutons de la zone gauche : 
			
			pharmaciens = new JButton("Pharmaciens");
			pharmaciens.setFont(new Font("Georgia", Font.PLAIN, 15));
			pharmaciens.setBounds(10, 62, 133, 21);
			panel.add(pharmaciens);
			pharmaciens.addActionListener(this);
			
			gerant = new JLabel();
			gerant.setBounds(0, 10, 64, 34);
			panel.add(gerant);
			
			gerantp = new JLabel();
			gerantp.setBounds(74, 10, 69, 34);
			panel.add(gerantp);
			
			
			médicaments = new JButton("Médicaments");
			médicaments.setFont(new Font("Georgia", Font.PLAIN, 15));
			médicaments.setBounds(10, 162, 133, 21);
			panel.add(médicaments);
			médicaments.addActionListener(this);
			
			fournisseurs = new JButton("Fournisseurs");
			fournisseurs.setFont(new Font("Georgia", Font.PLAIN, 15));
			fournisseurs.setBounds(10, 262, 133, 21);
			panel.add(fournisseurs);
			fournisseurs.addActionListener(this);
			
			commandes = new JButton("Commandes");
			commandes.setFont(new Font("Georgia", Font.PLAIN, 15));
			commandes.setBounds(10, 362, 133, 21);
			panel.add(commandes);
			commandes.addActionListener(this);
			
			
			//---------------------------------------------------------------------------- Panel des fournisseurs :
					
			
			fournPanel = new JPanel();
			fournPanel.setBounds(153, 0, 641, 463);
			panel.add(fournPanel);
			fournPanel.setLayout(null);
			fournPanel.setVisible(false);
			
			    //les étiquettes :
					
			lidF = new JLabel("Identifiant");
			lidF.setFont(new Font("Georgia", Font.PLAIN, 12));
			lidF.setBounds(10, 23, 89, 21);
			fournPanel.add(lidF);
			
			lnomF = new JLabel("Nom");
			lnomF.setFont(new Font("Georgia", Font.PLAIN, 12));
			lnomF.setBounds(10, 50, 89, 21);
			fournPanel.add(lnomF);
			
			lprénomF = new JLabel("Prénom");
			lprénomF.setFont(new Font("Georgia", Font.PLAIN, 12));
			lprénomF.setBounds(10, 79, 89, 21);
			fournPanel.add(lprénomF);
			
			lemailF = new JLabel("Email");
			lemailF.setFont(new Font("Georgia", Font.PLAIN, 12));
			lemailF.setBounds(10, 105, 89, 21);
			fournPanel.add(lemailF);
			
			ltelF = new JLabel("Téléphone");
			ltelF.setFont(new Font("Georgia", Font.PLAIN, 12));
			ltelF.setBounds(10, 132, 89, 21);
			fournPanel.add(ltelF);
			
			lsocieté = new JLabel("Société");
			lsocieté.setFont(new Font("Georgia", Font.PLAIN, 12));
			lsocieté.setBounds(10, 159, 89, 21);
			fournPanel.add(lsocieté);
			
			lidC = new JLabel("Id contrat");
			lidC.setFont(new Font("Georgia", Font.PLAIN, 12));
			lidC.setBounds(10, 186, 89, 21);
			fournPanel.add(lidC);
			
			ltelS = new JLabel("Tél société");
			ltelS.setFont(new Font("Georgia", Font.PLAIN, 12));
			ltelS.setBounds(10, 213, 89, 21);
			fournPanel.add(ltelS);
			
			lemailS = new JLabel("Email Société");
			lemailS.setFont(new Font("Georgia", Font.PLAIN, 12));
			lemailS.setBounds(10, 240, 89, 21);
			fournPanel.add(lemailS);
			
			ladresseS = new JLabel("Adr Société");
			ladresseS.setFont(new Font("Georgia", Font.PLAIN, 12));
			ladresseS.setBounds(10, 267, 89, 21);
			fournPanel.add(ladresseS);
			
			//les zones de saisies:
			
			idF = new JTextField();
			idF.setBounds(105, 23, 90, 21);
			fournPanel.add(idF);
			
			nomF = new JTextField();
			nomF.setBounds(105, 50, 90, 21);
			fournPanel.add(nomF);
			
			prénomF = new JTextField();
			prénomF.setBounds(105, 79, 90, 21);
			fournPanel.add(prénomF);
			
			emailF = new JTextField();
			emailF.setBounds(105, 105, 90, 21);
			fournPanel.add(emailF);
			
			telF = new JTextField();
			telF.setBounds(105, 132, 90, 21);
			fournPanel.add(telF);
			
			société = new JTextField();
			société.setBounds(105, 159, 90, 21);
			fournPanel.add(société);
			
			idContrat = new JTextField();
			idContrat.setBounds(105, 186, 90, 21);
			fournPanel.add(idContrat);
			
			telS = new JTextField();
			telS.setBounds(105, 213, 90, 21);
			fournPanel.add(telS);
			
			emailS = new JTextField();
			emailS.setBounds(105, 240, 90, 21);
			fournPanel.add(emailS);
			
			adresseS = new JTextField();
			adresseS.setBounds(105, 267, 90, 21);
			fournPanel.add(adresseS);
			
			//la table dynamique:
			
			tableF.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			tableF.setLocation(236, 23);
			tableF.setBackground(Color.WHITE);
			tableF.setSize(368, 260);
			tableF.setModel(new DefaultTableModel(
					new Object[][] {
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
					},
					new String[] {
							"New column", "New column", "MARQUE", "ID"
					}
			));
			tableF.getColumnModel().getColumn(0).setMinWidth(22);
			
			fournPanel.add(tableF);
			
			//les boutons d'action :
			
			ajouter = new JButton("Ajouter");
			ajouter.setFont(new Font("Georgia", Font.PLAIN, 14));
			ajouter.setBounds(246, 328, 85, 21);
			fournPanel.add(ajouter);
			
			modifier = new JButton("Modifier");
			modifier.setFont(new Font("Georgia", Font.PLAIN, 14));
			modifier.setBounds(365, 328, 100, 21);
			fournPanel.add(modifier);
			
			supprimer = new JButton("Supprimer");
			supprimer.setFont(new Font("Georgia", Font.PLAIN, 14));
			supprimer.setBounds(497, 328, 107, 21);
			fournPanel.add(supprimer);
			
			//---------------------------------------------------------------------------- Panel des pharmaciens :
			
			
			pharmPanel = new JPanel();
			pharmPanel.setBounds(153, 0, 633, 463);
			panel.add(pharmPanel);
			pharmPanel.setLayout(null);
			
		    //les étiquettes :
					
			lcin = new JLabel("CIN");
			lcin.setFont(new Font("Georgia", Font.PLAIN, 12));
			lcin.setBounds(10, 23, 89, 21);
			pharmPanel.add(lcin);
			
			lpwd = new JLabel("Mot de passe");
			lpwd.setFont(new Font("Georgia", Font.PLAIN, 12));
			lpwd.setBounds(10, 50, 89, 21);
			pharmPanel.add(lpwd);
			
			lnomP = new JLabel("Nom");
			lnomP.setFont(new Font("Georgia", Font.PLAIN, 12));
			lnomP.setBounds(10, 79, 89, 21);
			pharmPanel.add(lnomP);
			
			lprénomP = new JLabel("Prénom");
			lprénomP.setFont(new Font("Georgia", Font.PLAIN, 12));
			lprénomP.setBounds(10, 105, 89, 21);
			pharmPanel.add(lprénomP);
			
			lemailP = new JLabel("Email");
			lemailP.setFont(new Font("Georgia", Font.PLAIN, 12));
			lemailP.setBounds(10, 132, 89, 21);
			pharmPanel.add(lemailP);
			
			lsalaire = new JLabel("Salaire");
			lsalaire.setFont(new Font("Georgia", Font.PLAIN, 12));
			lsalaire.setBounds(10, 159, 89, 21);
			pharmPanel.add(lsalaire);
			
			ladrP = new JLabel("Adresse");
			ladrP.setFont(new Font("Georgia", Font.PLAIN, 12));
			ladrP.setBounds(10, 186, 89, 21);
			pharmPanel.add(ladrP);
			
			//les zones de saisies:
			
			cin = new JTextField();
			cin.setBounds(105, 23, 90, 21);
			pharmPanel.add(cin);
			
			pwd = new JTextField();
			pwd.setBounds(105, 50, 90, 21);
			pharmPanel.add(pwd);
			
			nomP = new JTextField();
			nomP.setBounds(105, 79, 90, 21);
			pharmPanel.add(nomP);
			
			prénomP = new JTextField();
			prénomP.setBounds(105, 105, 90, 21);
			pharmPanel.add(prénomP);
			
			emailP = new JTextField();
			emailP.setBounds(105, 132, 90, 21);
			pharmPanel.add(emailP);
			
			salaire = new JTextField();
			salaire.setBounds(105, 159, 90, 21);
			pharmPanel.add(salaire);
			
			adresseP = new JTextField();
			adresseP.setBounds(105, 186, 90, 21);
			pharmPanel.add(adresseP);
			
			//la table dynamique:
			tableP = this.displayDataPharmacien();
			pharmPanel.add(tableP);
			
	        new JScrollPane(tableP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        

	        //les boutons d'action :
	        
	        ajouterP = new JButton("Ajouter");
	        ajouterP.setFont(new Font("Georgia", Font.PLAIN, 14));
	        ajouterP.setBounds(246, 328, 85, 21);
	        ajouterP.addActionListener(this);
	        pharmPanel.add(ajouterP);
	        
	        modifierP = new JButton("Modifier");
	        modifierP.setFont(new Font("Georgia", Font.PLAIN, 14));
	        modifierP.setBounds(365, 328, 100, 21);
	        modifierP.addActionListener(this);
	        pharmPanel.add(modifierP);
	        
	        supprimer = new JButton("Supprimer");
	        supprimer.setFont(new Font("Georgia", Font.PLAIN, 14));
	        supprimer.setBounds(497, 328, 107, 21);
	        pharmPanel.add(supprimer);
			
				
				//---------------------------------------------------------------------------- Panel des médicaments :
										
				
				medPanel = new JPanel();
				medPanel.setBounds(153, 0, 641, 463);
				panel.add(medPanel);
				medPanel.setLayout(null);
				medPanel.setVisible(false);
				
				//les étiquettes :
				
				lidM = new JLabel("Identifiant");
				lidM.setFont(new Font("Georgia", Font.PLAIN, 12));
				lidM.setBounds(10, 11, 89, 18);
				medPanel.add(lidM);
				
				lmrq = new JLabel("Marque");
				lmrq.setFont(new Font("Georgia", Font.PLAIN, 12));
				lmrq.setBounds(10, 36, 89, 21);
				medPanel.add(lmrq);
				
				ldci = new JLabel("DCI");
				ldci.setFont(new Font("Georgia", Font.PLAIN, 12));
				ldci.setBounds(10, 63, 89, 21);
				medPanel.add(ldci);
				
				lpres = new JLabel("Présentation");
				lpres.setFont(new Font("Georgia", Font.PLAIN, 12));
				lpres.setBounds(10, 92, 89, 21);
				medPanel.add(lpres);
				
				lcls = new JLabel("Classe");
				lcls.setFont(new Font("Georgia", Font.PLAIN, 12));
				lcls.setBounds(10, 118, 89, 21);
				medPanel.add(lcls);
				
				ldsg = new JLabel("Dosage");
				ldsg.setFont(new Font("Georgia", Font.PLAIN, 12));
				ldsg.setBounds(10, 145, 89, 21);
				medPanel.add(ldsg);
				
				lfrm = new JLabel("Forme");
				lfrm.setFont(new Font("Georgia", Font.PLAIN, 12));
				lfrm.setBounds(10, 172, 89, 21);
				medPanel.add(lfrm);
				
				ltit = new JLabel("Titulaire");
				ltit.setFont(new Font("Georgia", Font.PLAIN, 12));
				ltit.setBounds(10, 199, 89, 21);
				medPanel.add(ltit);
				
				lppv = new JLabel("PPV");
				lppv.setFont(new Font("Georgia", Font.PLAIN, 12));
				lppv.setBounds(10, 226, 89, 21);
				medPanel.add(lppv);
				
				lpbr = new JLabel("PB_remb");
				lpbr.setFont(new Font("Georgia", Font.PLAIN, 12));
				lpbr.setBounds(10, 253, 89, 21);
				medPanel.add(lpbr);
				
				lcomm = new JLabel("ST_Comm");
				lcomm.setFont(new Font("Georgia", Font.PLAIN, 12));
				lcomm.setBounds(10, 280, 89, 21);
				medPanel.add(lcomm);
				
				lqt = new JLabel("Quantité");
				lqt.setFont(new Font("Georgia", Font.PLAIN, 12));
				lqt.setBounds(10, 311, 89, 21);
				medPanel.add(lqt);
				
				//les zones de saisies:
				
				idM = new JTextField();
				idM.setBounds(105, 10, 90, 21);
				medPanel.add(idM);
				idM.setColumns(10);
				
				marque = new JTextField();
				marque.setBounds(105, 36, 90, 21);
				medPanel.add(marque);
				
				dci = new JTextField();
				dci.setBounds(105, 63, 90, 21);
				medPanel.add(dci);
				
				présentation = new JTextField();
				présentation.setBounds(105, 92, 90, 21);
				medPanel.add(présentation);
				
				classe = new JTextField();
				classe.setBounds(105, 118, 90, 21);
				medPanel.add(classe);
				
				dosage = new JTextField();
				dosage.setBounds(105, 145, 90, 21);
				medPanel.add(dosage);
				
				forme = new JTextField();
				forme.setBounds(105, 172, 90, 21);
				medPanel.add(forme);
				
				titulaire = new JTextField();
				titulaire.setBounds(105, 199, 90, 21);
				medPanel.add(titulaire);
				
				ppv = new JTextField();
				ppv.setBounds(105, 226, 90, 21);
				medPanel.add(ppv);
				
				pb_remb = new JTextField();
				pb_remb.setBounds(105, 253, 90, 21);
				medPanel.add(pb_remb);
				
				st_comm = new JTextField();
				st_comm.setBounds(105, 280, 90, 21);
				medPanel.add(st_comm);
				
				quantité = new JTextField();
				quantité.setBounds(105, 307, 90, 21);
				medPanel.add(quantité);
				
				//la table dynamique:
				
				tableM.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				tableM.setLocation(236, 23);
				tableM.setBackground(Color.WHITE);
				tableM.setSize(368, 260);
				tableM.setModel(new DefaultTableModel(
					   new Object[][] {
								{null, null, null, null},
								{null, null, null, null},
								{null, null, null, null},
								{null, null, null, null},
								{null, null, null, null},
								{null, null, null, null},
								{null, null, null, null},
								{null, null, null, null},
						},
						new String[] {
								"New column", "New column", "MARQUE", "ID"
						}
				));
				tableM.getColumnModel().getColumn(0).setMinWidth(22);
				
				medPanel.add(tableM);
				
				//les boutons d'action :
				
				ajouter = new JButton("Ajouter");
				ajouter.setFont(new Font("Georgia", Font.PLAIN, 14));
				ajouter.setBounds(246, 328, 85, 21);
				medPanel.add(ajouter);
				
				modifier = new JButton("Modifier");
				modifier.setFont(new Font("Georgia", Font.PLAIN, 14));
				modifier.setBounds(365, 328, 100, 21);
				medPanel.add(modifier);
				
				supprimer = new JButton("Supprimer");
				supprimer.setFont(new Font("Georgia", Font.PLAIN, 14));
				supprimer.setBounds(497, 328, 107, 21);
				medPanel.add(supprimer);
				
				//---------------------------------------------------------------------------- Panel des commandes :
				
				comdPanel = new JPanel();
				comdPanel.setBounds(153, 0, 641, 463);
				panel.add(comdPanel);
				comdPanel.setLayout(null);
				comdPanel.setVisible(false);
				
				//les étiquettes :
							
					lidC = new JLabel("Id Commande");
					lidC.setFont(new Font("Georgia", Font.PLAIN, 12));
					lidC.setBounds(10, 23, 105, 21);
					comdPanel.add(lidC);
					
					lidCF = new JLabel("Id Fournisseur");
					lidCF.setFont(new Font("Georgia", Font.PLAIN, 12));
					lidCF.setBounds(10, 50, 105, 21);
					comdPanel.add(lidCF);
					
					lidCM = new JLabel("Id Médicament");
					lidCM.setFont(new Font("Georgia", Font.PLAIN, 12));
					lidCM.setBounds(10, 79, 105, 21);
					comdPanel.add(lidCM);
					
					lqtT = new JLabel("Quantité Total");
					lqtT.setFont(new Font("Georgia", Font.PLAIN, 12));
					lqtT.setBounds(10, 105, 105, 21);
					comdPanel.add(lqtT);
					
					lppvT = new JLabel("Prix Total");
					lppvT.setFont(new Font("Georgia", Font.PLAIN, 12));
					lppvT.setBounds(10, 132, 105, 21);
					comdPanel.add(lppvT);
					
					ldate = new JLabel("Date Commande");
					ldate.setFont(new Font("Georgia", Font.PLAIN, 12));
					ldate.setBounds(10, 159, 105, 21);
					comdPanel.add(ldate);
					
					//les zones de saisies:
									
					idC = new JTextField();
					idC.setBounds(125, 23, 101, 21);
					comdPanel.add(idC);
					
					idCF = new JTextField();
					idCF.setBounds(125, 50, 101, 21);
					comdPanel.add(idCF);
					
					idCM = new JTextField();
					idCM.setBounds(125, 79, 101, 21);
					comdPanel.add(idCM);
					
					qtT = new JTextField();
					qtT.setBounds(125, 105, 101, 21);
					comdPanel.add(qtT);
					
					ppvT = new JTextField();
					ppvT.setBounds(125, 132, 101, 21);
					comdPanel.add(ppvT);
					
					date = new JDateChooser();
					date.setBounds(125, 159, 101, 21);
					comdPanel.add(date);
					
					//la table dynamique:
					
					tableC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					tableC.setLocation(236, 23);
					tableC.setBackground(Color.WHITE);
					tableC.setSize(368, 260);
					tableC.setModel(new DefaultTableModel(
						new Object[][] {
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
							{null, null, null, null},
						},
						new String[] {
							"New column", "New column", "MARQUE", "ID"
							}
					));
					tableC.getColumnModel().getColumn(0).setMinWidth(22);
					
					comdPanel.add(tableC);
					
					//les boutons d'action :
					
					ajouter = new JButton("Ajouter");
					ajouter.setFont(new Font("Georgia", Font.PLAIN, 14));
					ajouter.setBounds(246, 328, 85, 21);
					comdPanel.add(ajouter);
					
					modifier_1 = new JButton("Modifier");
					modifier_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					modifier_1.setFont(new Font("Georgia", Font.PLAIN, 14));
					modifier_1.setBounds(365, 328, 100, 21);
					comdPanel.add(modifier_1);
					
					supprimer = new JButton("Supprimer");
					supprimer.setFont(new Font("Georgia", Font.PLAIN, 14));
					supprimer.setBounds(497, 328, 107, 21);
					comdPanel.add(supprimer);
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == pharmaciens) {
				fournPanel.setVisible(false);
				comdPanel.setVisible(false);
				medPanel.setVisible(false);
				pharmPanel.setVisible(true);
			}
			if(e.getSource() == médicaments) {
				fournPanel.setVisible(false);
				comdPanel.setVisible(false);
				pharmPanel.setVisible(false);
				medPanel.setVisible(true);
			}
			if(e.getSource() == fournisseurs) {
				comdPanel.setVisible(false);
				medPanel.setVisible(false);
				pharmPanel.setVisible(false);
				fournPanel.setVisible(true);
			}
			if(e.getSource() == commandes) {
				medPanel.setVisible(false);
				fournPanel.setVisible(false);
				pharmPanel.setVisible(false);
				comdPanel.setVisible(true);
			}
			if(e.getSource() == ajouterP) {
				//.out.print("Here");
				this.addPharmacien();
			}
			if(e.getSource() == modifierP) {
				//System.out.print("Here");
			//	this.UpdatePharmacien();
			}
		}
		
		public JTable displayDataPharmacien() {
			
			DefaultTableModel model = new DefaultTableModel();
			
			JTable table = new JTable(model);
			table.setLocation(236, 23);
			table.setBackground(Color.WHITE);
			table.setSize(368, 260);
			
			 String query = "SELECT * FROM Pharmaciens";
			    
		      Statement stm;
		    
				String id,nom,prénom,email,tel,salaire,adresse;
				
				    model.addColumn("CIN");
			        model.addColumn("Nom");
			        model.addColumn("prénom");
			        model.addColumn("Email");
			        model.addColumn("telephone");
			        model.addColumn("salaire");
			        model.addColumn("Adresse");
			        
			   try {
				stm = conn.createStatement();
			    ResultSet res = stm.executeQuery(query);
			    while (res.next()) {
			        id = res.getString("CIN");
			        System.out.println(id);
			        nom = res.getString("Nom");
			        prénom = res.getString("Prénom");
			        email = res.getString("Email");
			        tel = res.getString("telephone");
			        salaire = res.getString("salaire");
			        adresse = res.getString("adresse");
                    model.addRow(new Object[]{id, nom , prénom, email , tel , salaire, adresse});
			   }

			} catch (SQLException e) {
				e.printStackTrace();
			}
	        return table;
		}

		public void gerant(String cin) {
			try {
				String sql= "SELECT NOM , PReNOM FROM gérants Where cin=?";
	            PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1,cin);
	            ResultSet res=pst.executeQuery();
	            if (res.next())  {
	            	System.out.println(res.getString(1));
	            	gerant.setText(res.getString(1));
	            	gerantp.setText(res.getString(2));

	            }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
		
		public void addPharmacien() {
			daoImp.PharmacienDaoImp pi= new daoImp.PharmacienDaoImp();
			
			models.Pharmacien p= new models.Pharmacien();
			p.setCin(cin.getText());
			p.setPassword(pwd.getText());
			p.setNom(nomP.getText());
			p.setPrenom(prénomP.getText());
			p.setEmail(emailP.getText());	
			p.setSalaire(Double.parseDouble(salaire.getText()));
			p.setAdresse(adresseP.getText());
			
			System.out.print(p);
			pi.addPharmacien(p);
		}
		
	/*	public void UpdatePharmacien() {
			Implementation.PharmacienImp pi= new Implementation.PharmacienImp();
			
			models.Pharmacien p= new models.Pharmacien();
			p.setCin(cin.getText());
			p.setPassword(pwd.getText());
			p.setNom(nomP.getText());
			p.setPrenom(prénomP.getText());
			p.setEmail(emailP.getText());	
			p.setSalaire(Double.parseDouble(salaire.getText()));
			p.setAdresse(adresseP.getText());
			
			System.out.print(p);
			pi.UpdatePharmacien(p,nomP.getText() ,prénomP.getText() );
		}
		
		public void DeletePharmacien() {
			Implementation.PharmacienImp pi= new Implementation.PharmacienImp();
			pi.DeletePharmacien(cin.getText());
		}
		*/
}


