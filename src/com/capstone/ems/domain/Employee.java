package com.capstone.ems.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Employee extends Person{
	
	private int empId;
	private String designation;
	private String phonenumber;
	private String hire_date;
	private int role;
	private int department_id;
	private String work_location;
	private LocalDate added_on;
	private LocalDate modified_on;
	private String employee_status;

    private  List<Salary> salary; 
/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the hire_date
	 */
	public String getHire_date() {
		return hire_date;
	}
	/**
	 * @param hire_date the hire_date to set
	 */
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * @return the department_id
	 */
	public int getDepartment_id() {
		return department_id;
	}
	/**
	 * @param department_id the department_id to set
	 */
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	/**
	 * @return the work_location
	 */
	public String getWork_location() {
		return work_location;
	}
	/**
	 * @param work_location the work_location to set
	 */
	public void setWork_location(String work_location) {
		this.work_location = work_location;
	}
	/**
	 * @return the added_on
	 */
	public LocalDate getAdded_on() {
		return added_on;
	}
	/**
	 * @param added_on the added_on to set
	 */
	public void setAdded_on(LocalDate added_on) {
		this.added_on = added_on;
	}
	/**
	 * @return the modified_on
	 */
	public LocalDate getModified_on() {
		return modified_on;
	}
	/**
	 * @param modified_on the modified_on to set
	 */
	public void setModified_on(LocalDate modified_on) {
		this.modified_on = modified_on;
	}
	/**
	 * @return the employee_status
	 */
	public String getEmployee_status() {
		return employee_status;
	}
	/**
	 * @param employee_status the employee_status to set
	 */
	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}
	/**
	 * @return the salary
	 */
	public List<Salary> getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(List<Salary> salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		
		return super.toString()+"empId=" + empId + ", designation=" + designation + ", phonenumber=" + phonenumber
				+ ", hire_date=" + hire_date + ", role=" + role + ", department_id=" + department_id
				+ ", work_location=" + work_location + ", added_on=" + added_on + ", modified_on=" + modified_on
				+ ", employee_status=" + employee_status;
	}
	

	
	

}

