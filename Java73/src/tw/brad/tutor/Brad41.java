package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad41 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/cafe2.jfif");
			FileOutputStream fout = new FileOutputStream("dir2/cafe2.jfif");
			
			int b;
			while ( (b = fin.read()) != -1) {
				fout.write(b);
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
