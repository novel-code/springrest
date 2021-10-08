package com.springrest.springrest.dao;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.RequestParam;

import com.springrest.springrest.model.Employee;


public interface EmployeesDAO {

	List<Employee> listEmployees();	
	
	Long addEmployee(Employee employee);
	
	int[] batchDeleteFlag(List<Integer> ids);
	
	Long updateEmployee(Employee employee, Integer id);

	Long deleteFlag(@Size(min = 1) Integer id);

	Employee singleEmployee(Integer id);

	
}
