package dai_dojo2_servidorFicheros;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args){
		try(Socket socket = new Socket("localhost",1234)){
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			InputStream file = socket.getInputStream();
			PrintStream fileNameToSend = new PrintStream(socket.getOutputStream());
			System.out.println("Enter file name");
			String tosend = console.readLine();
			fileNameToSend.println(tosend);//El nombre del archivo se envia
			if(file.read() == 0){
				System.out.println("File not found");
			}else{
				FileOutputStream fichero = new FileOutputStream(tosend+"copy.txt");
				int a;
				while((a=file.read())!=-1){
					fichero.write(a);//Copia el contenido en el nuevo fichero
				}
				System.out.println("Done.");
			}
		}catch(UnknownHostException e){
			System.err.println(e.getMessage());
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}
