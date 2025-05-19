package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(Employee employee) {
		Employee saveEmployee = employeeRepository.save(employee);
		return "Employee Added";
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployee = employeeRepository.findAll();
		return allEmployee;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Optional<Employee> employeebyId = employeeRepository.findById(employeeId);
		return employeebyId.orElse(null);
	}

	@Override
	public String updateEmployee(Integer employeeId, Employee employee) {
		Optional<Employee> byId = employeeRepository.findById(employeeId);
		if (byId.isPresent()) {
			Employee employee2 = byId.get();
			employee2.setEmployeeName(employee.getEmployeeName());
			employee2.setEmployeeDepartment(employee.getEmployeeDepartment());
			employee2.setEmployeeSalary(employee.getEmployeeSalary());
			
			employeeRepository.save(employee2);
		}
		return "Employee Update Success!!";
	}

	@Override
	public String deleteEmployeeById(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Employee Delete Success";
	}

}
