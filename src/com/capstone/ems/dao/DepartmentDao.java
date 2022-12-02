package com.capstone.ems.dao;

import java.util.HashMap;
import java.util.List;

import com.capstone.ems.domain.Department;
import com.capstone.ems.exception.EmsException;

public interface DepartmentDao {
	public Department addDepartment(Department dept) throws EmsException;
	public HashMap<Integer, String> listAllDepartments() throws EmsException;
	public  Department deleteDepartment(int employee_id) throws EmsException;
	public Department editDepartment(Department dept) throws EmsException;
}
