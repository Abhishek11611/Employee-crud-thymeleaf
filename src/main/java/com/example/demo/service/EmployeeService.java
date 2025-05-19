package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(Integer employeeId);
	
	public String updateEmployee(Integer employeeId,Employee employee);
	
	public String deleteEmployeeById(Integer employeeId);

}
