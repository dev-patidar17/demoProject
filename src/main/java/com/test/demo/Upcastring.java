package com.test.demo;


class Animal1{
	public void makeSound() {
		System.out.println("All animal make sound");
	}
}
class Dog extends Animal1{
	
	public void makeSound() {
		System.out.println("Dog also bark");
	}
}
public class Upcastring {
	
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		
		Animal1 animal = dog;
		
		animal.makeSound();
	}

}
