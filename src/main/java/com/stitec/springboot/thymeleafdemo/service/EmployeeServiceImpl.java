package com.stitec.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stitec.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.stitec.springboot.thymeleafdemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	
	//injection /constructeur
	@Autowired
	public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	
	

	public List<Employee> findAll() {
	
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee  = result.get();
			
		}else {
			throw new RuntimeException(" Did not find  Employee id - " + theId);
		}
		
		return theEmployee;
	}

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
