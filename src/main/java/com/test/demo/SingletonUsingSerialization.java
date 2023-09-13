package com.test.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonUsingSerialization implements Serializable{
	

   
	public static SingletonUsingSerialization singletonUsingSerialization = new SingletonUsingSerialization();
	
	private SingletonUsingSerialization() {
		
	}
	
	protected Object readResolve() {
		return singletonUsingSerialization;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ObjectOutputStream objOut = null;
		ObjectInputStream objIn = null;
			try {
				objOut = new ObjectOutputStream(new FileOutputStream("C://Users/user/Desktop/Serialization.txt"));
				objOut.writeObject(SingletonUsingSerialization.singletonUsingSerialization);
				
				objIn = new ObjectInputStream(new FileInputStream("C://Users/user/Desktop/Serialization.txt"));
				SingletonUsingSerialization readObject = (SingletonUsingSerialization) objIn.readObject();
				
				System.out.println(SingletonUsingSerialization.singletonUsingSerialization.hashCode()+"   "+readObject.hashCode()); 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

}
