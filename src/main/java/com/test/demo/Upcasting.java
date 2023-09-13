package com.test.demo;



class Animal{
	
	String name;
	long phoneno;
	
	public void eat() {
		System.out.println("Eating...!"); 
	}
}

class Cat extends Animal{
	
	public void meow() {
		System.out.println("Meow Meow....!");
		
	}
}

class Cow extends Animal{
	
	public void milk() {
		System.out.println("Cow Milk....!");
		
	}
}

public class Upcasting {

	public static void main(String[] args) {

		Animal animal = new Cat();	// Up casting 
		animal.name = "Ram";
		animal.phoneno = 76876;
		animal.eat();

		Cat cat = (Cat) animal;  //Down casting
		cat.meow();
		Cat ct = (Cat) new Animal();
		 if (Cat.class.isInstance(animal)) {
		        Cat cat1 = Cat.class.cast(animal);
		        cat.meow();
		    }
		 Animal an = new Cat();
		 Cat ctt = (Cat)an;
		 Animal cw = new Cow();
		 Cow cow = (Cow)cw;
		 cow.milk();
		 
		 Animal animal2 = new Animal();
		 
		 Cow coww = new Cow();
		 
		 animal2 = coww;
		 animal2.eat();
	//	String s = (String) animal;   //Compiler not allowed 
	}

}
