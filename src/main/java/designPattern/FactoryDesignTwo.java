package designPattern;

interface Animal1{
	public String speak();
}

class Dog1 implements Animal1{
	@Override
	public String speak() {
		return "Waao Waao...!";
		
	}
}

class Cat1 implements Animal1{
	@Override
	public String speak() {
		return "Meow Meow...!";
		
	}
}
public class FactoryDesignTwo {
	
	
	public Animal1 getObj(String pad) {
		if(pad.equals("Dog")) {
			return  new Dog1();
		}else {
			return new Cat1();
		}
	}
	
	
	public static void main(String[] args) {
		
		FactoryDesignTwo f2 = new FactoryDesignTwo();
		Animal1 ani = f2.getObj("Cat");
		
		System.out.println(ani.speak()+" Cat is here");
		
		ani = f2.getObj("Dog");
		
		System.out.println(ani.speak()+" Dog is here");
	}

}
