package com.capstone.ems.service;

import com.capstone.ems.dao.EmployeeDetailsDao;
import com.capstone.ems.dao.EmployeeDetailsDaoImpl;
import com.capstone.ems.domain.UserLogin;
import com.capstone.ems.exception.EmsException;


public class UserLoginServiceImpl implements UserLoginService {

	EmployeeDetailsDao employeeDetailsDao = new EmployeeDetailsDaoImpl();
	@Override
	public UserLogin validateLogin(UserLogin userLogin) {
		// TODO Auto-generated method stub
		try {
			userLogin= employeeDetailsDao.validateLogin(userLogin);
		}catch(EmsException ex){
			System.out.println(ex.getErrorCode());
        	ex.printStackTrace();
		}
		return userLogin;
	}
	
}
