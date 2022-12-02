package com.capstone.ems.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.capstone.ems.constants.Constants;
import com.capstone.ems.controller.AdminOperatoinsController;
import com.capstone.ems.controller.EmployeeController;
import com.capstone.ems.controller.SalaryController;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.Salary;


public class PayrollUIMock {

	public void payrollOperations(int choice) {

		Scanner sc= new Scanner(System.in);
		Salary salary=new Salary();
		EmployeeController employeeController=new EmployeeController();
		Employee employee=new Employee();
		AdminOperatoinsController adminOperatoinsController=new AdminOperatoinsController();
		SalaryController salaryController=new SalaryController();

		switch(choice) {
		case 1:
		{
			System.out.println("Enter Employee ID:");
			salary.setEmp_id(sc.nextInt());
			employee.setEmpId(salary.getEmp_id());
			employee=employeeController.findEmployee(employee);

			if(employee.getReturn_status()) {
				System.out.println("Enter Basic Salary:");
				salary.setBASIC(sc.nextDouble());
				System.out.println("Enter HRA  Percentage:");
				salary.setHRA_percentage(sc.nextInt());
				System.out.println("Enter DA  Percentage:");
				salary.setDA_percentage(sc.nextInt());
				System.out.println("Enter Income Tax Percentage:");
				salary.setIt_percentage(sc.nextFloat());
				salaryController.addSalaryDetails(salary);
			}else {
				System.out.println("Employee records not present");
				salary.setBacktoMenu(true);	
			}

			if(salary.getBacktoMenu()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				payrollOperations(sc.nextInt());
			}
			break;
		}
		case 2:{
			System.out.println("Enter Employee ID:");
			salary.setEmp_id(sc.nextInt());
			employee.setEmpId(salary.getEmp_id());
			employee=employeeController.findEmployee(employee);

			if(employee.getReturn_status()) {
				System.out.println("Enter Basic Salary:");
				salary.setBASIC(sc.nextDouble());
				System.out.println("Enter HRA  Percentage:");
				salary.setHRA_percentage(sc.nextInt());
				System.out.println("Enter DA  Percentage:");
				salary.setDA_percentage(sc.nextInt());
				System.out.println("Enter Income Tax Percentage:");
				salary.setIt_percentage(sc.nextFloat());
				salaryController.editSalaryDetails(salary);
			}else {
				System.out.println("Employee records not present");
				salary.setBacktoMenu(true);	
			}

			if(salary.getBacktoMenu()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				payrollOperations(sc.nextInt());
			}

			break;
		}
		case 3:{
			System.out.println("Enter Employee ID:");
			salary.setEmp_id(sc.nextInt());
			employee.setEmpId(salary.getEmp_id());
			employee=employeeController.findEmployee(employee);

			if(employee.getReturn_status()) {
				System.out.println("Enter Number of Days worked:");
				salary.setNo_of_days(sc.nextInt());
				employee=	salaryController.generatePaySlip(salary);
				salary.setBacktoMenu(true);	
				System.out.println("****Payment Receipt For Employee::"+employee.getEmpId()+"****");
				System.out.println("Name:"+employee.getFname()+" "+employee.getLname());
				List<Salary> sal = employee.getSalary();
				Optional.ofNullable(employee.getSalary()).ifPresentOrElse((e) 	->  
				{ 
					for (Salary sal_item : e) {
						System.out.println("Basic Salry:"+sal_item.getBASIC());
						System.out.println("DA:"+sal_item.getDA());
						System.out.println("HRA:"+sal_item.getHRA());
						System.out.println("Gross Salry:"+sal_item.getGross_salary());
						System.out.println("Income tax:"+sal_item.getIncometax());
						System.out.println("Net Salry:"+sal_item.getNetsalary());
					}
				},
				()->{System.out.println("Record not present"); });

				
				
				
			}else {
				System.out.println("Employee records not present");
				salary.setBacktoMenu(true);	
			}
			if(salary.getBacktoMenu()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				payrollOperations(sc.nextInt());
			}
			break;
		}
		case 4:{
			StringBuilder str = new StringBuilder();
			str.delete(0,str.length());
			str.append("Please Select the options to Continue!"+"\n");
			str.append("1.Manage Employee"+"\n");
			str.append("2.Manage Department"+"\n");
			str.append("3.Manage Payroll"+"\n");
			str.append("4.Logout"+"\n");
			System.out.println(str.toString());
			System.out.println("Enter your input:");
			adminOperatoinsController.adminOperations(sc.nextInt());
			break;
		}
		default:break;

		}
	}
	public void menuOptions() {
		StringBuilder str = new StringBuilder();
		str.delete(0,str.length());
		str.append("1. Add Payroll details for Employee"+"\n");
		str.append("2. Edit Payroll Details"+"\n");
		str.append("3. Generate Pay Slip"+"\n");
		str.append("4. Back to Main Menu"+"\n");

		System.out.println(str.toString());
	}
}
