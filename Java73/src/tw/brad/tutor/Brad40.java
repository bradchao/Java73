package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Brad40 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/ns1hosp.csv");
			BufferedReader br = new BufferedReader(reader);
			
			String line;
			br.readLine();
			while ( (line = br.readLine()) != null) {
				String[] row = line.split(",");
				System.out.printf("%s : %s : %s\n", row[2], row[5], row[6]);
			}
			
			
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
