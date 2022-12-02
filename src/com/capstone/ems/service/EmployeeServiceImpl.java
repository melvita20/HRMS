package com.capstone.ems.service;

import java.util.ArrayList;
import java.util.List;

import com.capstone.ems.dao.EmployeeDetailsDao;
import com.capstone.ems.dao.EmployeeDetailsDaoImpl;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.exception.EmsException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDetailsDao employeeDetailsDao = new EmployeeDetailsDaoImpl();

	@Override
	public Employee addEmpolyee(Employee employee) {
		try {
			employee= employeeDetailsDao.addNewEmployee(employee);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public List<Employee> listAllEmployees() throws EmsException {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			employees= employeeDetailsDao.listAllEmployees();
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee deleteEmployee(int employee_id) throws EmsException {
		Employee employee=new Employee();
		try {
			employee= employeeDetailsDao.deleteEmployee(employee_id);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public Employee editEmpolyee(Employee employee) throws EmsException {
		try {
			employee= employeeDetailsDao.editNewEmployee(employee);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public Employee findEmployee(int employee_id) throws EmsException {
		Employee employee=new Employee();
		try {
			employee= employeeDetailsDao.findEmployee(employee_id);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}
	@Override
	public Employee fetchEmpDetail(int employee_id) throws EmsException {
		Employee employee=new Employee();
		try {
			employee= employeeDetailsDao.fetchEmpDetail(employee_id);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

}
