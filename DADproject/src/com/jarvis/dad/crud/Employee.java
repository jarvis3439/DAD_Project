package com.jarvis.dad.crud;

public class Employee {
	private int empid, salary;
	private String employeeNameString, departmentString;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmployeeNameString() {
		return employeeNameString;
	}
	public void setEmployeeNameString(String employeeNameString) {
		this.employeeNameString = employeeNameString;
	}
	public String getDepartmentString() {
		return departmentString;
	}
	public void setDepartmentString(String departmentString) {
		this.departmentString = departmentString;
	}
	
}
