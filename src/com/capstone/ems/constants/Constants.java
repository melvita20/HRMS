package com.capstone.ems.constants;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Constants {
	public static final String DB_URL="jdbc:mysql://localhost:3306/employee_management_system";
	public static final String DB_USERNAME="root";
	public static final String DB_PWD="Admin123";
	public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	public final static String valid_password_regex= "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
	public final static String valid_phonenumber_regex="(0/91)?[7-9][0-9]{9}";
	public final static String valid_email= "^(.+)@(.+)$";
	public final static String STATUS_CODE_SUCCESS="SUCCESS";
	public final static String STATUS_CODE_FAILURE="FAILURE";
	public final static String STATUS_ACTIVE="A";
	public final static String STATUS_DEACTIVATED="D";
    public final static LocalDateTime  localDateTime= LocalDateTime.now();
    public final static Timestamp CURR_DATE_TIME=Timestamp.valueOf(localDateTime);
    public final static String FIRST_DEFAULT_PASSWORD="Admin@123";

	
	//Queries

	public static final String SELECT_USER_LOGIN_DETAILS_QUERY="select * from user where username= ? and password= ?";
	
public static final String INSERT_NEW_USER= "insert into user (roleid,username,password,lastlogin) values (?,?,?,?)";

	public static final String INSERT_NEW_EMPLOYEE_QUERY="insert into employee (employee_id,first_name,middle_name,last_name,gender,email,dob,designation,role_id,phone_number,department_id,work_location,hire_date,emp_status,added_on,modified_on) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_EMP_ADDRESS_QUERY="insert into employee_address(employee_id,house_address_line1,house_address_line2,street,city,state,zip) values(?,?,?,?,?,?,?)";
	public static final String SQL_SELECT__ALL_EMPLOYEE = "select * from employee emp join employee_address ea on emp.employee_id=ea.employee_id where emp.EMP_STATUS=?";
	public static final String SQL_DELETE_EMPLOYEE= "update employee  set emp_status=? where employee_id = ? and emp_status !=?";
	public static final String UPDATE_EMPLOYEE_QUERY="update employee set first_name=?, middle_name=?,last_name=?, gender=?,email=?,dob=?,designation=?,role_id=?,phone_number=?,department_id=?,work_location=?,hire_date=?,modified_on=? where employee_id=? ";
	public static final String UPDATE_EMP_ADDRESS="update employee_address set house_address_line1=?,house_address_line2=?,street=?,city=?,state=?,zip=? where employee_id=?";
	public static final String FIND_EMPLOYEE	= "select * from employee where employee_id=? and emp_status=?";
	public static final String FETCH_EMPLOYEE_DETAIL	= "select * from employee e join employee_address ea on e.employee_id=ea.employee_id and e.employee_id=? and e.emp_status=?";

	public static final String INSERT_NEW_DEPT_QUERY="insert into department(id,dname,location,status) values(?,?,?,?)";
	public static final String SQL_SELECT__ALL_DEPARTMENT = "select * from department where status=?";
	public static final String SQL_DELETE_DEPARTMENT= "update department  set status=? where id = ? and status !=?";
	public static final String UPDATE_DEPARTMENT_QUERY="update department set dname=?, location=? where id=? and status !=?";

	
	public static final String INSERT_SALARY_DETAIL_QUERY="insert into salary(employee_id,basic_salary,hra_percent,hra,da_percent,da, gross_salary,it_percent,income_tax,net_salary,added_on,modified_on) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_SALARY_DETAIL_QUERY="update salary set basic_salary=?,hra_percent=?,hra=?,da_percent=?,da=?, gross_salary=?,it_percent=?,income_tax=?,net_salary=?,modified_on=? where employee_id=?";
	public static final String GENERATE_SALARY_DETAILS_QUERY = "select emp.employee_id, emp.first_name, emp.middle_name,emp.last_name, sal.basic_salary, sal.da, sal.hra,sal.gross_salary, sal.income_tax, sal.net_salary from employee emp JOIN salary sal ON emp.employee_id=sal.employee_id and emp.employee_id=?";
	

	
}
