package com.capstone.ems.service;

import com.capstone.ems.domain.UserLogin;
import com.capstone.ems.exception.EmsException;

public interface UserLoginService {
	
	public UserLogin validateLogin(UserLogin userLogin) throws EmsException;


}
