package com.stitec.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stitec.springboot.thymeleafdemo.entity.Employee;
import com.stitec.springboot.thymeleafdemo.service.EmployeeService;


@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
    public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
		
	}
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
					
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAadd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	
	
}
