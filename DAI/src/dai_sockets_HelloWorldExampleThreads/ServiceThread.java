package dai_sockets_HelloWorldExampleThreads;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServiceThread implements Runnable{
	
	private final Socket socket;
	
	public ServiceThread(Socket clientSocket){
		this.socket = clientSocket;
	}
	
	public void run(){
		try(Socket socket = this.socket){
			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println("Hello World");
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
		
	}

}
