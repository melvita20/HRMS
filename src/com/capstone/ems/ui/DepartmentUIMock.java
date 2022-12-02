package com.capstone.ems.ui;

import java.util.Optional;
import java.util.Scanner;

import com.capstone.ems.constants.Constants;
import com.capstone.ems.controller.AdminOperatoinsController;
import com.capstone.ems.controller.DepartmentControler;
import com.capstone.ems.controller.EmployeeController;
import com.capstone.ems.domain.Department;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;

public class DepartmentUIMock {

	public void departmentOperations(int choice) {

		Scanner sc= new Scanner(System.in);
		Department dept=new Department();
		DepartmentControler departmentControler=new DepartmentControler();
		AdminOperatoinsController adminOperatoinsController=new AdminOperatoinsController();

		switch(choice) {
		case 1:
		{
			System.out.println("Enter Department ID:");
			dept.setDepartment_id(sc.nextInt());
			System.out.println("Enter Department name:");
			dept.setDep_name(sc.next());
			System.out.println("Enter Department Location:");
			dept.setDep_location(sc.next());			
			dept= departmentControler.addDepartment(dept);
			if(dept.getBacktoMenu()) {				
				System.out.println("Department is added succesfully. Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				departmentOperations(sc.nextInt());
			}
			break;
		}
		case 2:{
			System.out.println("Enter Department id to be edited:");
			dept.setDepartment_id(sc.nextInt());
			// can make improvement like to check if the employee is already present and if present then continue with update details
			System.out.println("Enter Department name:");
			dept.setDep_name(sc.next());
			System.out.println("Enter Department Location:");
			dept.setDep_location(sc.next());	
			dept= departmentControler.editDepartment(dept);
			if(dept.getBacktoMenu()) {				
				System.out.println("Department is edited succesfully. Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				departmentOperations(sc.nextInt());
			}
			break;
		}
		case 3:{
			System.out.println("Enter department id to be deleted:");
			dept.setDepartment_id(sc.nextInt());
			dept=departmentControler.deleteDepartment(dept);
			Optional.ofNullable(dept.getStatus()).ifPresentOrElse((e) 	->  
			{ 
				if(e.equalsIgnoreCase(Constants.STATUS_DEACTIVATED)) {
					System.out.println("Department is deleted. ");
				}
			},
			()->{System.out.println("Incorrect department id"); });

			if(dept.getBacktoMenu()) {				
				System.out.println("Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				departmentOperations(sc.nextInt());
			}					
			break;
		}
		case 4:{
			departmentControler.listAllDepartments(dept);
			if(dept.getBacktoMenu()) {				
				System.out.println(" Please select the next action to perform!!  Press any Key to view the option:: ");
				menuOptions();
				departmentOperations(sc.nextInt());
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

		default:{
			System.out.println("Sorry Invalid Input !!!");
			//Modify later
		};
		}
	}

public void menuOptions() {
	StringBuilder str = new StringBuilder();
	str.delete(0,str.length());
	str.append("1. Add New Department"+"\n");
	str.append("2. Edit Department"+"\n");
	str.append("3. Delete Department"+"\n");
	str.append("4. View All Departments"+"\n");
	str.append("5. Back to Main Menu"+"\n");

	System.out.println(str.toString());
}
}
