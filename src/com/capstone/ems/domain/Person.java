package com.capstone.ems.domain;

import java.time.LocalDate;

public class Person {

	private String fname;
	private String mname;
	private String lname;
	private String gender;
	private String email;
	private String DOB;
	private String homeaddress_line1;
	private String homeaddress_line2;
	private String homeaddress_street;
	private String homeaddress_city;
	private String homeaddress_state;
	private String zip;
	private String status_code;
	private String status_msg;
	private Boolean return_status;
	@Override
	public String toString() {
		return "fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", gender=" + gender + ", email="
				+ email + ", DOB=" + DOB + ", homeaddress_line1=" + homeaddress_line1 + ", homeaddress_line2="
				+ homeaddress_line2 + ", homeaddress_street=" + homeaddress_street + ", homeaddress_city="
				+ homeaddress_city + ", homeaddress_state=" + homeaddress_state + ", zip=" + zip ;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * @param mname the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dOB
	 */
	public String getDOB() {
		return DOB;
	}
	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	/**
	 * @return the homeaddress_line1
	 */
	public String getHomeaddress_line1() {
		return homeaddress_line1;
	}
	/**
	 * @param homeaddress_line1 the homeaddress_line1 to set
	 */
	public void setHomeaddress_line1(String homeaddress_line1) {
		this.homeaddress_line1 = homeaddress_line1;
	}
	/**
	 * @return the homeaddress_line2
	 */
	public String getHomeaddress_line2() {
		return homeaddress_line2;
	}
	/**
	 * @param homeaddress_line2 the homeaddress_line2 to set
	 */
	public void setHomeaddress_line2(String homeaddress_line2) {
		this.homeaddress_line2 = homeaddress_line2;
	}
	/**
	 * @return the homeaddress_street
	 */
	public String getHomeaddress_street() {
		return homeaddress_street;
	}
	/**
	 * @param homeaddress_street the homeaddress_street to set
	 */
	public void setHomeaddress_street(String homeaddress_street) {
		this.homeaddress_street = homeaddress_street;
	}
	/**
	 * @return the homeaddress_city
	 */
	public String getHomeaddress_city() {
		return homeaddress_city;
	}
	/**
	 * @param homeaddress_city the homeaddress_city to set
	 */
	public void setHomeaddress_city(String homeaddress_city) {
		this.homeaddress_city = homeaddress_city;
	}
	/**
	 * @return the homeaddress_state
	 */
	public String getHomeaddress_state() {
		return homeaddress_state;
	}
	/**
	 * @param homeaddress_state the homeaddress_state to set
	 */
	public void setHomeaddress_state(String homeaddress_state) {
		this.homeaddress_state = homeaddress_state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the status_code
	 */
	public String getStatus_code() {
		return status_code;
	}
	/**
	 * @param status_code the status_code to set
	 */
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	/**
	 * @return the status_msg
	 */
	public String getStatus_msg() {
		return status_msg;
	}
	/**
	 * @param status_msg the status_msg to set
	 */
	public void setStatus_msg(String status_msg) {
		this.status_msg = status_msg;
	}
	/**
	 * @return the return_status
	 */
	public Boolean getReturn_status() {
		return return_status;
	}
	/**
	 * @param return_status the return_status to set
	 */
	public void setReturn_status(Boolean return_status) {
		this.return_status = return_status;
	}
	
	
}
