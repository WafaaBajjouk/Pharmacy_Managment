package Socket;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;

import java.awt.event.*;

public class Server implements ActionListener{
    	
			final Scanner sc=new Scanner(System.in);
			ServerSocket serverSocket;
			Socket clientSocket;
			PrintWriter out;
			BufferedReader in;

  
          public void Run() {
        	  try {
         	  ServerSocket serverSocket = new ServerSocket(5000);
        	  Socket clientSocket = serverSocket.accept();
              this.Send("Pharmacien À rejoindree la conversation");


              out = new PrintWriter(clientSocket.getOutputStream());
              in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
              
              this.Read();
          }catch(IOException e) {
        	  
          }
          }

              public void Send(String msg) {
                  Thread sender= new Thread(new Runnable() {
                      @Override  
                      public void run() {
//                              msg = sc.nextLine();
                  				chat.append("\n-Gérant: "+msg);

                              out.println(msg);    
                              out.flush();   
                      }
                  });
                  sender.start();
              }

            
            public void Read() {
            	String m;
                    String msg ;

                        try {
                            msg = in.readLine();
                            while(msg!=null){
//                                System.out.println("Client : "+msg);
                                
                                msg = in.readLine();
                                chat.append("\nPharmacien :"+msg);
//
                            }

                            System.out.println("Disconnected ");

                   
                        } catch (IOException e) {
                            e.printStackTrace();
                            out.close();
                            try {
								clientSocket.close();
	                            serverSocket.close();

							} catch (IOException e1) {
								e1.printStackTrace();
							}
                        }
                    }
            
           //=====================================================================================================================
            
        	public JFrame frame;
        	public JTextField message;
    		JButton send = new JButton("Envoyer");
    		JTextArea chat = new JTextArea();



    
        	public Server() {
        		initialize();
        	}

        	public void initialize() {
        		frame = new JFrame();
        		frame.setBounds(100, 100, 800, 500);
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setResizable(false);
        		
        		JPanel panel = new JPanel();
        		frame.getContentPane().add(panel, BorderLayout.CENTER);
        		panel.setLayout(null);
        		
        		message = new JTextField();
        		message.setBounds(10, 401, 599, 52);
        		panel.add(message);
        		message.setColumns(10);
        		
        		send.setFont(new Font("Georgia", Font.BOLD, 20));
        		send.setBounds(619, 401, 157, 52);
        		send.addActionListener(this);
        		panel.add(send);
        		
        		chat.setBounds(10, 20, 766, 354);
        		panel.add(chat);
        		frame.setVisible(true);
        		frame.setTitle("Gérant");

        	}
        	
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource()==send) {
        		     String msg=message.getText();
        	            this.Send(msg);
        	            message.setText(" ");      		}
        	}
            
            
}
