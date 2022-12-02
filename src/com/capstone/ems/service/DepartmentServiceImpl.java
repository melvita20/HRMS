package com.capstone.ems.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capstone.ems.dao.DepartmentDao;
import com.capstone.ems.dao.DepartmentDaoImpl;
import com.capstone.ems.dao.EmployeeDetailsDao;
import com.capstone.ems.dao.EmployeeDetailsDaoImpl;
import com.capstone.ems.domain.Department;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.exception.EmsException;

public class DepartmentServiceImpl implements DepartmentService{

	DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	public Department addDepartment(Department dept) throws EmsException {
		try {
			dept= departmentDao.addDepartment(dept);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return dept;		

	}

	@Override
	public HashMap<Integer, String> listAllDepartments() throws EmsException {
		HashMap<Integer, String> departments = new HashMap<>();
		try {
			departments=departmentDao.listAllDepartments();
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return departments;
	}

	@Override
	public Department deleteDepartment(int dept_id) throws EmsException {
		Department department=new Department();
		try {
			department= departmentDao.deleteDepartment(dept_id);	
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return department;
	}

	@Override
	public Department editDepartment(Department dept) throws EmsException {
		try {
			dept= departmentDao.editDepartment(dept);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return dept;		
	}

}
