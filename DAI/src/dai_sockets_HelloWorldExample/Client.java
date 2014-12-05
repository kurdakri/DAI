package dai_sockets_HelloWorldExample;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args){
		try(Socket socket = new Socket("localhost",1234)){
			InputStream input = socket.getInputStream();
			int read;
			while((read=input.read()) != -1){
				System.out.print((char)read);
			}
			System.out.println();
		}catch(UnknownHostException e){
			System.err.println("Unknown host");
		}catch(IOException ex){
			System.err.println(ex.getMessage());
		}

	}	
}
