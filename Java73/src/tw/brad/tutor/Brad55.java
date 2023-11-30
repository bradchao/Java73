package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Brad55 {

	public static void main(String[] args) {
		while (true) {
			byte[] buf = new byte[1024];
			try (DatagramSocket socket = new DatagramSocket(8888);){
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				//socket.close();
				System.out.println("Receive OK");
				
				int len = packet.getLength();
				byte[] data = packet.getData();
				InetAddress urip = packet.getAddress();
				System.out.printf("%s : %s\n", urip.getHostAddress(), 
						new String(data, 0, len));
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
