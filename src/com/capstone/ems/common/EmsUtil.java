package com.capstone.ems.common;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class EmsUtil {

	public String checkNullForStringValues(String inputStr) {
		String result=null;
		result = Optional.ofNullable(inputStr).orElse(null);
		return result;
	}
	public Integer checkNullForIntValues(Integer inputStr) {
		Integer result=null;
		result = Optional.ofNullable(inputStr).orElse(null);
		return result;
	}

	public Date formatDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");	    
		LocalDate localDate = LocalDate.parse(date,formatter);
		return convertToDatabaseColumn(localDate);
	}

	public Date convertToDatabaseColumn(LocalDate localDate) {
		return Optional.ofNullable(localDate)
				.map(Date::valueOf)
				.orElse(null);
	}
	
	public double calulate_DA(float da_percent,double basicsalary) {
		System.out.println("basic"+basicsalary);
		return (da_percent/100)*basicsalary;
	}

	public double calulate_HRA(float hra_percent,double basicsalary) {
		return (hra_percent/100)*basicsalary;
	}

	public double calculate_it(float it_percent,double gs) {
		return (it_percent/100)*gs;
	}
	
	public double calculate_gross(double hra,double da, double basic) {
		return basic+hra+da;
	}
	
public double calculate_net(double gs, double incometx) {
		return gs-incometx;
	}
}
