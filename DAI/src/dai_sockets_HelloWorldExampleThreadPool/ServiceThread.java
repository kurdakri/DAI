package dai_sockets_HelloWorldExampleThreadPool;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ServiceThread implements Runnable {
	private final Socket socket;
	public ServiceThread(Socket clientSocket){
		this.socket = clientSocket;
	}
	
	public void run(){
		try(Socket socket = this.socket){
			PrintStream output = new PrintStream(socket.getOutputStream());
			output.println("Hello World");
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}
