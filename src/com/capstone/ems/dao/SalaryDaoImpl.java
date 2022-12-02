package com.capstone.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capstone.ems.common.EmsUtil;
import com.capstone.ems.constants.Constants;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.domain.Salary;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;

public class SalaryDaoImpl implements SalaryDao{
	Connection con=null;
	PreparedStatement ps=null;;
	ResultSet rs=null;
	int count=0;
	EmsUtil emsUtil = new EmsUtil();
	Date date;

	@Override
	public Salary addSalaryDetails(Salary salary) throws EmsException {
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.INSERT_SALARY_DETAIL_QUERY);	
			ps.setInt(1,salary.getEmp_id());
			ps.setDouble(2, salary.getBASIC());
			ps.setFloat(3, salary.getHRA_percentage());
			ps.setDouble(4,salary.getHRA() );
			ps.setFloat(5, salary.getDA_percentage());
			ps.setDouble(6, salary.getDA());
			ps.setDouble(7, salary.getGross_salary());
			ps.setFloat(8, salary.getIt_percentage());
			ps.setDouble(9, salary.getIncometax());
			ps.setDouble(10, salary.getNetsalary());
			ps.setTimestamp(11, Constants.CURR_DATE_TIME);
			ps.setTimestamp(12,Constants.CURR_DATE_TIME);
			System.out.println("Query:=="+ ps.toString());
			count=ps.executeUpdate();
			if (count ==1) {
				salary.setBacktoMenu(true);
				System.out.println("Salary details Added successfully.");
			}else {
				salary.setBacktoMenu(true);	
				System.out.println("Salary details exists for the employee successfully.");
			}
		}catch(ClassNotFoundException ex) {
			throw new EmsException(ex, ErrorCode.LOAD_DRIVER_ERROR);
		}catch (SQLException ex) {
			throw new EmsException(ex.getMessage(),ex.getCause());
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return salary;
	}

	@Override
	public Salary editSalaryDetails(Salary salary) throws EmsException {
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.UPDATE_SALARY_DETAIL_QUERY);	
			ps.setDouble(1, salary.getBASIC());
			ps.setFloat(2, salary.getHRA_percentage());
			ps.setDouble(3,salary.getHRA() );
			ps.setFloat(4, salary.getDA_percentage());
			ps.setDouble(5, salary.getDA());
			ps.setDouble(6, salary.getGross_salary());
			ps.setFloat(7, salary.getIt_percentage());
			ps.setDouble(8, salary.getIncometax());
			ps.setDouble(9, salary.getNetsalary());
			ps.setTimestamp(10, Constants.CURR_DATE_TIME);
			ps.setInt(11,salary.getEmp_id());
			System.out.println("Query:=="+ ps.toString());
			count=ps.executeUpdate();
			if (count ==1) {
				salary.setBacktoMenu(true);
				System.out.println("Salary details updated successfully.");
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
		return salary;
	}

	@Override
	public Employee generatePaySlip(int emp_id, int no_of_days) throws EmsException{
		Employee employee=new Employee();
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.GENERATE_SALARY_DETAILS_QUERY);
			ps.setInt(1, emp_id);
			rs =ps.executeQuery();
			while(rs.next()) {
				Salary sal=new Salary();
				List<Salary> salary = new ArrayList<Salary>();
				employee.setEmpId(rs.getInt("employee_id"));
				employee.setFname(rs.getString("first_name"));
				employee.setMname(rs.getString("middle_name"));
				employee.setLname(rs.getString("last_name"));
				sal.setNo_of_days(no_of_days);
				sal.setBASIC(rs.getDouble("basic_salary"));
				sal.setDA(rs.getDouble("da"));
				sal.setHRA(rs.getDouble("hra"));
				sal.setGross_salary(rs.getDouble("gross_salary"));
				sal.setIncometax(rs.getDouble("income_tax"));
				sal.setNetsalary(rs.getDouble("net_salary"));
				salary.add(sal);
				employee.setSalary(salary);
				employee.setReturn_status(true);
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

		return employee;
	}

}
