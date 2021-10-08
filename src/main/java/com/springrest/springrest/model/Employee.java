package com.springrest.springrest.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Employee {
	
	private String id;
	
	@NotNull(message = "Employee name cannot be null or empty") 
	@NotEmpty(message = "Employee name cannot be null or empty") 
	@Length(max = 30 , message="Employee name can not be longer than 30 charecters.")
	private String employee_name;
	
	@com.springrest.springrest.validators.Employee
	@NotNull (message = "Please select a gender 'm', 'f' or 'o'")
	@NotEmpty (message = "Please select a gender 'm', 'f' or 'o'")
	@Length(max = 1 )
	private String gender;
	
	@NotNull (message = "Please select a date") 
	private String date_of_joining;
	
	@NotNull  (message = "Please select a designation")
	@NotEmpty (message = "Please select a designation")
	@Length(max = 30 )
	private String designation;
	
	@NotNull  (message = "CTC can not be null or empty")
	@Digits(integer = 15,  fraction=2)
	private Double ctc;
	
	@NotNull  (message = "ESI can not be null or empty")
	@Digits(integer = 15,  fraction=2)
	private Double esi;
	
	@NotNull  (message = "PF can not be null or empty")
	@Digits(integer=15, fraction=2)
	private Double pf;
	
	@NotNull (message = "TAX can not be null or empty")
	@Digits(integer=15, fraction=2)
	private Double tax;
	

	
	private String created_data_and_time;
	
	
	private String updated_date_and_time;
	
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDate_of_joining() {
		return date_of_joining;
	}
	
	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

	
	public Double getCtc() {
		return ctc;
	}
	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}
	public Double getEsi() {
		return esi;
	}
	
	public void setEsi(Double esi) {
		this.esi = esi;
	}
	
	public Double getPf() {
		return pf;
	}
	
	public void setPf(Double pf) {
		this.pf = pf;
	}
	
	public Double getTax() {
		return tax;
	}
	
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public String getCreated_data_and_time() {
		return created_data_and_time;
	}
	
	public void setCreated_data_and_time(String created_data_and_time) {
		this.created_data_and_time = created_data_and_time;
	}
	
	public String getUpdated_date_and_time() {
		return updated_date_and_time;
	}

	public void setUpdated_date_and_time(String updated_date_and_time) {
		this.updated_date_and_time = updated_date_and_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	
	
	


	
	
	
	
}
