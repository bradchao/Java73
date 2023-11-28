package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad42 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/cafe2.jfif");
			FileOutputStream fout = new FileOutputStream("dir2/cafe2.jfif");
			
			int len; byte[] buf = new byte[4*1024];
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			fout.flush();
			fout.close();
			fin.close();
			System.out.println("Finish:" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
