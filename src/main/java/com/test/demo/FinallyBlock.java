package com.test.demo;

public class FinallyBlock {
	
	
	public String getData() {
		
		try {
			System.exit(-1);
			return "hello";
		}catch (Exception e) {
			e.printStackTrace();
		} finally {

			System.out.println("what a finally");
			return "From finally";
		}
		
	}

	public static void main(String[] args) {

		FinallyBlock ff = new FinallyBlock();
		System.out.println( ff.getData());
	}

}
management.endpoint.web.exposure.include=*
management.endpoint.web.exposure.exclude=*
management.endpoint.<id>.enabled=true
management.endpoint.id.enable=false
management.endpoint.web.exposure.exclude=env,bean,logging