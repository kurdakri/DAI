package dai_dojo1_sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args){
		try(ServerSocket serverSocket= new ServerSocket(1234)){
			while(true){
				try(Socket socket = serverSocket.accept()){
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
					PrintStream outStream = new PrintStream(socket.getOutputStream());
					
					while(true){
						String mensaje = br.readLine();
						System.out.println(mensaje);
						String tosend = console.readLine();
						outStream.println(tosend);
					}
				}
			}
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}
