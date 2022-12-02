package com.capstone.ems.controller;

import com.capstone.ems.common.EmsUtil;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.Salary;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;
import com.capstone.ems.service.SalaryService;
import com.capstone.ems.service.SalaryServiceImpl;

public class SalaryController {

	SalaryService salaryService=new SalaryServiceImpl();
	EmsUtil emsUtil=new EmsUtil();
	public Salary addSalaryDetails(Salary salary) {

		try {

			if(salary.getEmp_id()==0 ||salary.getHRA_percentage()==0 || salary.getDA_percentage()==0)
				throw new EmsException("Mandatory fields", ErrorCode.SALARY_REQUIRED_FIELDS);		
			
			salary.setHRA(emsUtil.calulate_HRA(salary.getHRA_percentage(), salary.getBASIC()));
			salary.setDA(emsUtil.calulate_DA(salary.getDA_percentage(), salary.getBASIC()));
			salary.setGross_salary(emsUtil.calculate_gross(salary.getHRA(),salary.getDA(),salary.getBASIC()));
			salary.setIncometax(emsUtil.calculate_it(salary.getIt_percentage(), salary.getGross_salary()));
		    salary.setNetsalary(emsUtil.calculate_net(salary.getGross_salary(),salary.getIncometax()));
			salaryService.addSalaryDetails(salary);
		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		salary.setBacktoMenu(true);	
		return salary;
	}
	
	public Salary editSalaryDetails(Salary salary) {

		try {	
			salary.setHRA(emsUtil.calulate_HRA(salary.getHRA_percentage(), salary.getBASIC()));
			salary.setDA(emsUtil.calulate_DA(salary.getDA_percentage(), salary.getBASIC()));
			salary.setGross_salary(emsUtil.calculate_gross(salary.getHRA(),salary.getDA(),salary.getBASIC()));
			salary.setIncometax(emsUtil.calculate_it(salary.getIt_percentage(), salary.getGross_salary()));
		    salary.setNetsalary(emsUtil.calculate_net(salary.getGross_salary(),salary.getIncometax()));
			salaryService.editSalaryDetails(salary);
		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return salary;
	}
	
	public Employee generatePaySlip(Salary salary) {
		Employee employee=new Employee();
		try {	
			employee=salaryService.generatePaySlip(salary.getEmp_id(),salary.getNo_of_days());
		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

}
