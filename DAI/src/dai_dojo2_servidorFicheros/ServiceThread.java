package dai_dojo2_servidorFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServiceThread implements Runnable {
	private final Socket socket;
	public ServiceThread(Socket clientSocket){
		this.socket = clientSocket;
	}
	public void run(){
		try(Socket socket = this.socket){
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String nomFichero = br.readLine();
			OutputStream output = socket.getOutputStream();
			File archivo = new File(nomFichero);
			if(archivo.exists() && archivo.canRead()){
				output.write(1);//El fichero existe, se envia 1 para indicarselo al cliente
				FileInputStream reading = new FileInputStream(archivo);
				int readaux;
				while((readaux=reading.read()) != -1){
					output.write(readaux);
				}
			}else{
				output.write(0); // El fichero no existe, se envia 0 para indicarselo al cliente
			}
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
	
}
