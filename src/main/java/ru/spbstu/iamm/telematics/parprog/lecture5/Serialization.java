package ru.spbstu.iamm.telematics.parprog.lecture5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ContainerObject o = new ContainerObject(1,.01, null);
		ContainerObject a = new ContainerObject(2,.01, o);
		ContainerObject b = new ContainerObject(3,.01, o);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(o);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/obj"));
		oos.writeObject(a);
		oos.writeObject(b);
		oos.close();
		
		ContainerObject a2 = null;
		ContainerObject b2 = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/obj"));
		a2 = (ContainerObject) ois.readObject();
		b2 = (ContainerObject) ois.readObject();
		System.out.println(a2);
		System.out.println(b2);
		System.out.println(a2.getParent());
		System.out.println(b2.getParent());
		ois.close();
	}

}
