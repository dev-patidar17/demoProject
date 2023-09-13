package com.test.demo;

public class TrickyProgram {
	
	@SuppressWarnings("finally")
	public static String method1() {
		
		try {
			
			String s = "from try";
			System.out.println(s);
			return s;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			return "finally";
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(method1());
        try {
            int i=9;
            System.out.println(i);
            return;
        } catch (Exception e) {
            System.out.println("exception caught");
            return;
        }
      
    }

}
