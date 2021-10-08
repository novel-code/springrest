package com.springrest.springrest.services;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.springrest.springrest.dao.EmployeesDAO;
import com.springrest.springrest.model.Employee;

@Service
public class EmployeeService {
	

	@Autowired
	EmployeesDAO employeesDAO;
	
	
	public List<Employee> listEmployees() {
		
		List<Employee> employees =employeesDAO.listEmployees();
		
		return employees;
	}
	
	public Long addEmployee(Employee employee) {
		
		Long addedEmployee = employeesDAO.addEmployee(employee);
			
		return addedEmployee;
		
	}	

	public Long updateEmployee(Employee employee, Integer id) {
		
		Long updatedEmployee = employeesDAO.updateEmployee(employee, id);
		
		return updatedEmployee;
	}

	public Long deleteFlag( Integer id) {

		Long deleteFlagEmpId = employeesDAO.deleteFlag(id);

		return deleteFlagEmpId;
	}

	public int[] batchDeleteFlag(List<Integer> ids) {
		
		int[] multiDeleteFlags = employeesDAO.batchDeleteFlag(ids);
		
		return multiDeleteFlags;
		
	}

	public Employee singleEmployee( Integer id) {
		
		Employee employee =employeesDAO.singleEmployee(id);
		
		return employee;
	}
}
