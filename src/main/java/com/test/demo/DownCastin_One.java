package com.test.demo;

class Animal_2{
	public void makeSound() {
		System.out.println("all animal make sound"); 
	}
}
class Dog_1 extends Animal_2{
	public void makeSound() {
		System.out.println("Dog also make sound");
	}
	public void eat() {
		System.out.println("Dog is eating Chapati");
	}
}

public class DownCastin_One {

	public static void main(String[] args) {
		 
		Animal_2 animal = new Dog_1();
		Animal_2 animal2 = new Animal_2();
		animal2.makeSound();
		animal.makeSound();
		if(animal instanceof Dog_1) {
			Dog_1 dg = (Dog_1) animal;
			dg.eat();
			
		}
		

	}

}
