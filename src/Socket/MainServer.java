package Socket;

public class MainServer {
	Server s= new Server();
	public MainServer(){
		s.Run();
	}
	
	public static void main(String [] args) {
		MainServer s= new MainServer();	}

}
