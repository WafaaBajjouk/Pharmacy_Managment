package Socket;

public class MainClient {
	Client client= new Client();
	MainClient(){
		client.Run();
	}
	public  static void main(String [] args) {
		MainClient c= new MainClient();
	}
}

