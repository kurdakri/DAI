package dai_sockets_HelloWorldExampleThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerThread {
	public static void main(String[] args){
		try(ServerSocket serverSocket=new ServerSocket(1234)){
			ExecutorService pool = Executors.newFixedThreadPool(50);
			while(true){
				Socket socket = serverSocket.accept();
				pool.execute(new ServiceThread(socket));
			}
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
		
	}
}
