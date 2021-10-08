package com.springrest.springrest.daoimpl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.springrest.dao.EmployeesDAO;
import com.springrest.springrest.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeesDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override 
	public List<Employee> listEmployees() {
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		String sql = "select * from Employees where isDeleted=0";
		
		List<Employee> employes = jdbcTemplate.query(sql, rowMapper);

		return employes;
	}


	@Override
	public Long addEmployee(Employee employee) {

		String INSERT_SQL = "INSERT INTO Employees(employee_name, gender, date_of_joining, designation,ctc,esi,pf,tax) values(?,?,?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection -> {
			
			PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, employee.getEmployee_name());
			ps.setString(2, employee.getGender());
			ps.setString(3, employee.getDate_of_joining());
			ps.setString(4, employee.getDesignation());
			ps.setDouble(5, employee.getCtc());
			ps.setDouble(6, employee.getEsi());
			ps.setDouble(7, employee.getPf());
			ps.setDouble(8, employee.getTax());
			
			return ps;
					
		}, keyHolder);
		
		return keyHolder.getKey().longValue();
	}


	@Override
	public Long updateEmployee(Employee employee, Integer id) {
		
		long result = 0;
		
		String sqlUpdate = "UPDATE Employees SET employee_name = ?, gender = ?, designation = ?, ctc = ?, esi = ?, pf = ?, tax = ? WHERE id = ?";
		
		result = jdbcTemplate.update(sqlUpdate,employee.getEmployee_name(),employee.getGender(),employee.getDesignation(),employee.getCtc(),employee.getEsi(),employee.getPf(),employee.getTax(),employee.getId());
		
		return result;
	}
	

	@Override
	public Long deleteFlag(Integer id) {
		
		long result = 0 ;

		String sqlDeleteFlag = "UPDATE Employees SET isDeleted = 1 WHERE id = ?";
		
		result= jdbcTemplate.update(sqlDeleteFlag, id);
		
		return result;
	}

	
	@Override
	public int[] batchDeleteFlag(List<Integer> ids) {
		
		System.out.println("ids_value"+ids);

		String sql = "update Employees set isDeleted = 1 where id = ?";
		
		int[] argTypes = {Types.INTEGER };
		
		List<Object[]> batchArgs = new ArrayList<>();
		
		ids.forEach(id -> batchArgs.add(new Object[] {id}));
		
		int[] updateCounts = jdbcTemplate.batchUpdate(sql, batchArgs,argTypes);
		
		return updateCounts;
	}


	@Override
	public Employee singleEmployee(Integer id) {
		
		 String sql = "SELECT id,employee_name,gender,date_of_joining,designation,ctc FROM Employees WHERE ID = ? and isDeleted=0";
		 
		 Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), new Object[] {id});
		 
		 return employee;
		 
	}

}
