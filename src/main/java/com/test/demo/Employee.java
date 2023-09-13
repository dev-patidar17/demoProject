package com.test.demo;

import java.util.Date;

public class Employee implements Cloneable, Comparable<Employee>{
	
	private int id;
	private String name;
	private String lastName;
	private double salary;
	private Date doj;
	private String department;;
	
	public Employee(int id, String name, double salary, Date doj) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.doj = doj;
		
	}
	
	public Employee(int id, String name, String lastName, double salary, Date doj) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
		this.doj = doj;
	}

	public Employee(int id, String name, String lastName, double salary, Date doj, String department) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
		this.doj = doj;
		this.department = department;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	

	 public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	Employee() {
		
	}

	private static Employee emp = null;
	
	public static Employee getInstance() {
		
		if(emp == null)
			emp = new Employee();
		
		return emp;
			
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 if (this == obj) 
			 	return true;
		 
		 if (obj == null || getClass() != obj.getClass()) 
			 	return false;
		 
		 Employee em = (Employee) obj;
		if(this.getDoj().compareTo(em.getDoj())==0 && this.getId()==em.getId() && 
				this.getName().equals(em.getName()) && this.getSalary() == em.getSalary()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastName=" + lastName + ", salary=" + salary + ", doj="
				+ doj + ", department=" + department + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Employee o) {
	
			int compareTo = this.getDoj().compareTo(o.getDoj());
		return compareTo;
	}
	

}
