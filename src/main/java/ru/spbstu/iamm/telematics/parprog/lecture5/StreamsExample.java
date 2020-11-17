package ru.spbstu.iamm.telematics.parprog.lecture5;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class StreamsExample {
	
	public static void main(String args[]) {
		writeData();
		readData();
	}

	private static void readData() {
		try {
			DataInputStream dis = new DataInputStream(new GZIPInputStream(new FileInputStream("/tmp/out1")));
			
			String str;
			int val;
			double dVal;
			
			str = dis.readUTF();
			val = dis.readInt();
			dVal = dis.readDouble();
			
			System.out.println("str=" + str +", val=" + val + ", double val =" + dVal);
			dis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeData() {
		DataOutputStream fos = null;
		try {
			fos = new DataOutputStream(

							new GZIPOutputStream(
									new FileOutputStream("/tmp/out1")
							)
						
				  );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String str = "it is a text for writing to the file";
		byte[] bytes = str.getBytes();
		int someVal = 5;
		try {
			fos.writeUTF(str);
			fos.writeInt(someVal);
			fos.writeDouble(0.021);

			if (fos != null)
				fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
