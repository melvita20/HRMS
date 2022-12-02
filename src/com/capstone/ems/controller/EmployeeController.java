package com.capstone.ems.controller;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capstone.ems.constants.Constants;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.Salary;
import com.capstone.ems.domain.UserLogin;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;
import com.capstone.ems.service.EmployeeService;
import com.capstone.ems.service.EmployeeServiceImpl;
import com.capstone.ems.ui.DepartmentUIMock;
import com.capstone.ems.ui.EmployeeUIMock;
import com.capstone.ems.ui.PayrollUIMock;

public class EmployeeController {

	EmployeeService employeeService= new EmployeeServiceImpl();
	SalaryController salaryController=new SalaryController();

	public Employee addEmployee(Employee employee) {
		try {
			Pattern pattern;
			Matcher matcher;
			/* 
			 * things to be done
			 * use validation check for fields which are not null in DB and use optionals for fields which can be null in DB
			 * */			
			if(employee.getFname().isBlank() ||employee.getGender().isBlank() || employee.getDOB().isBlank() || employee.getEmail().isBlank() || employee.getPhonenumber().isBlank()
					|| employee.getHire_date().isBlank() || employee.getDepartment_id()==0 || employee.getHomeaddress_line1().isBlank() || employee.getHomeaddress_city().isBlank()
					|| employee.getDesignation().isBlank() || employee.getRole()==0 || employee.getWork_location().isBlank() || employee.getZip().isBlank()) 
				throw new EmsException("Required fields", ErrorCode.REQUIRED_FIELDS);

			//			pattern=Pattern.compile(Constants.valid_email);
			//			matcher = pattern.matcher(employee.getEmail());			
			//			if (matcher.matches( ) == true)
			//				throw new EmsException(ErrorCode.INVALID_EMAIL_FORMAT);

			//			pattern=Pattern.compile(Constants.valid_phonenumber_regex);
			//			matcher = pattern.matcher(employee.getPhonenumber());
			//
			//			if (matcher.matches( ) == true)
			//				throw new EmsException(ErrorCode.INVALID_PHONENUMBER_FORMAT);

			employee= employeeService.addEmpolyee(employee);

		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

	public Employee  viewAllEmployees(Employee employee) {
		try {
			List<Employee> employees= employeeService.listAllEmployees();
			System.out.println("List of Employees::");
			employees.forEach(i -> {System.out.println(i.toString());});
			employee.setReturn_status(true);
		} catch (EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

	public Employee  deleteEmployee(Employee employee) {
		try {
			employee= employeeService.deleteEmployee(employee.getEmpId());
		} catch (EmsException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

	public Employee editEmployee(Employee employee) {
		try {
			employee= employeeService.editEmpolyee(employee);
		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

	public Employee  findEmployee(Employee employee) {
		try {
			employee= employeeService.findEmployee(employee.getEmpId());
		} catch (EmsException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return employee;
	}

	public void employeeOperations(int choice, String loginid) {
		Scanner sc= new Scanner(System.in);
		try {
			switch (choice) {
			case 1: {
				Employee employee=new Employee();
				employee.setEmpId(Integer.parseInt(loginid));
				employee = employeeService.fetchEmpDetail(employee.getEmpId());
				StringBuilder str = new StringBuilder();
				str.delete(0,str.length());
				str.append("Welcome "+employee.getFname()+ " "+employee.getLname()+"\n");
				str.append("House Address:"+employee.getHomeaddress_line1()+" "+employee.getHomeaddress_line2()+" "+employee.getHomeaddress_street()+" "+employee.getHomeaddress_city()+"\n");
				str.append("Contact Number:"+employee.getPhonenumber()+"\n");
				str.append("Date of Birth:"+employee.getDOB()+"\n");
				System.out.println(str.toString());
				menuOptions();
				System.out.println("Enter your input:");
				employeeOperations(sc.nextInt(),loginid);
				break;
			}
			case 2:{
				Employee employee=new Employee();
				Salary salary=new Salary();
				salary.setEmp_id(Integer.parseInt(loginid));
				employee=	salaryController.generatePaySlip(salary);
				System.out.println("****Payment Receipt For Employee::"+employee.getEmpId()+"****");
				System.out.println("Name:"+employee.getFname()+" "+employee.getLname());
				List<Salary> sal = employee.getSalary();
				for (Salary sal_item : sal) {
					System.out.println("Basic Salry:"+sal_item.getBASIC());
					System.out.println("DA:"+sal_item.getDA());
					System.out.println("HRA:"+sal_item.getHRA());
					System.out.println("Gross Salry:"+sal_item.getGross_salary());
					System.out.println("Income tax:"+sal_item.getIncometax());
					System.out.println("Net Salry:"+sal_item.getNetsalary());
				}
				menuOptions();
				System.out.println("Enter your input:");
				employeeOperations(sc.nextInt(),loginid);
				break;
			}
			case 3: {
				System.out.println("Logged out succcessfully!!");
				UserLogin userLogin = new UserLogin();
				userLogin = null;
				break;
			}
			default:
				System.out.println("Sorry Invalid Input !!!");
				//Modify later
				throw new EmsException(ErrorCode.INVALID_CHOICE);
			}
		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}finally {
			sc.close();
		}
	}
	public void menuOptions() {
		StringBuilder str = new StringBuilder();
		str.delete(0,str.length());
		str.append("\n"+"Please select next action"+"\n");
		str.append("1. View Details"+"\n");
		str.append("2. View Salary Slip"+"\n");
		str.append("3. Logout"+"\n");
		System.out.println(str.toString());
	}
}
