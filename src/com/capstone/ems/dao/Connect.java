package com.capstone.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import com.capstone.ems.constants.Constants;


public class Connect {
	static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(Constants.DB_DRIVER);
		return 	DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PWD);
	}
	
	
}
