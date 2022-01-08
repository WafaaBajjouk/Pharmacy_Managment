package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
    	
        final Scanner sc=new Scanner(System.in);

        try {
        	  final ServerSocket serverSocket = new ServerSocket(5000);
        	  final Socket clientSocket = serverSocket.accept();

              final PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
              final BufferedReader in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));

            Thread sender= new Thread(new Runnable() {
                String msg; 
                @Override  
                public void run() {
                    while(true){
                        msg = sc.nextLine(); 
                        out.println(msg);    
                        out.flush();   
                    }
                }
            });
            sender.start();

            Thread receive= new Thread(new Runnable() {
                String msg ;
                @Override
                public void run() {
                    try {
                        msg = in.readLine();
                        while(msg!=null){
                            System.out.println("Client : "+msg);
                            msg = in.readLine();
                        }

                        System.out.println("Disconnected ");

                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receive.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


