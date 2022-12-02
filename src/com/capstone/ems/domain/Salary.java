package com.capstone.ems.domain;

import java.sql.Date;

public class Salary {
	private int emp_id;
	private String payslip_id;
	private int no_of_days;
    private double BASIC;
    private float HRA_percentage;
    private float DA_percentage;
    private float it_percentage;
    private double HRA;
    private double DA;
   private double gross_salary;
   private double incometax;
   private double netsalary;
   private Boolean backtoMenu;
   private Date added_on;
   private Date modified_on;
/**
 * @return the emp_id
 */
public int getEmp_id() {
	return emp_id;
}
/**
 * @param emp_id the emp_id to set
 */
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
/**
 * @return the payslip_id
 */
public String getPayslip_id() {
	return payslip_id;
}
/**
 * @param payslip_id the payslip_id to set
 */
public void setPayslip_id(String payslip_id) {
	this.payslip_id = payslip_id;
}
/**
 * @return the no_of_days
 */
public int getNo_of_days() {
	return no_of_days;
}
/**
 * @param no_of_days the no_of_days to set
 */
public void setNo_of_days(int no_of_days) {
	this.no_of_days = no_of_days;
}
/**
 * @return the bASIC
 */
public double getBASIC() {
	return BASIC;
}
/**
 * @param bASIC the bASIC to set
 */
public void setBASIC(double bASIC) {
	BASIC = bASIC;
}
/**
 * @return the hRA_percentage
 */
public float getHRA_percentage() {
	return HRA_percentage;
}
/**
 * @param hRA_percentage the hRA_percentage to set
 */
public void setHRA_percentage(float hRA_percentage) {
	HRA_percentage = hRA_percentage;
}
/**
 * @return the dA_percentage
 */
public float getDA_percentage() {
	return DA_percentage;
}
/**
 * @param dA_percentage the dA_percentage to set
 */
public void setDA_percentage(float dA_percentage) {
	DA_percentage = dA_percentage;
}
/**
 * @return the hRA
 */
public double getHRA() {
	return HRA;
}
/**
 * @param hRA the hRA to set
 */
public void setHRA(double hRA) {
	HRA = hRA;
}
/**
 * @return the dA
 */
public double getDA() {
	return DA;
}
/**
 * @param dA the dA to set
 */
public void setDA(double dA) {
	DA = dA;
}
/**
 * @return the gross_salary
 */
public double getGross_salary() {
	return gross_salary;
}
/**
 * @param gross_salary the gross_salary to set
 */
public void setGross_salary(double gross_salary) {
	this.gross_salary = gross_salary;
}
/**
 * @return the incometax
 */
public double getIncometax() {
	return incometax;
}
/**
 * @param incometax the incometax to set
 */
public void setIncometax(double incometax) {
	this.incometax = incometax;
}
/**
 * @return the netsalary
 */
public double getNetsalary() {
	return netsalary;
}
/**
 * @param netsalary the netsalary to set
 */
public void setNetsalary(double netsalary) {
	this.netsalary = netsalary;
}
/**
 * @return the return_status
 */
public Boolean getBacktoMenu() {
	return backtoMenu;
}
/**
 * @param return_status the return_status to set
 */
public void setBacktoMenu(Boolean backtoMenu) {
	this.backtoMenu = backtoMenu;
}
/**
 * @return the added_on
 */
public Date getAdded_on() {
	return added_on;
}
/**
 * @param added_on the added_on to set
 */
public void setAdded_on(Date added_on) {
	this.added_on = added_on;
}
/**
 * @return the modified_on
 */
public Date getModified_on() {
	return modified_on;
}
/**
 * @param modified_on the modified_on to set
 */
public void setModified_on(Date modified_on) {
	this.modified_on = modified_on;
}
/**
 * @return the it_percentage
 */
public float getIt_percentage() {
	return it_percentage;
}
/**
 * @param it_percentage the it_percentage to set
 */
public void setIt_percentage(float it_percentage) {
	this.it_percentage = it_percentage;
}
}

   
