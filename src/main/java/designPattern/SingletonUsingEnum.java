package designPattern;

public class SingletonUsingEnum {

	public static void main(String[] args) {
		SingletonEnum sc = SingletonEnum.INSTANCE;
		SingletonEnum sc2 = SingletonEnum.INSTANCE;
		System.out.println(sc.hashCode()+ ".............."+sc2.hashCode());
		

	}

}
