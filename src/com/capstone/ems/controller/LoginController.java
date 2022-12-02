package com.capstone.ems.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capstone.ems.constants.Constants;
import com.capstone.ems.domain.UserLogin;
import com.capstone.ems.exception.EmsException;
import com.capstone.ems.exception.ErrorCode;
import com.capstone.ems.service.UserLoginService;
import com.capstone.ems.service.UserLoginServiceImpl;

public class LoginController {
	
	UserLoginService userLoginService = new UserLoginServiceImpl();

	public UserLogin validateLogin(UserLogin userLogin) {
		try {
			if(userLogin.getUser_name().isBlank() || userLogin.getPassword().isBlank()) 
				throw new EmsException(ErrorCode.USERNAME_NULL);
			Pattern p=Pattern.compile(Constants.valid_password_regex);
			Matcher m = p.matcher(userLogin.getPassword());
			if (m.matches())
				userLogin= userLoginService.validateLogin(userLogin);
			else
				throw new EmsException(ErrorCode.PASSWORD_INVALID);
	    }catch(EmsException ex) {
        	System.out.println(ex.getErrorCode());
        //	ex.printStackTrace();
        }
		return userLogin;
	}

}
