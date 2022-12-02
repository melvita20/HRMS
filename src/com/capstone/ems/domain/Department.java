package com.capstone.ems.domain;

public class Department {
	
	private int department_id;
	private String dep_name;
	private String dep_location;
	private String status;
	private Boolean backtoMenu;
	
	/**
	 * @return the department_id
	 */
	public int getDepartment_id() {
		return department_id;
	}
	/**
	 * @param department_id the department_id to set
	 */
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	/**
	 * @return the dep_name
	 */
	public String getDep_name() {
		return dep_name;
	}
	/**
	 * @param dep_name the dep_name to set
	 */
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	/**
	 * @return the dep_location
	 */
	public String getDep_location() {
		return dep_location;
	}
	/**
	 * @param dep_location the dep_location to set
	 */
	public void setDep_location(String dep_location) {
		this.dep_location = dep_location;
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", dep_name=" + dep_name+"]";
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the backtoMenu
	 */
	public Boolean getBacktoMenu() {
		return backtoMenu;
	}
	/**
	 * @param backtoMenu the backtoMenu to set
	 */
	public void setBacktoMenu(Boolean backtoMenu) {
		this.backtoMenu = backtoMenu;
	}

}
