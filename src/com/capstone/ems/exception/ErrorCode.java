package com.capstone.ems.exception;

public class ErrorCode {

	public final static String USERNAME_NULL="Username and Password is Mandatory.";
	public final static String PASSWORD_INVALID="Password must be alpha-numeric with 8 characters and a special character.";
	public final static String INVALID_CREDENTIALS="Invalid Credentials. Please Check user name and password and try again.";
	public final static String INVALID_CHOICE="The option you selected in invalid";
	public final static String REQUIRED_FIELDS="Emloyee First name, email, designation, phone number, roleid, department id are the mandatory fields";
	public final static String MXIMUM_LOGIN_ATTEMPT_REACHED="Maximum number of attempts exceeded.";
	public static final String INVALID_EMAIL_FORMAT="Please enter valid email address.";
	public static final String INVALID_PHONENUMBER_FORMAT="Please enter valid phone number.";
	public static final String UNKNOWN_ERROR="DB Unknown Error";
	public static final String LOAD_DRIVER_ERROR="Driver not loaded";
	public static final String SQL_INSERT_ERROR="Error while adding data to table";
	public static final String SQL_UNKNOWN_ERROR="DB Unknown Error";
	public final static String DEPARTMENT_REQUIRED_FIELDS="Department id, name and location are the mandatory fields";
	public final static String SALARY_REQUIRED_FIELDS="EmployeeId, HRA and DA % are the mandatory fields";

	



	
}
