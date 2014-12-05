package dai_dojo1_sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	public static void main(String[] args){
		try(Socket socket=new Socket("localhost",1234)){
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			BufferedReader console = new BufferedReader(new InputStreamReader(
					System.in));
			PrintStream outStream = new PrintStream(socket.getOutputStream());
			
			while(true){
				String tosend = console.readLine();
				outStream.println(tosend);
				String mensaje = br.readLine();
				System.out.println(mensaje);
			}
		}catch(UnknownHostException e){
			System.err.println(e.getMessage());
		}catch(IOException ex){
			System.err.println(ex.getMessage());
		}
	}
}
