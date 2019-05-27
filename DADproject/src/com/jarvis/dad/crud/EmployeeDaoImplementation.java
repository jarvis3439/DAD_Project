package com.jarvis.dad.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImplementation implements EmployeeDAO {
	
	static Connection connection;
	static PreparedStatement ps;

	@Override
	public int addEmployee(Employee employee) {
		int status = 0;
		try {
			connection = MyConnectionProvider.getConnection();
			ps = connection.prepareStatement("insert into employee(name,department,salary) values(?, ?, ?)");
			ps.setString(1, employee.getEmployeeNameString());
			ps.setString(2, employee.getDepartmentString());
			ps.setInt(3, employee.getSalary());
			
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int status = 0;
		try {
			connection = MyConnectionProvider.getConnection();
			ps = connection.prepareStatement("update employee set name=?, designation=?, salary=? where empid=?");
			ps.setString(1, employee.getEmployeeNameString());
			ps.setString(2, employee.getDepartmentString());
			ps.setInt(3, employee.getSalary());
			ps.setInt(4, employee.getEmpid());
			
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int deleteEmployee(int empid) {
		int status = 0;
		try {
			connection = MyConnectionProvider.getConnection();
			ps = connection.prepareStatement("delete from employee where empid=?");
			ps.setInt(1, empid);
			
			status = ps.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Employee getEmployee(int empid) {
		Employee employee = new Employee();
		
		try {
			connection = MyConnectionProvider.getConnection();
			ps = connection.prepareStatement("select * from employee where empid = ?");
			ps.setInt(1, empid);
			
			ResultSet resultSet = ps.executeQuery();
			
			if (resultSet.next()) {
				employee.setEmpid(resultSet.getInt(1));
				employee.setEmployeeNameString(resultSet.getString(2));
				employee.setDepartmentString(resultSet.getString(3));
				employee.setSalary(resultSet.getInt(4));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> list = new ArrayList<Employee>();
		try {
			connection = MyConnectionProvider.getConnection();
			ps = connection.prepareStatement("select * from employee");
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpid(resultSet.getInt(1));
				employee.setEmployeeNameString(resultSet.getString(2));
				employee.setDepartmentString(resultSet.getString(3));
				employee.setSalary(resultSet.getInt(4));
				list.add(employee);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

}
