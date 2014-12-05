package dai_sockets_HelloWorldExample;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args){
		
		try(ServerSocket serverSocket = new ServerSocket(1234)){
			while(true){
				try(Socket socket=serverSocket.accept()){
				OutputStream out = socket.getOutputStream();
				out.write("Hello world".getBytes());
				out.flush();
				}
			}
			
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}

}
