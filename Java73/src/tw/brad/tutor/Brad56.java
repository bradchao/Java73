package tw.brad.tutor;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad56 {

	public static void main(String[] args) {
		String mesg = "quit";
		try {
			Socket client = new Socket(
				InetAddress.getByName("10.0.104.130"), 80);
			
			OutputStream out = client.getOutputStream();
			BufferedOutputStream bout = new BufferedOutputStream(out);
			bout.write(mesg.getBytes());
			bout.flush();
			bout.close();
			
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
