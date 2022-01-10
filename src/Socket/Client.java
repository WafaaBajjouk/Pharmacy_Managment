package Socket;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

public class Client implements ActionListener{
     PrintWriter out;   
     Socket clientSocket;
     BufferedReader in;
    final Scanner sc = new Scanner(System.in); 
    
    public void Run() {
    	try {
		clientSocket = new Socket("localhost",5000);
        out = new PrintWriter(clientSocket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.Send("Vous avez entrez a la conversation");

         this.Read();

        
    	}catch(IOException e) {
    		
    	}
    }
	public void Send(String msg) {
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                	
//                    msg = sc.nextLine();
            	
            		chat.append("\n-Pharmacien: "+msg);
                    out.println(msg);
                    out.flush();
                
            }
        });
        sender.start();
	}
	
	public void Read() {
              String msg;
   try {
                      msg = in.readLine();
                      while(msg!=null){
//                          System.out.println("Server : "+msg);

                          msg = in.readLine();
          				chat.append("\n-Gérant: "+msg);

                      }
                      System.out.println("Server is down");
                      out.close();
                      clientSocket.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              
	}
	
	
	
//	============================================================================================================
	private JFrame frame;
	private JTextField message;
	JButton send = new JButton("Envoyer");
	JTextArea chat = new JTextArea();




	public Client() {
		initialize();
	}

	private void initialize() {
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
		
		frame.setTitle("Pharmacien");

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==send) {
            String msg=message.getText();
            this.Send(msg);
            message.setText(" ");  
		}
	}

}
	

    
