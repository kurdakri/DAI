package dai_sockets_HelloWorldExampleThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args){
		try(Socket socket=new Socket("localhost",1234)){
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = br.readLine();
			System.out.println(message);
		}catch(UnknownHostException e){
			System.err.println(e.getMessage());
		}catch(IOException ex){
			System.err.println(ex.getMessage());
		}
	}
}
