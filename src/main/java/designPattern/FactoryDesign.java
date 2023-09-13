package designPattern;


 interface Animal{
	String speak();
}
 
 class Cat implements Animal{
	 
	 @Override
	public String speak() {
		// TODO Auto-generated method stub
		return "Meow ...Meow";
	}
 }
 
class Dog implements Animal{
	 
	 @Override
	public String speak() {
		// TODO Auto-generated method stub
		return "Woof....Woof";
	}
 }

class Factory {
	
	public Animal getObject(String animalType) {
		
		if(animalType.equals("Cat")) {
			return new Cat();
		}else if(animalType.equals("Dog")) {
			return new Dog();
		}
		return null;
	}
}
public class FactoryDesign {

	public static void main(String[] args) {
		
		
		Factory factory = new Factory();
		
		Animal object = factory.getObject("Dog");
		
		if(object instanceof Cat) {
			
			System.out.println(object.speak()+"   Pusssy is here");
			
		}
		if(object instanceof Dog) {
			System.out.println(object.speak()+"   Jacky is here");
		}
		
		

	}

}
