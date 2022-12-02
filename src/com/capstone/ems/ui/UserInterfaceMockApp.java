package com.capstone.ems.ui;

import java.util.Scanner;

import com.capstone.ems.controller.AdminOperatoinsController;
import com.capstone.ems.controller.EmployeeController;
import com.capstone.ems.controller.LoginController;
import com.capstone.ems.domain.UserLogin;

public class UserInterfaceMockApp {
	static LoginController loginController = new LoginController();
	AdminOperatoinsController adminOperatoinsController = new AdminOperatoinsController();		
	static Scanner sc= new Scanner(System.in);
	public static StringBuilder str = new StringBuilder();
   EmployeeController employeeController=new EmployeeController();

	public void fnDisplayAdminMenu(UserLogin userLogin) {
		userLogin.setRole_id(0);
		str.delete(0,str.length());
		str.append("Welcome Admin: "+userLogin.getUser_name()+".  Please Select the options to Continue!"+"\n");
		str.append("1.Manage Employee"+"\n");
		str.append("2.Manage Department"+"\n");
		str.append("3.Manage Payroll"+"\n");
		str.append("4.Logout"+"\n");
		System.out.println(str.toString());
		System.out.println("Enter your input:");
		adminOperatoinsController.adminOperations(sc.nextInt());
	}

	public void fnDisplayUserMenu(UserLogin userLogin) {
		userLogin.setRole_id(0);
		str.delete(0,str.length());
		str.append("Welcome User: "+userLogin.getUser_name()+". Please Select the options to Continue!"+"\n");
		str.append("1.View Details"+"\n");
		str.append("2.View Salary Slip"+"\n");
		str.append("3.Logout"+"\n");
		System.out.println(str.toString());
		System.out.println("Enter your input:");
		employeeController.employeeOperations(sc.nextInt(), userLogin.getUser_name());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserLogin userLogin = new UserLogin();
		do {
			str.delete(0,str.length());
			if(userLogin.getTotalAttempts()!=3) {
				str.append("Welcome To Employee Management System.");
				str.append("Please Login to Continue.");
				System.out.println(str.toString());
				System.out.println("Enter User Name: ");
				userLogin.setUser_id(sc.next());
				System.out.println("Enter Password: ");
				userLogin.setPassword(sc.next());
				userLogin = loginController.validateLogin(userLogin);
			}else {
				System.out.println("Your account is locked. You have entered wrong credentials 3 times. Please Try after sometime. ");
				userLogin.setTotalAttempts(0);
				break;
			}
		}while(userLogin.getTotalAttempts()!=0);
		
		UserInterfaceMockApp userInterfaceMockApp = new UserInterfaceMockApp();
		if(userLogin.getRole_id()==1) {
			userInterfaceMockApp.fnDisplayAdminMenu(userLogin);
		}else if(userLogin.getRole_id() == 2) {
			userInterfaceMockApp.fnDisplayUserMenu(userLogin);
		}
	}
}
