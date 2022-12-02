package com.capstone.ems.dao;

import java.util.List;

import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.UserLogin;
import com.capstone.ems.exception.EmsException;


public interface EmployeeDetailsDao {
	public UserLogin validateLogin(UserLogin userLogin) throws EmsException;
	public Employee addNewEmployee(Employee employee) throws EmsException;
	List<Employee> listAllEmployees() throws EmsException;
	public Employee  deleteEmployee(int emloyee_id) throws EmsException;
	public Employee editNewEmployee(Employee employee) throws EmsException;
	public Employee findEmployee(int employee_id) throws EmsException;
	public Employee fetchEmpDetail(int employee_id) throws EmsException;

}
