package com.test.demo;


class One11{
	
	public void methodOne(String str) {
		
		System.out.println(str);
		
	}
}

class Two11 extends One11{
	
	public void methodTwo(String str) {
		super.methodOne(str);
	}
	
}

class Three11 extends Two11{
	
	public void methodThree(String str) {
		super.methodOne(str);
	}
	
}

class Four11 extends Three11{
	
	public void methodFour() {
	System.out.println("method four");
	}

}


public class MultiLevelInheritance {
	
	
	public static void main(String[] args) {
		
		Four11 t = new Four11();
		t.methodOne("Meth 1");
		
		t.methodTwo("Meth 2");
		
		t.methodThree("Meth 3");
		t.methodFour();
	}

}
