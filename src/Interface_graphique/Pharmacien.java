package Interface_graphique;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import app.ConnexionSingleton;
import Interface_graphique.MouseAdapter;
import Socket.MainServer;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Pharmacien implements ActionListener{
	
	//Les tables :	
	private JTable tableM ;
	private JTable tableF ;
	private JTable tableC ;
	    
	//l'entete des tables:
	Vector<String> column_headingF = new Vector<String>();
	Vector<String> column_headingM = new Vector<String>();
	Vector<String> column_headingC = new Vector<String>();
	    
	//Model:
	DefaultTableModel modelF = null;
	DefaultTableModel modelM = null;
	DefaultTableModel modelC = null;

	//Connection:
	Connection conn= ConnexionSingleton.getInstance();
	
	//les implémentations DAO:
	Implementation.FournisseurImp fi= new Implementation.FournisseurImp();
	Implementation.MedicamentImp mi= new Implementation.MedicamentImp();
	Implementation.CommandeImp ci= new Implementation.CommandeImp();
	
	//Frame:
	JFrame frame;
	
	//les éléments essentiels de l'interface:
	private JPanel medPanel, fournPanel, comdPanel;
	
	//les boutons de la zone gauche:
	private JButton médicaments, fournisseurs, commandes;     

	
	//panel des médicaments
	private JButton ajouterM,modifierM,supprimerM;
	private JLabel lidM, lmrq, ldci, lpres, lcls, ldsg, lfrm, ltit, lppv, lpbr, lcomm, lqt;
	private JTextField idM, marque, dci, présentation, classe, dosage, forme, titulaire, ppv, pb_remb, st_comm, quantité;

	//panel des fournisseurs
	private JButton ajouterF,modifierF,supprimerF;
	private JLabel lidF, lnomF, lprénomF, lemailF, ltelF, lsocieté, lidContrat, ltelS, lemailS, ladresseS;
	private JTextField idF, nomF, prénomF, emailF, telF, société, idContrat, telS, emailS, adresseS;
	
	//panel des commandes
	private JButton ajouterC,modifierC,supprimerC;
	private JLabel lidC, lidCF, lidCM, lqtT, lppvT, ldate;
	private JTextField idC, idCF, idCM, qtT, ppvT;
	private JDateChooser date;
	
	//panel des pharmaciens
	private JLabel user;
	private JLabel userp;
	
	JButton chater = new JButton("Messenger");


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pharmacien window = new Pharmacien();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Pharmacien() {
		initialize();
	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(31,166,197));
		panel.setBounds(0, 0, 786, 463);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//les boutons de la zone gauche : 
		
		médicaments = new JButton("Médicaments");
		médicaments.setFont(new Font("Georgia", Font.PLAIN, 15));
		médicaments.setBounds(10, 80, 133, 21);
		panel.add(médicaments);
		médicaments.addActionListener(this);
		
		fournisseurs = new JButton("Fournisseurs");
		fournisseurs.setFont(new Font("Georgia", Font.PLAIN, 15));
		fournisseurs.setBounds(10, 226, 133, 21);
		panel.add(fournisseurs);
		fournisseurs.addActionListener(this);
		
		commandes = new JButton("Commandes");
		commandes.setFont(new Font("Georgia", Font.PLAIN, 15));
		commandes.setBounds(10, 353, 133, 21);
		panel.add(commandes);
		commandes.addActionListener(this);
		
		user = new JLabel();
		user.setBounds(0, 10, 64, 34);
		panel.add(user);
		
		userp = new JLabel();
		userp.setBounds(74, 10, 69, 34);
		panel.add(userp);
		
		
							
							
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
			
			lidContrat = new JLabel("Id contrat");
			lidContrat.setFont(new Font("Georgia", Font.PLAIN, 12));
			lidContrat.setBounds(10, 186, 89, 21);
			fournPanel.add(lidContrat);
			
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
			idF.setBounds(105, 23, 121, 21);
			fournPanel.add(idF);
			
			nomF = new JTextField();
			nomF.setBounds(105, 50, 121, 21);
			fournPanel.add(nomF);
			
			prénomF = new JTextField();
			prénomF.setBounds(105, 79, 121, 21);
			fournPanel.add(prénomF);
			
			emailF = new JTextField();
			emailF.setBounds(105, 105, 121, 21);
			fournPanel.add(emailF);
			
			telF = new JTextField();
			telF.setBounds(105, 132, 121, 21);
			fournPanel.add(telF);
			
			société = new JTextField();
			société.setBounds(105, 159, 121, 21);
			fournPanel.add(société);
			
			idContrat = new JTextField();
			idContrat.setBounds(105, 186, 121, 21);
			fournPanel.add(idContrat);
			
			telS = new JTextField();
			telS.setBounds(105, 213, 121, 21);
			fournPanel.add(telS);
			
			emailS = new JTextField();
			emailS.setBounds(105, 240, 121, 21);
			fournPanel.add(emailS);
			
			adresseS = new JTextField();
			adresseS.setBounds(105, 267, 121, 21);
			fournPanel.add(adresseS);
			
			//la table dynamique:
			tableF = new JTable();
		    tableF.setBounds(236, 23, 368, 260);
			tableF.setLocation(236, 23);
			tableF.setBackground(Color.WHITE);
			tableF.setSize(368, 260);
			tableF.setModel(this.displayDataFournisseur());
			tableF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			tableF.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
						
					int row = tableF.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tableF.getModel();
						
					idF.setText(model.getValueAt(row,0).toString());
					nomF.setText(model.getValueAt(row,1).toString());
					prénomF.setText(model.getValueAt(row,2).toString());
					emailF.setText(model.getValueAt(row,3).toString());
					telF.setText(model.getValueAt(row,4).toString());
					société.setText(model.getValueAt(row,5).toString());
					idContrat.setText(model.getValueAt(row,6).toString());
					telS.setText(model.getValueAt(row,7).toString());
					emailS.setText(model.getValueAt(row,8).toString());
					adresseS.setText(model.getValueAt(row,9).toString());	
				}
			});
			
			//Permettre le scroll à la table:
			JScrollPane scrollF = new JScrollPane(tableF, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollF.setBounds(236, 23, 368, 260);
			scrollF.setLocation(236, 23);
			scrollF.setVisible(true);
		     
		    fournPanel.add(scrollF);

			
			//les boutons d'action :
			
			ajouterF = new JButton("Ajouter");
			ajouterF.setFont(new Font("Georgia", Font.PLAIN, 14));
			ajouterF.setBounds(246, 328, 85, 21);
			ajouterF.addActionListener(this);
			fournPanel.add(ajouterF);
			
			modifierF = new JButton("Modifier");
			modifierF.setFont(new Font("Georgia", Font.PLAIN, 14));
			modifierF.setBounds(365, 328, 100, 21);
			modifierF.addActionListener(this);
			fournPanel.add(modifierF);
			
			supprimerF = new JButton("Supprimer");
			supprimerF.setFont(new Font("Georgia", Font.PLAIN, 14));
			supprimerF.setBounds(497, 328, 107, 21);
			supprimerF.addActionListener(this);
			fournPanel.add(supprimerF);
			
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
			idM.setBounds(105, 10, 121, 21);
			medPanel.add(idM);
			idM.setColumns(10);
				
			marque = new JTextField();
			marque.setBounds(105, 36, 121, 21);
			medPanel.add(marque);
				
			dci = new JTextField();
			dci.setBounds(105, 63, 121, 21);
			medPanel.add(dci);
				
			présentation = new JTextField();
			présentation.setBounds(105, 92, 121, 21);
			medPanel.add(présentation);
				
			classe = new JTextField();
			classe.setBounds(105, 118, 121, 21);
			medPanel.add(classe);
				
			dosage = new JTextField();
			dosage.setBounds(105, 145, 121, 21);
			medPanel.add(dosage);
				
			forme = new JTextField();
			forme.setBounds(105, 172, 121, 21);
			medPanel.add(forme);
				
			titulaire = new JTextField();
			titulaire.setBounds(105, 199, 121, 21);
			medPanel.add(titulaire);
				
			ppv = new JTextField();
			ppv.setBounds(105, 226, 121, 21);
			medPanel.add(ppv);
				
			pb_remb = new JTextField();
			pb_remb.setBounds(105, 253, 121, 21);
			medPanel.add(pb_remb);
				
			st_comm = new JTextField();
			st_comm.setBounds(105, 280, 121, 21);
			medPanel.add(st_comm);
				
			quantité = new JTextField();
			quantité.setBounds(105, 307, 121, 21);
			medPanel.add(quantité);
				
			//la table dynamique:
		    tableM = new JTable();
			tableM.setBounds(236, 23, 368, 260);
			tableM.setLocation(236, 23);
			tableM.setBackground(Color.WHITE);
			tableM.setSize(368, 260);
			tableM.setModel(this.displayDataMedicament());
			tableM.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
			tableM.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
								
					int row = tableM.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tableM.getModel();
								
					idM.setText(model.getValueAt(row,0).toString());
					marque.setText(model.getValueAt(row,1).toString());
					dci.setText(model.getValueAt(row,2).toString());
					présentation.setText(model.getValueAt(row,3).toString());
					classe.setText(model.getValueAt(row,4).toString());
					dosage.setText(model.getValueAt(row,5).toString());
					forme.setText(model.getValueAt(row,6).toString());
					titulaire.setText(model.getValueAt(row,7).toString());	
					ppv.setText(model.getValueAt(row,8).toString());
					pb_remb.setText(model.getValueAt(row,9).toString());
					st_comm.setText(model.getValueAt(row,10).toString());
					quantité.setText(model.getValueAt(row,11).toString());
				}
			});
				
			//Permettre le scroll à la table:
			JScrollPane scrollM = new JScrollPane(tableM, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollM.setBounds(236, 23, 368, 260);
			scrollM.setLocation(236, 23);
			scrollM.setVisible(true);
			     
			medPanel.add(scrollM);
				
			//les boutons d'action :
			
//			chater.setForeground(Color.WHITE);
			chater.setBackground(new Color(14,78,104));
			chater.setFont(new Font("Georgia", Font.PLAIN, 14));
			chater.setBounds(21, 420, 107, 21);
			panel.add(chater);
			chater.addActionListener(this);
				
			ajouterM = new JButton("Ajouter");
			ajouterM.setFont(new Font("Georgia", Font.PLAIN, 14));
			ajouterM.setBounds(246, 328, 85, 21);
			ajouterM.addActionListener(this);
			medPanel.add(ajouterM);
				
			modifierM = new JButton("Modifier");
			modifierM.setFont(new Font("Georgia", Font.PLAIN, 14));
			modifierM.setBounds(365, 328, 100, 21);
			modifierM.addActionListener(this);
			medPanel.add(modifierM);
				
			supprimerM = new JButton("Supprimer");
			supprimerM.setFont(new Font("Georgia", Font.PLAIN, 14));
			supprimerM.setBounds(497, 328, 107, 21);
			supprimerM.addActionListener(this);
			medPanel.add(supprimerM);
				
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
			tableC = new JTable();
		    tableC.setBounds(236, 23, 368, 260);
			tableC.setLocation(236, 23);
			tableC.setBackground(Color.WHITE);
			tableC.setSize(368, 260);
			tableC.setModel(this.displayDataCommande());
			tableC.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			tableC.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
						
					int row = tableC.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tableC.getModel();
						
					idC.setText(model.getValueAt(row,0).toString());
					idCF.setText(model.getValueAt(row,1).toString());
					idCM.setText(model.getValueAt(row,2).toString());
					qtT.setText(model.getValueAt(row,3).toString());
					ppvT.setText(model.getValueAt(row,4).toString());
					
					String strDate = model.getValueAt(row, 5).toString();
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			        Date dat;
					try {
						dat = sdf.parse(strDate);
						date.setDate(dat);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			//Permettre le scroll à la table:
			JScrollPane scrollC = new JScrollPane(tableC, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollC.setBounds(236, 23, 368, 260);
			scrollC.setLocation(236, 23);
			scrollC.setVisible(true);
		     
		    comdPanel.add(scrollC);

			//les boutons d'action :
					
			ajouterC = new JButton("Ajouter");
			ajouterC.setFont(new Font("Georgia", Font.PLAIN, 14));
			ajouterC.setBounds(246, 328, 85, 21);
			ajouterC.addActionListener(this);
			comdPanel.add(ajouterC);
					
			modifierC = new JButton("Modifier");
			modifierC.setFont(new Font("Georgia", Font.PLAIN, 14));
			modifierC.setBounds(365, 328, 100, 21);
			modifierC.addActionListener(this);
			comdPanel.add(modifierC);
					
			supprimerC = new JButton("Supprimer");
			supprimerC.setFont(new Font("Georgia", Font.PLAIN, 14));
			supprimerC.setBounds(497, 328, 107, 21);
			supprimerC.addActionListener(this);
			comdPanel.add(supprimerC);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == médicaments) {
				fournPanel.setVisible(false);
				comdPanel.setVisible(false);
				medPanel.setVisible(true);	
			}
			if(e.getSource() == fournisseurs) {
				comdPanel.setVisible(false);
				medPanel.setVisible(false);
				fournPanel.setVisible(true);
			}
			if(e.getSource() == commandes) {
				medPanel.setVisible(false);
				fournPanel.setVisible(false);
				comdPanel.setVisible(true);
			}
			//les opérations de médicament:
			if(e.getSource() == ajouterM) {
				this.addMedicament();
				this.displayDataMedicament();
			}
			if(e.getSource() == modifierM) {
				this.UpdateMedicament();
				this.tableM.setModel(this.displayDataMedicament());
			}
			if(e.getSource() == supprimerM) {
				System.out.print("Here");
				this.DeleteMedicament();			
			}
			
			//les opérations de fournisseur:
			if(e.getSource() == ajouterF) {
				this.addFournisseur();
				this.displayDataFournisseur();
			}
			if(e.getSource() == modifierF) {
				this.UpdateFournisseur();
				this.tableF.setModel(this.displayDataFournisseur());
			}
			if(e.getSource() == supprimerF) {
				System.out.print("Here Fournisseur");
				this.DeleteFournisseur();			
			}
			
			//les opérations de commandes:
			if(e.getSource() == ajouterC) {
				this.addCommande();
				this.displayDataCommande();
			}
			if(e.getSource() == modifierC) {
				this.UpdateCommande();
				this.tableC.setModel(this.displayDataCommande());
			}
			if(e.getSource() == supprimerC) {
				System.out.print("Here");
				this.DeleteCommande();			
			}
			if(e.getSource() == chater) {
				System.out.print("Here");
				MainServer s= new MainServer();
			}
		}
	


		//Afficher Nom du pharmacien:
		
		public void user(String cin) {
				try {
					String sql= "SELECT nom , prénom FROM Pharmaciens WHERE cin=?";
		            PreparedStatement pst=conn.prepareStatement(sql);
					pst.setString(1,cin);
		            ResultSet res=pst.executeQuery();
		            if (res.next())  {
		            	System.out.println(res.getString(1));
		            	user.setText(res.getString(1));
		            	userp.setText(res.getString(2));
		
		            }
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		//Les fonctions d'Opération sur Fournisseur:
	
			//fonction d'affichage retourne un model
			public DefaultTableModel displayDataFournisseur() {
				column_headingF.addElement("Id de fournisseur");
				column_headingF.addElement("Nom");
				column_headingF.addElement("Prénom");
				column_headingF.addElement("Email de fournisseur");
				column_headingF.addElement("Téléphone de fournisseur");
				column_headingF.addElement("Société");
				column_headingF.addElement("Id de contrat");
				column_headingF.addElement("Téléphone de société");
				column_headingF.addElement("Email de société");
				column_headingF.addElement("Adresse de société");
						
				modelF = new DefaultTableModel(fi.getAllFournisseurs(), column_headingF);	   
				return modelF;
			}
					
			//fonction d'ajout d'un fournisseur:
			public void addFournisseur() {
						
				models.Fournisseur f = new models.Fournisseur();
				
				f.setId_fournisseur(idF.getText());
				f.setNom(nomF.getText());
				f.setPrenom(prénomF.getText());
				f.setEmail_fournisseur(emailF.getText());
				f.setTelephone_fournisseur(telF.getText());	
				f.setSociete(société.getText());
				f.setId_contrat(idContrat.getText());
				f.setTelephone_societe(telS.getText());
				f.setEmail_societe(emailS.getText());
				f.setAdresse_societe(adresseS.getText());

						
				System.out.print(f);
				fi.addFournisseur(f);
				this.tableF.setModel(this.displayDataFournisseur());
		   
			}
					
			//fonction de modification de fournisseur:
			public void UpdateFournisseur() {
				Implementation.FournisseurImp fi= new Implementation.FournisseurImp();
						
				models.Fournisseur f = new models.Fournisseur();
						
				f.setNom(nomF.getText());
				f.setPrenom(prénomF.getText());
				f.setEmail_fournisseur(emailF.getText());
				f.setTelephone_fournisseur(telF.getText());	
				f.setSociete(société.getText());
				f.setSociete(idContrat.getText());
				f.setSociete(telS.getText());
				f.setSociete(emailS.getText());
				f.setSociete(adresseS.getText());
						
				System.out.print(f);
				fi.UpdateFournisseur(f,idF.getText());

			}
					
			//fonction de suppression de fournisseur:
			public void DeleteFournisseur() {
				System.out.println(idF.getText());

				Implementation.FournisseurImp fi= new Implementation.FournisseurImp();
				fi.DeleteFournisseur(idF.getText());
				this.tableF.setModel(this.displayDataFournisseur());
			}
			
			//Les fonctions d'Opération sur Médicament:
					
			//fonction d'affichage retourne un model
			public DefaultTableModel displayDataMedicament() {
				column_headingM.addElement("Id de médicament");
				column_headingM.addElement("Marque");
				column_headingM.addElement("DCI");
				column_headingM.addElement("Présentation");
				column_headingM.addElement("Classe");
				column_headingM.addElement("Dosage");
				column_headingM.addElement("Forme");
				column_headingM.addElement("Titulaire");
				column_headingM.addElement("PPV");
				column_headingM.addElement("Prix base de remboursement");
				column_headingM.addElement("Statut de commercialisation");
				column_headingM.addElement("Quantité");
						
				modelM = new DefaultTableModel(mi.getAllMedicaments(), column_headingM);	   
				return modelM;
			}
					
			//fonction d'ajout d'un médicament:
			public void addMedicament() {
						
				models.Medicament m = new models.Medicament();
				m.setId_medicament(Integer.parseInt(idM.getText()));
				m.setMarque(marque.getText());
				m.setDci(dci.getText());
				m.setPrestentation(présentation.getText());
				m.setCla(classe.getText());	
				m.setDosage(dosage.getText());	
				m.setForme(forme.getText());	
				m.setTitulaire(titulaire.getText());	
	            m.setPpv(Double.parseDouble(ppv.getText()));
	            m.setPbase_remp(Double.parseDouble(pb_remb.getText()));
				m.setSt_comm(st_comm.getText());
				m.setQuantite(Integer.parseInt(quantité.getText()));
						
				System.out.print(m);
				mi.addMedicament(m);
				this.tableM.setModel(this.displayDataMedicament());
	   
			}
					
			//fonction de modification de médicament:
			public void UpdateMedicament() {
				Implementation.MedicamentImp mi= new Implementation.MedicamentImp();
						
				models.Medicament m= new models.Medicament();
				m.setMarque(marque.getText());
				m.setDci(dci.getText());
				m.setPrestentation(présentation.getText());
				m.setCla(classe.getText());	
				m.setDosage(dosage.getText());	
				m.setForme(forme.getText());	
				m.setTitulaire(titulaire.getText());	
	            m.setPpv(Double.parseDouble(ppv.getText()));
	            m.setPbase_remp(Double.parseDouble(pb_remb.getText()));
				m.setSt_comm(st_comm.getText());
				m.setQuantite(Integer.parseInt(quantité.getText()));
						
				System.out.print(m);
				mi.UpdateMedicament(m,Integer.parseInt(idM.getText()));
				
			}
					
			//fonction de suppression de médicament:
			public void DeleteMedicament() {
				System.out.println(idM.getText());

				Implementation.MedicamentImp mi= new Implementation.MedicamentImp();
				mi.DeleteMedicament(Integer.parseInt(idM.getText()));
				this.tableM.setModel(this.displayDataMedicament());

	        }
			
			//Les fonctions d'Opération sur Commande:
					
			//fonction d'affichage retourne un model
			public DefaultTableModel displayDataCommande() {
				column_headingC.addElement("Id de Commande");
				column_headingC.addElement("Id de Fournisseur");
				column_headingC.addElement("Id de Médicament");
				column_headingC.addElement("Quantité totale");
				column_headingC.addElement("Prix Total");
				column_headingC.addElement("Date de commande");
			
				modelC = new DefaultTableModel(ci.getAllCommandes(), column_headingC);	   
				return modelC;
			}
					
			//fonction d'ajout d'un commande:
			public void addCommande() {
						
				models.Commande c = new models.Commande();
				
				c.setId_commande(idC.getText());
				c.setId_fournisseur(idCF.getText());
				c.setMedicament(Integer.parseInt(idCM.getText()));
				c.setQuantite_totale(Integer.parseInt(quantité.getText()));
				c.setPrix_total(Integer.parseInt(ppvT.getText()));	
				c.setDate_commande(date.getDate());
						
				System.out.print(c);
				ci.addCommande(c);
				this.tableC.setModel(this.displayDataCommande());

			}
					
			//fonction de modification de commande:
			public void UpdateCommande() {
				Implementation.CommandeImp ci= new Implementation.CommandeImp();
						
				models.Commande c = new models.Commande();
				
				c.setId_fournisseur(idCF.getText());
				c.setMedicament(Integer.parseInt(idCM.getText()));
				c.setQuantite_totale(Integer.parseInt(quantité.getText()));
				c.setPrix_total(Integer.parseInt(ppvT.getText()));	
				c.setDate_commande(date.getDate());
						
				System.out.print(c);
				ci.UpdateCommande(c,idC.getText());
				
			}
					
			//fonction de suppression de commande:
			public void DeleteCommande() {
				System.out.println(idC.getText());

				Implementation.CommandeImp ci= new Implementation.CommandeImp();
				ci.DeleteCommande(idC.getText());
				this.tableC.setModel(this.displayDataCommande());

	        }
}