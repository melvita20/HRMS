package com.capstone.ems.controller;

import java.util.Scanner;

import com.capstone.ems.domain.UserLogin;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;
import com.capstone.ems.ui.DepartmentUIMock;
import com.capstone.ems.ui.EmployeeUIMock;
import com.capstone.ems.ui.PayrollUIMock;

public class AdminOperatoinsController {

	public void adminOperations(int choice) {
		Scanner sc= new Scanner(System.in);
		try {
			switch (choice) {
			case 1: {
				System.out.println("Please Select any opeation to perform on Employee:");
				System.out.println("1. Add New Employee");
				System.out.println("2. Edit Employee");
				System.out.println("3. Delete Employee");
				System.out.println("4. View All Employees");
				System.out.println("5. Back to Main Menu");
				EmployeeUIMock employeeUIMock = new EmployeeUIMock();
				employeeUIMock.employeeOperations(sc.nextInt());
				break;
			}
			case 2:{
				System.out.println("Please Select any opeation to peform:");
				System.out.println("1. Add New Department");
				System.out.println("2. Edit Department");
				System.out.println("3. Delete Department");
				System.out.println("4. View All Departments");
				System.out.println("5. Back to Main Menu");
				DepartmentUIMock deptMockup = new DepartmentUIMock();
				deptMockup.departmentOperations(sc.nextInt());
				break;
			}
			case 3: {
				System.out.println("Please Select any opeation to peform:");
				System.out.println("1. Add Payroll details for Employee");
				System.out.println("2. Edit Payroll Details");
				System.out.println("3. Generate Pay Slip");
				System.out.println("4. Back to Main Menu");
				PayrollUIMock payrollUIMock=new PayrollUIMock();
				payrollUIMock.payrollOperations(sc.nextInt());
				break;
			}
			case 4: {
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
}
