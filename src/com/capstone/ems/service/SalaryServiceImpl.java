package com.capstone.ems.service;

import com.capstone.ems.dao.SalaryDao;
import com.capstone.ems.dao.SalaryDaoImpl;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.Salary;
import com.capstone.ems.exception.EmsException;

public class SalaryServiceImpl implements SalaryService{

	SalaryDao salDao=new SalaryDaoImpl();

	@Override
	public Salary addSalaryDetails(Salary salary) throws EmsException {
		try {
			salary= salDao.addSalaryDetails(salary);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return salary;
	}

	@Override
	public Salary editSalaryDetails(Salary salary) throws EmsException {
		try {
			salary= salDao.editSalaryDetails(salary);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return salary;
	}

	@Override
	public Employee generatePaySlip(int emp_id, int no_of_days) throws EmsException {
		Employee employee= new Employee();
		try {
			employee= salDao.generatePaySlip(emp_id,no_of_days);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();	
		}
		return employee;
	}
}
