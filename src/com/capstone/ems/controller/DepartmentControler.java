package com.capstone.ems.controller;

import java.util.HashMap;
import java.util.List;

import com.capstone.ems.domain.Department;
import com.capstone.ems.domain.Employee;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;
import com.capstone.ems.service.DepartmentService;
import com.capstone.ems.service.DepartmentServiceImpl;

public class DepartmentControler {


	DepartmentService departmentService=new DepartmentServiceImpl();
	
	public Department addDepartment(Department dept) {
		try {
	
			if(dept.getDepartment_id()==0 || dept.getDep_name().isBlank() ||dept.getDep_location().isBlank())
					throw new EmsException("Mandatory fields", ErrorCode.DEPARTMENT_REQUIRED_FIELDS);

			
			departmentService.addDepartment(dept);
			dept.setBacktoMenu(true);

		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return dept;
	}

	public void  listAllDepartments(Department department) {

		try {
			HashMap<Integer, String> departments= departmentService.listAllDepartments();
			System.out.println("List of Departments::");
		    departments.forEach((k, v) -> System.out.println(("Department Id::"+k + "\t Detpatment Name::" + v)));
			department.setBacktoMenu(true);

		} catch (EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
	}

	public Department  deleteDepartment(Department department) {
		try {
			department = departmentService.deleteDepartment(department.getDepartment_id());
		} catch (EmsException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();
		}
		return department;
	}

	public Department editDepartment(Department department) {
		try {
			department=departmentService.editDepartment(department);
			department.setBacktoMenu(true);

		}catch(EmsException ex) {
			System.out.println(ex.getErrorCode());
			ex.printStackTrace();

		}
		return department;
	}
}
