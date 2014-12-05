package dai_sockets_HelloWorldUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Origin {
	public static void main(String[] args){
		try(DatagramSocket socket = new DatagramSocket()){
			String message = "Hello world";
			DatagramPacket packet = new DatagramPacket(
					message.getBytes(),message.length(),
					InetAddress.getLocalHost(),1234
					);
			socket.send(packet);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
