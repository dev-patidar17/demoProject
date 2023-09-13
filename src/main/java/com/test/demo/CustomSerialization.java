package com.test.demo;

import java.beans.Transient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Account implements Serializable{
	
	String name = "Admin";
	transient String password = "admin123";
	
	private void writeObject(ObjectOutputStream Oout) throws IOException {
		
		Oout.defaultWriteObject();
		String pass = "admin123";
		Oout.writeObject(pass);
		
	}
	
	private void readObject(ObjectInputStream Oin) throws ClassNotFoundException, IOException{
		
		Oin.defaultReadObject();
		
		String pwd = Oin.readObject().toString();
		password = pwd;
	}
}

public class CustomSerialization {
	
	

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		FileOutputStream fout = new FileOutputStream("C://Users/user/Desktop/Serialization.txt");
		ObjectOutputStream Oout = new ObjectOutputStream(fout);
		Account acc = new Account();
		Oout.writeObject(acc);
		
		FileInputStream fin = new FileInputStream("C://Users/user/Desktop/Serialization.txt");
		ObjectInputStream Oin = new ObjectInputStream(fin);
		Account accn = (Account)Oin.readObject();
				
		System.out.println(accn.name+"    "+accn.password); 
	}

}
