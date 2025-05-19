package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	 @GetMapping
	    public String getAllEmployees(Model model) {
	        List<Employee> employees = employeeService.getAllEmployee();
	        model.addAttribute("employees", employees);
	        return "employee-list";
	    }

	    @GetMapping("/add")
	    public String showAddForm(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "employee-form";
	    }

	    @PostMapping("/add")
	    public String addEmployee(@ModelAttribute("employee") Employee employee) {
	        employeeService.addEmployee(employee);
	        return "redirect:/employees";
	    }

	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Employee employee = employeeService.getEmployeeById(id);
	        model.addAttribute("employee", employee);
	        return "employee-form"; 
	    }

	    @PostMapping("/update/{id}")
	    public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute("employee") Employee employee) {
	        employeeService.updateEmployee(id, employee);
	        return "redirect:/employees";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable("id") Integer id) {
	        employeeService.deleteEmployeeById(id);
	        return "redirect:/employees";
	    }
	}


