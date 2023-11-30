package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad59 {

	public static void main(String[] args) {
		String mesg = "quit";
		try {
			File source = new File("");
			byte[] buf = new byte[(int)source.length()];
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
			bin.read(buf);
			bin.close();
			
			Socket client = new Socket(
					InetAddress.getByName("10.0.104.130"), 6666);
			
			BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			
			client.close();
			
			System.out.println("Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
