package com.capstone.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.capstone.ems.common.EmsUtil;
import com.capstone.ems.constants.Constants;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.UserLogin;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {

	Connection con=null;
	PreparedStatement ps=null;;
	ResultSet rs=null;
	int count=0;
	EmsUtil emsUtil = new EmsUtil();
	Date date;

	@Override
	public UserLogin validateLogin(UserLogin userLogin) throws EmsException {
		// TODO Auto-generated method stub
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.SELECT_USER_LOGIN_DETAILS_QUERY);	
			ps.setString(1, userLogin.getUser_name());
			ps.setString(2, userLogin.getPassword());
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					do {
						userLogin.setRole_id(rs.getInt("roleId"));
					}while(rs.next());
				}else {
					userLogin.setTotalAttempts(userLogin.getTotalAttempts()+1);
					throw new EmsException("Invalid Credentials", ErrorCode.INVALID_CREDENTIALS);
				}
			}catch (SQLException ex) {
				throw new EmsException("SQL Exception has Occured",ex.getCause());
			}
		}catch(ClassNotFoundException ex) {
			throw new EmsException(ex, ErrorCode.LOAD_DRIVER_ERROR);
		}catch (SQLException ex) {
			throw new EmsException("SQL Exception has Occured",ex.getCause());
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userLogin;
	}

	@Override
	public Employee addNewEmployee(Employee employee) throws EmsException {
		// TODO Auto-generated method stub
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.INSERT_NEW_EMPLOYEE_QUERY);	

			ps.setInt(1,employee.getEmpId());
			ps.setString(2,  employee.getFname() != null ? employee.getFname() : null);
			ps.setString(3, emsUtil.checkNullForStringValues(employee.getMname()));
			ps.setString(4, emsUtil.checkNullForStringValues(employee.getLname()));
			ps.setString(5, emsUtil.checkNullForStringValues(employee.getGender()));
			ps.setString(6, emsUtil.checkNullForStringValues(employee.getEmail()));
			ps.setDate(7,  emsUtil.formatDate(employee.getDOB()));
			ps.setString(8, emsUtil.checkNullForStringValues(employee.getDesignation()));
			ps.setInt(9, employee.getRole());
			ps.setString(10, emsUtil.checkNullForStringValues(employee.getPhonenumber()));
			ps.setInt(11, employee.getDepartment_id());
			ps.setString(12, employee.getWork_location());
			ps.setDate(13, emsUtil.formatDate(employee.getHire_date()));
			ps.setString(14, Constants.STATUS_ACTIVE);
			ps.setTimestamp(15, Constants.CURR_DATE_TIME);
			ps.setTimestamp(16,Constants.CURR_DATE_TIME);
			System.out.println("Query:=="+ ps.toString());
			count=ps.executeUpdate();
			if (count ==1) {
				ps=con.prepareStatement(Constants.INSERT_NEW_USER);
				ps.setInt(1, employee.getRole());
				ps.setInt(2,employee.getEmpId());
				ps.setString(3,Constants.FIRST_DEFAULT_PASSWORD);
				ps.setTimestamp(4, Constants.CURR_DATE_TIME);
				count=ps.executeUpdate();
				ps = con.prepareStatement(Constants.INSERT_EMP_ADDRESS_QUERY);	
				ps.setInt(1, employee.getEmpId());
				ps.setString(2,  emsUtil.checkNullForStringValues(employee.getHomeaddress_line1()));
				ps.setString(3,  emsUtil.checkNullForStringValues(employee.getHomeaddress_line2()));
				//employee.getHomeaddress_no() != null ? employee.getHomeaddress_no() : null);
				ps.setString(4,  emsUtil.checkNullForStringValues(employee.getHomeaddress_street()));
				ps.setString(5,   emsUtil.checkNullForStringValues(employee.getHomeaddress_city()));
				ps.setString(6,   emsUtil.checkNullForStringValues(employee.getHomeaddress_state()));
				ps.setString(7, employee.getZip());
				System.out.println("Query2:=="+ ps.toString());
				count=ps.executeUpdate();
				System.out.println("Employee Added successfully");
				if(count==1) 				employee.setReturn_status(true);
			}
		}catch(ClassNotFoundException ex) {
			throw new EmsException(ex, ErrorCode.LOAD_DRIVER_ERROR);
		}catch (SQLException ex) {
			throw new EmsException("SQL Exception has Occured",ex.getCause());
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public List<Employee> listAllEmployees() throws EmsException {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		try {
			con = Connect.getConnection();
			// Fetch all employees who are Active
			ps = con.prepareStatement(Constants.SQL_SELECT__ALL_EMPLOYEE);
			ps.setString(1, Constants.STATUS_ACTIVE);

			rs =ps.executeQuery();
			while(rs.next()) {
				Employee employee= new Employee();
				employee.setEmpId(rs.getInt("employee_id"));
				employee.setFname(rs.getString("first_name"));
				employee.setMname(rs.getString("middle_name"));
				employee.setLname(rs.getString("last_name"));
				employee.setEmail(rs.getString("email"));
				employee.setGender(rs.getString("gender"));
				employee.setDOB(rs.getString("DOB"));
				employee.setDesignation(rs.getString("designation"));
				employee.setPhonenumber(rs.getString("phone_number"));
				employee.setHire_date(rs.getString("hire_date"));
				employee.setHomeaddress_line1(rs.getString("house_address_line1"));
				employee.setHomeaddress_line2(rs.getString("house_address_line2"));
				employee.setHomeaddress_street(rs.getString("street"));
				employee.setHomeaddress_city(rs.getString("city"));
				employee.setHomeaddress_state(rs.getString("state"));
				employee.setHomeaddress_state(rs.getString("zip"));
				employees.add(employee);
			}
		} catch (ClassNotFoundException e) {
			throw new EmsException(e,ErrorCode.LOAD_DRIVER_ERROR);
		} catch (SQLException e) {
			throw new EmsException(e,ErrorCode.SQL_INSERT_ERROR);
		}catch(Exception ce) {
			throw new EmsException(ce, ErrorCode.SQL_UNKNOWN_ERROR);
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	@Override
	public Employee deleteEmployee(int employee_id) throws EmsException {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.SQL_DELETE_EMPLOYEE);
			ps.setString(1, Constants.STATUS_DEACTIVATED);
			ps.setInt(2, employee_id);
			ps.setString(3, Constants.STATUS_DEACTIVATED);
			count=ps.executeUpdate();
			rs=null;
			if(count>0)	{
				ps = con.prepareStatement(Constants.FIND_EMPLOYEE);
				ps.setInt(1, employee_id);
				ps.setString(2,Constants.STATUS_ACTIVE);
				rs = ps.executeQuery();
				if(rs.next()) {
					do {
						employee.setFname(rs.getString("first_name"));
						employee.setLname(rs.getString("last_name"));
						employee.setEmployee_status(rs.getString("emp_status"));
						employee.setReturn_status(true);
					}while(rs.next());
				}else {
					employee.setReturn_status(true);
					System.out.println("Record not found.");
				}
			}else {
				// neeed to set employee status code here in future
				employee.setReturn_status(true);
				System.out.println("employee  not found.");
			}

		}catch(ClassNotFoundException ex) {
			throw new EmsException(ex, ErrorCode.LOAD_DRIVER_ERROR);
		}catch (SQLException ex) {
			throw new EmsException("SQL Exception has Occured",ex.getCause());
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return employee;
	}

	@Override
	public Employee editNewEmployee(Employee employee) throws EmsException {
		// TODO Auto-generated method stub
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.UPDATE_EMPLOYEE_QUERY);	

			ps.setString(1,  employee.getFname() != null ? employee.getFname() : null);
			ps.setString(2, emsUtil.checkNullForStringValues(employee.getMname()));
			ps.setString(3, emsUtil.checkNullForStringValues(employee.getLname()));
			ps.setString(4, emsUtil.checkNullForStringValues(employee.getGender()));
			ps.setString(5, emsUtil.checkNullForStringValues(employee.getEmail()));
			ps.setDate(6,  emsUtil.formatDate(employee.getDOB()));
			ps.setString(7, emsUtil.checkNullForStringValues(employee.getDesignation()));
			ps.setInt(8, employee.getRole());
			ps.setString(9, emsUtil.checkNullForStringValues(employee.getPhonenumber()));
			ps.setInt(10, employee.getDepartment_id());
			ps.setString(11, employee.getWork_location());
			ps.setDate(12, emsUtil.formatDate(employee.getHire_date()));
			ps.setTimestamp(13,Constants.CURR_DATE_TIME);
			ps.setInt(14,employee.getEmpId());

			System.out.println("Query:=="+ ps.toString());
			count=ps.executeUpdate();
			if (count ==1) {
				ps = con.prepareStatement(Constants.UPDATE_EMP_ADDRESS);	
				ps.setString(1,  emsUtil.checkNullForStringValues(employee.getHomeaddress_line1()));
				ps.setString(2,  emsUtil.checkNullForStringValues(employee.getHomeaddress_line2()));
				//employee.getHomeaddress_no() != null ? employee.getHomeaddress_no() : null);
				ps.setString(3,  emsUtil.checkNullForStringValues(employee.getHomeaddress_street()));
				ps.setString(4,   emsUtil.checkNullForStringValues(employee.getHomeaddress_city()));
				ps.setString(5,   emsUtil.checkNullForStringValues(employee.getHomeaddress_state()));
				ps.setString(6, employee.getZip());
				ps.setInt(7, employee.getEmpId());
				System.out.println("Query2:=="+ ps.toString());
				System.out.println("Employee details updated successfully");
				count=ps.executeUpdate();
				if(count==1) 				employee.setReturn_status(true);

			}else {
				System.out.println("Employee records not found");
				employee.setReturn_status(true);
			}
		}catch(ClassNotFoundException ex) {
			throw new EmsException(ex, ErrorCode.LOAD_DRIVER_ERROR);
		}catch (SQLException ex) {
			throw new EmsException("SQL Exception has Occured",ex.getCause());
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;	}

	@Override
	public Employee findEmployee(int employee_id) throws EmsException {

		Employee employee=new Employee();
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.FIND_EMPLOYEE);
			ps.setInt(1, employee_id);
			ps.setString(2, Constants.STATUS_ACTIVE);
			rs = ps.executeQuery();
			if(rs.next()) {
				do {
					employee.setEmpId(rs.getInt("employee_id"));
					employee.setReturn_status(true);
				}while(rs.next());
			}else {
				employee.setReturn_status(false);
				System.out.println("Record not found.");
			}
		}catch(ClassNotFoundException ex) {
			throw new EmsException(ex, ErrorCode.LOAD_DRIVER_ERROR);
		}catch (SQLException ex) {
			throw new EmsException("SQL Exception has Occured",ex.getCause());
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public Employee fetchEmpDetail(int employee_id) throws EmsException {
		Employee employee=new Employee();
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.FETCH_EMPLOYEE_DETAIL);
			ps.setInt(1, employee_id);
			ps.setString(2, Constants.STATUS_ACTIVE);
			rs = ps.executeQuery();
			if(rs.next()) {
				do {
					employee.setEmpId(rs.getInt("employee_id"));
					employee.setReturn_status(true);
					employee.setFname(rs.getString("first_name"));
					employee.setMname(rs.getString("middle_name"));
					employee.setLname(rs.getString("last_name"));
					employee.setGender(rs.getString("gender"));
					employee.setDOB(rs.getDate("DOB").toString());
					employee.setEmail(rs.getString("email"));
					employee.setDesignation(rs.getString("designation"));
					employee.setHomeaddress_line1(rs.getString("house_address_line1"));
					employee.setHomeaddress_line2(rs.getString("house_address_line2"));
					employee.setHomeaddress_street(rs.getString("street"));
					employee.setHomeaddress_state(rs.getString("state"));
					employee.setHomeaddress_city(rs.getString("city"));
					employee.setPhonenumber(rs.getString("phone_number"));
				}while(rs.next());
			}else {
				employee.setReturn_status(false);
				System.out.println("Record not found.");
			}
		}catch(ClassNotFoundException ex) {
			throw new EmsException(ex, ErrorCode.LOAD_DRIVER_ERROR);
		}catch (SQLException ex) {
			throw new EmsException("SQL Exception has Occured",ex.getCause());
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}


}
