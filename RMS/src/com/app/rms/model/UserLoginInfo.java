package com.app.rms.model;

import java.util.Date;

/**
 * 
 * @author NT00477646
 * UserLoginInfo contains user loging details
 */
public class UserLoginInfo {
	private String empId;
	private String empName;
	private String password;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
