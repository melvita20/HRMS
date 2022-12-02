package com.capstone.ems.ui;

import java.util.Optional;
import java.util.Scanner;

import com.capstone.ems.constants.Constants;
import com.capstone.ems.controller.AdminOperatoinsController;
import com.capstone.ems.controller.EmployeeController;
import com.capstone.ems.domain.Employee;

public class EmployeeUIMock {

	public void employeeOperations(int choice) {

		Scanner sc= new Scanner(System.in);
		Employee employee = new Employee();
		EmployeeController employeeController = new EmployeeController();
		AdminOperatoinsController adminOperatoinsController = new AdminOperatoinsController();		

		switch(choice) {
		case 1:
		{
			System.out.println("Enter Employee ID:");
			employee.setEmpId(sc.nextInt());
			System.out.println("Enter Employee first name:");
			employee.setFname(sc.next());
			System.out.println("Enter Employee middle name:");
			employee.setMname(sc.next());
			System.out.println("Enter Employee last name:");
			employee.setLname(sc.next());
			System.out.println("Enter Gender:");
			employee.setGender(sc.next());
			System.out.println("Enter Employee email:");
			employee.setEmail(sc.next());
			System.out.println("Enter DOB (DD-MM-YYYY):");
			employee.setDOB(sc.next());
			System.out.println("Enter home address line1");
			employee.setHomeaddress_line1(sc.next());
			System.out.println("Enter home address line2");
			employee.setHomeaddress_line2(sc.next());
			System.out.println("Enter Employee house street:");
			employee.setHomeaddress_street(sc.next());
			System.out.println("Enter city:");
			employee.setHomeaddress_city(sc.next());
			System.out.println("Enter state::");
			employee.setHomeaddress_state(sc.next());
			System.out.println("Enter zip code :");
			employee.setZip(sc.next());
			System.out.println("Enter Employee designation:");
			employee.setDesignation(sc.next());
			System.out.println("Enter Employee Role ID (1 or 2) :");
			employee.setRole(sc.nextInt());
			System.out.println("Enter Employee Department ID:");
			employee.setDepartment_id(sc.nextInt());
			System.out.println("Enter Employee contact number:");
			employee.setPhonenumber(sc.next());
			System.out.println("Enter Employee work location:");
			employee.setWork_location(sc.next());
			System.out.println("Enter Employee hire date (DD-MM-YYYY):");
			employee.setHire_date(sc.next());
			employee= employeeController.addEmployee(employee);
			if(employee.getReturn_status()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				employeeOperations(sc.nextInt());
			}
			break;
		}
		case 2:{
			System.out.println("Enter Employee ID whose details are to be edited:");
			employee.setEmpId(sc.nextInt());
			// can make improvement like to check if the employee is already present and if present then continue with update details
			System.out.println("Enter Employee first name:");
			employee.setFname(sc.next());
			System.out.println("Enter Employee middle name:");
			employee.setMname(sc.next());
			System.out.println("Enter Employee last name:");
			employee.setLname(sc.next());
			System.out.println("Enter Gender:");
			employee.setGender(sc.next());
			System.out.println("Enter Employee email:");
			employee.setEmail(sc.next());
			System.out.println("Enter DOB (DD-MM-YYYY):");
			employee.setDOB(sc.next());
			System.out.println("Enter home address line1");
			employee.setHomeaddress_line1(sc.next());
			System.out.println("Enter home address line2");
			employee.setHomeaddress_line2(sc.next());
			System.out.println("Enter Employee hous2 street:");
			employee.setHomeaddress_street(sc.next());
			System.out.println("Enter city:");
			employee.setHomeaddress_city(sc.next());
			System.out.println("Enter state::");
			employee.setHomeaddress_state(sc.next());
			System.out.println("Enter zip code :");
			employee.setZip(sc.next());
			System.out.println("Enter Employee designation:");
			employee.setDesignation(sc.next());
			System.out.println("Enter Employee Role ID (1 or 2) :");
			employee.setRole(sc.nextInt());
			System.out.println("Enter Employee Department ID:");
			employee.setDepartment_id(sc.nextInt());
			System.out.println("Enter Employee contact number:");
			employee.setPhonenumber(sc.next());
			System.out.println("Enter Employee work location:");
			employee.setWork_location(sc.next());
			System.out.println("Enter Employee hire date (DD-MM-YYYY):");
			employee.setHire_date(sc.next());
			employee= employeeController.addEmployee(employee);
	
			employee= employeeController.editEmployee(employee);
			if(employee.getReturn_status()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				employeeOperations(sc.nextInt());
			}
			break;
		}
		case 3:{
			System.out.println("Enter Employee ID whose details are to be deleted:");
			employee.setEmpId(sc.nextInt());
			employee=employeeController.deleteEmployee(employee);
			Optional.ofNullable(employee.getEmployee_status()).ifPresentOrElse((e) 	->  
			{ 
				if(e.equalsIgnoreCase(Constants.STATUS_DEACTIVATED)) {
					System.out.println("Employee is deleted. ");
				}
			},
			()->{System.out.println("Incorrect employee id"); });

			if(employee.getReturn_status()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				employeeOperations(sc.nextInt());
			}					
			break;
		}
		case 4:{
			employee=employeeController.viewAllEmployees(employee);
			if(employee.getReturn_status()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				employeeOperations(sc.nextInt());
			}
			break;
		}
		case 5:{
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
		str.append("1. Add New Employee"+"\n");
		str.append("2. Edit Employee"+"\n");
		str.append("3. Delete Employee"+"\n");
		str.append("4. View All Employees"+"\n");
		str.append("5. Back to Main Menu"+"\n");

		System.out.println(str.toString());
	}
}
