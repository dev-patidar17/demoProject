package com.test.demo;

public class EmployeeFamilyDetails {
	
	private String empId;
	private String motherName;
	private String fatherName;
	private String address;
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public EmployeeFamilyDetails(String empId, String motherName, String fatherName, String address) {
		this.empId = empId;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.address = address;
	}
	public EmployeeFamilyDetails() {
		
	}
	
	

}
