package dai_sockets_HelloWorldUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Destiny {
	public static void main(String[] args){
		try(DatagramSocket socket=new DatagramSocket(1234)){
			byte[] buffer=new byte[128];
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
			socket.receive(packet);
			final String message = new String(packet.getData(),0,packet.getLength()
					);
			System.out.println(message);
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}
