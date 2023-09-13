package com.test.singleton;


class SingletonBreak implements Cloneable{
	
	public static SingletonBreak st = new SingletonBreak();
	
	private SingletonBreak() {
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return st;
	}
	
}
public class SingletonBreakClone {
	
	public static void main(String args[]) throws CloneNotSupportedException {
		
		System.out.println(SingletonBreak.st.hashCode());
		System.out.println(SingletonBreak.st.hashCode());
		SingletonBreak clone = (SingletonBreak) SingletonBreak.st.clone();
		System.out.println(clone.clone().hashCode());
	}

}
