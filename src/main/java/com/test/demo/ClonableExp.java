package com.test.demo;

//A Java program to demonstrate
//deep copy using clone()

//An object reference of this
//class is contained by Test2
class Test11 {
	int x, y;
}

//Contains a reference of Test and
//implements clone with deep copy.
class Test22 implements Cloneable {
	int a, b;

	Test11 c = new Test11();

	public Object clone() throws CloneNotSupportedException
	{
		// Assign the shallow copy to
		// new reference variable t
		Test22 t = (Test22)super.clone();

		// Creating a deep copy for c
		t.c = new Test11();
		t.c.x = c.x;
		t.c.y = c.y;

		// Create a new object for the field c
		// and assign it to shallow copy obtained,
		// to make it a deep copy
		return t;
	}
}

public class ClonableExp {
	public static void main(String args[])
		throws CloneNotSupportedException
	{
		Test22 t1 = new Test22();
		t1.a = 10;
		t1.b = 20;
		t1.c.x = 30;
		t1.c.y = 40;

		Test22 t3 = (Test22)t1.clone();
		t3.a = 100;

		// Change in primitive type of t2 will
		// not be reflected in t1 field
		t3.c.x = 300;

		// Change in object type field of t2 will
		// not be reflected in t1(deep copy)
		System.out.println(t1.a + " " + t1.b + " " + t1.c.x
						+ " " + t1.c.y);
		System.out.println(t3.a + " " + t3.b + " " + t3.c.x
						+ " " + t3.c.y);
	}
}

