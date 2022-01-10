package Interface_graphique;

import java.awt.EventQueue;


import javax.swing.*;

import app.ConnexionSingleton;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import java.util.logging.*;

public class Home implements ActionListener{
		private JFrame frame;
		private JTextField tuser;
		private JPasswordField tpass;
		private JComboBox combo;
        Connection conn= ConnexionSingleton.getInstance();


		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Home window = new Home();
						window.frame.setVisible(true);
						System.out.println("Hi");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public Home() {
			initialize();
		}

		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 800, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(120,188,225));
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lab1 = new JLabel("Se Connecter");
			lab1.setForeground(Color.WHITE);
			lab1.setFont(new Font("Georgia", Font.BOLD, 40));
			lab1.setBounds(56, 26, 327, 53);
			lab1.setAlignmentY(1.0f);
			lab1.setAlignmentX(2.0f);
			panel.add(lab1);
			
			JLabel lab2 = new JLabel("Utilisateur : ");
			lab2.setFont(new Font("Georgia", Font.PLAIN, 20));
			lab2.setBounds(10, 129, 135, 33);
			panel.add(lab2);
			
			JLabel lab3 = new JLabel("Mot de passe : ");
			lab3.setFont(new Font("Georgia", Font.PLAIN, 20));
			lab3.setBounds(10, 204, 135, 33);
			panel.add(lab3);
			
			tuser = new JTextField();
			tuser.setForeground(Color.ORANGE);
			tuser.setBounds(155, 132, 185, 33);
			panel.add(tuser);
			tuser.setColumns(10);
			
			tpass = new JPasswordField();
			tpass.setForeground(Color.BLACK);
			tpass.setBounds(155, 207, 185, 33);
			panel.add(tpass);
			tpass.setColumns(10);
			
			JButton connect = new JButton("connecter");
			connect.setBackground(Color.WHITE);
			connect.setForeground(new Color(14, 78, 104));
			connect.setFont(new Font("Georgia", Font.BOLD, 25));
			connect.setBounds(182, 354, 185, 40);
			connect.addActionListener(this);
			panel.add(connect);
			
			JLabel lab4 = new JLabel("Choisir votre espace : ");
			lab4.setFont(new Font("Georgia", Font.PLAIN, 15));
			lab4.setBounds(10, 312, 165, 40);
			panel.add(lab4);
			
			String[] table = {"Gérant","Pharmacien"};
			
		    combo = new JComboBox();
		    combo.setFont(new Font("Georgia", Font.PLAIN, 15));
			combo.setModel(new DefaultComboBoxModel(table));
			combo.setBounds(10, 362, 135, 33);
			panel.add(combo);
			
			JLabel lblNewLabel = new JLabel(new ImageIcon(Home.class.getResource("/interface_graphique/back-img.jpeg")));
			lblNewLabel.setBounds(438, 0, 348, 463);
			panel.add(lblNewLabel);
		}
		public void actionPerformed(ActionEvent evt) {                                     
	     
	            String user=tuser.getText();
	            String pass=tpass.getText();
	            String e= combo.getSelectedItem().toString();
	            System.out.println(e);
	            if(e=="Pharmacien"){
	                try {
	                    //Class.forName("com.mysql.jdbc.Driver");
	                    String sql="SELECT * FROM pharmaciens WHERE cin=? AND password=?";
	                    PreparedStatement pst=conn.prepareStatement(sql);
	                    System.out.println(tuser.getText()+ " : "+tpass.getText());
	                    pst.setString(1,tuser.getText());
	                    pst.setString(2,tpass.getText());
	                    ResultSet rs=pst.executeQuery();
	                    if(rs.next()) {
	                    	System.out.println(rs.getString(1));
	                        Pharmacien f=new Pharmacien();
	                    
	                        this.frame.setVisible(false);
	                        f.frame.setVisible(true);
	                        f.user(rs.getString(1));
	                        System.out.println("Connected");
	                    }
	                    else{
	                        //JOptionPane.showMessageDialog(this,"Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
	                        tuser.setText("");
	                        tpass.setText("");
	                    }
	                    conn.close();
	                } catch (SQLException ex) {
	                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
	                }
	        }else{
	                try {
	                    Statement stm=conn.createStatement();
	                    
	                    String query="SELECT * FROM gérants WHERE cin='"+tuser.getText()+"' AND password='"+tpass.getPassword()+"'";
	                    ResultSet rst=stm.executeQuery(query);
	                    if(rst.next()){
	                        Gérant m=new Gérant();
	                        m.frame.setVisible(true);
	                        m.gerant(tuser.getText());
	                        this.frame.setVisible(false);
	                     }
	                    else{
	                        //JOptionPane.showMessageDialog(this,"Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
	                        tuser.setText("");
	                        tpass.setText("");
	                    }
	                } catch (SQLException ex) {
	                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
	                }
	            }
	        	System.out.println("Not Connected");
	    }                                    
	    }