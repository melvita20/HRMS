package com.capstone.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.capstone.ems.common.EmsUtil;
import com.capstone.ems.constants.Constants;
import com.capstone.ems.domain.Department;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;

public class DepartmentDaoImpl implements DepartmentDao {

	Connection con=null;
	PreparedStatement ps=null;;
	ResultSet rs=null;
	Date dt= new Date();
	Timestamp date = new Timestamp(dt.getTime());
	int count=0;
	EmsUtil emsUtil = new EmsUtil();

	@Override
	public Department addDepartment(Department dept) throws EmsException {
		// TODO Auto-generated method stub
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.INSERT_NEW_DEPT_QUERY);	
			ps.setInt(1,dept.getDepartment_id());
			ps.setString(2, emsUtil.checkNullForStringValues(dept.getDep_name()));
			ps.setString(3, emsUtil.checkNullForStringValues(dept.getDep_location()));
			ps.setString(4, Constants.STATUS_ACTIVE);
			System.out.println("Query:=="+ ps.toString());
			count=ps.executeUpdate();
			if (count ==1) {
				System.out.println("Departmnt Added successfully");
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
		return dept;
	}

	@Override
	public HashMap<Integer, String> listAllDepartments() throws EmsException {
		// TODO Auto-generated method stub
		List<Department> departments = new ArrayList<Department>();
        HashMap<Integer, String> dept = new HashMap<>();

		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.SQL_SELECT__ALL_DEPARTMENT);
			ps.setString(1, Constants.STATUS_ACTIVE);
			rs =ps.executeQuery();
			while(rs.next()) {
//				Department dept= new Department();
				dept.put(rs.getInt("id"), rs.getString("dname"));
//				dept.setDepartment_id(rs.getInt("id"));
//				dept.setDep_name(rs.getString("dname"));
//				departments.add(dept);
			}
			System.out.println(departments.size() + " records fetched.");
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
		return dept;
	}

	@Override
	public Department deleteDepartment(int dept_id) throws EmsException {
		// TODO Auto-generated method stub

		Department department=new Department();
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.SQL_DELETE_DEPARTMENT);
			ps.setString(1, Constants.STATUS_DEACTIVATED);
			ps.setInt(2, dept_id);
			ps.setString(3, Constants.STATUS_DEACTIVATED);
			count=ps.executeUpdate();
			if(count>0)	{
				department.setStatus(Constants.STATUS_DEACTIVATED);
				department.setBacktoMenu(true);
			}else {
				System.out.println("Department  not found.");
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
		return department;
	}

	@Override
	public Department editDepartment(Department dept) throws EmsException {
		try {
			con = Connect.getConnection();
			ps = con.prepareStatement(Constants.UPDATE_DEPARTMENT_QUERY);	
			ps.setString(1, emsUtil.checkNullForStringValues(dept.getDep_name()));
			ps.setString(2, emsUtil.checkNullForStringValues(dept.getDep_location()));
			ps.setInt(3,dept.getDepartment_id());
			ps.setString(4, Constants.STATUS_DEACTIVATED);
			System.out.println("Query:=="+ ps.toString());
			count=ps.executeUpdate();
			if (count ==1) {
				System.out.println("Departmnt Deleted successfully");
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
		return dept;
	}

}
