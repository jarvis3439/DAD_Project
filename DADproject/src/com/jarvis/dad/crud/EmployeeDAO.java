package com.jarvis.dad.crud;

import java.util.List;

public interface EmployeeDAO {
	public int addEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(int empid);
	public Employee getEmployee(int empid);
	public List<Employee> getAllEmployees();
}
