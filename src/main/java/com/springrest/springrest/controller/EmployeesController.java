package com.springrest.springrest.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import com.springrest.springrest.model.Employee;
import com.springrest.springrest.services.EmployeeService;

@RestController
@RequestMapping("/employee")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeesController {
	
	@Autowired
	EmployeeService employeeService;
//	EmployeeService employeeService2 = new EmployeeService();

// display all data in datatable
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getAll")
	public List<Employee> listEmployees()  {
		
		List<Employee> employees= employeeService.listEmployees();
		

			
		return employees;
	}
    
    
    @CrossOrigin(origins = "*", allowedHeaders ="*")
    @GetMapping("/single/{id}")
    public Employee singleEmployee(@PathVariable("id") @Size(min = 1) Integer id) {
    	
    	Employee employee = employeeService.singleEmployee(id);
    	
    	return employee;
    }
	
// add new data 
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/add")
	public ResponseEntity<Long> addEmployee(@Valid @RequestBody Employee employee) {
		
		
		
		Long addedEmployeeId = employeeService.addEmployee(employee);
		
		return new ResponseEntity<>(addedEmployeeId, HttpStatus.CREATED);
	}
    
//    delete single record (flag update) 
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/delete/flag/{id}")
    public String deleteFlag(@PathVariable("id") @Size(min = 1) Integer id) {
    	
    	System.out.println("the id to be flaged is:" + id);
    	
    	Long deleteFlagEmpId = employeeService.deleteFlag(id);
    	
    	return deleteFlagEmpId+"";
    }
    
    
// multi delete flag update
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/multiDelete/flag/{ids}")
    public String batchDeleteFlag(@PathVariable List<Integer> ids) {
    	
    	employeeService.batchDeleteFlag(ids);
    	
        return String.join(",", ids.stream().map(value ->  Integer.toString(value)).collect(Collectors.toList()));
    }
    
    
    
// update single record in db    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
    	
    	Long updatedEmployeeId = employeeService.updateEmployee(employee, id);
    	
    	
    	return new ResponseEntity<>(updatedEmployeeId, HttpStatus.OK);
//    	return null;
    }
	
    

	    
}
