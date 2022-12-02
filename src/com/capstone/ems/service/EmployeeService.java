package com.capstone.ems.service;

import java.util.List;

import com.capstone.ems.domain.Employee;
import com.capstone.ems.exception.EmsException;


public interface EmployeeService {
	
	public Employee addEmpolyee(Employee employee) throws EmsException;
	public List<Employee> listAllEmployees() throws EmsException;
	public Employee deleteEmployee(int employee_id) throws EmsException;
	public Employee editEmpolyee(Employee employee) throws EmsException;
	public Employee findEmployee(int employee_id) throws EmsException;
	public Employee fetchEmpDetail(int employee_id) throws EmsException;

}
