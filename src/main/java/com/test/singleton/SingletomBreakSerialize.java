package com.test.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SingletonSr implements Serializable{
	public static SingletonSr sr = new SingletonSr();
	
	 private SingletonSr(){
		
	}
	 protected Object readResolve() {
		 return sr;
	 }
}

public class SingletomBreakSerialize {

	public static void main(String[] args) {
	
		SingletonSr instance = SingletonSr.sr;
		
		try {
			FileOutputStream fount = new FileOutputStream("C://Users/user/Desktop/Serialization.txt");
			ObjectOutputStream Oout = new ObjectOutputStream(fount);
			Oout.writeObject(instance);
			Oout.close();
			
			
			FileInputStream fin = new FileInputStream("C://Users/user/Desktop/Serialization.txt");
			ObjectInputStream oIn = new ObjectInputStream(fin);
			SingletonSr readObject = (SingletonSr) oIn.readObject();
			
		//	SingletonSr readObject2 = (SingletonSr) oIn.readObject();
			
			System.out.println("mail Obj:-"+ instance.hashCode());
			System.out.println("readObject Obj:-"+ readObject.hashCode());
			//System.out.println("readObject2 Obj:-"+ readObject2.hashCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
