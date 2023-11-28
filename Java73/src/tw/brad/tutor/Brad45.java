package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import tw.brad.classes.Student;

public class Brad45 {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = 
				new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream("dir1/s1.brad")));
			Object obj = oin.readObject();
			if (obj instanceof Student) {
				Student s1 = (Student)obj;
				System.out.println(s1.sum());
				System.out.println(s1.avg());
				System.out.println("---");
			}
			System.out.println("---");
			Object obj2 = oin.readObject();
			if (obj2 instanceof Student) {
				Student s2 = (Student)obj2;
				System.out.println(s2.sum());
				System.out.println(s2.avg());
				System.out.println("---");
			}
			oin.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
