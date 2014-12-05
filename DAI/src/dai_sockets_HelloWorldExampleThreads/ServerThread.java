package dai_sockets_HelloWorldExampleThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
	public static void main(String[] args){
	
		try(ServerSocket serverSocket = new ServerSocket(1234)){
			
			while(true){
			Socket socket = serverSocket.accept();
			new Thread(new ServiceThread(socket)).start();
			}
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}
