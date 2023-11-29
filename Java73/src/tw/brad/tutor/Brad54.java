package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad54 {

	public static void main(String[] args) {
		String mesg = "Hello, BradV2";
		byte[] data = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(data, data.length, 
				InetAddress.getByName("10.0.104.255"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
