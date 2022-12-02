package com.capstone.ems.service;

import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.Salary;
import com.capstone.ems.exception.EmsException;

public interface SalaryService {
	public Salary addSalaryDetails(Salary salary) throws EmsException;
	public Salary editSalaryDetails(Salary salary) throws EmsException;
	public Employee generatePaySlip(int emp_id, int no_of_days) throws EmsException; 

}
