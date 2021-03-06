package com.zensar.emdb.bean;

import java.util.Date;

public class EmployeeLog {
	
	int eCode;
	String eName,designation;
    double lastDSalary;
    Date leaveDate;
    
    public EmployeeLog() {}
    
	public EmployeeLog(int eCode, String eName, String designation, double lastDSalary, Date leaveDate) {
		super();
		this.eCode = eCode;
		this.eName = eName;
		this.designation = designation;
		this.lastDSalary = lastDSalary;
		this.leaveDate = leaveDate;
	}
	
	public int geteCode() {
		return eCode;
	}
	public void seteCode(int eCode) {
		this.eCode = eCode;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getLastDSalary() {
		return lastDSalary;
	}
	public void setLastDSalary(double lastDSalary) {
		this.lastDSalary = lastDSalary;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	@Override
	public String toString() {
		return "EmployeeLog [eCode=" + eCode + ", eName=" + eName + ", designation=" + designation + ", lastDSalary="
				+ lastDSalary + ", leaveDate=" + leaveDate + "]";
	}
}
