package com.zensar.emdb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.zensar.emdb.bean.EmployeeSalary;
import com.zensar.emdb.connection.DBUtil;


public class EmployeeSalaryDaoClass implements EmployeeSalaryInterface<EmployeeSalary>{
	
	Connection c =DBUtil.getConnection();
	String query;
	boolean status = false;
	int eCode;
	String eName;
	String designation;
	int age ;
	double basicPay;
	double DA;
	double HRA;
	double salary;
	
	//showMySalary function
	public EmployeeSalary showMySalary(EmployeeSalary obj) {
		status = false;
		eCode = obj.geteCode();
		Statement stmt;
		EmployeeSalary temp = null; 
		try {
			stmt = c.createStatement();
			query = "select Ecode, Ename,Designation ,Basic_Pay, DA , HRA, Salary from EmployeeSalary where Ecode = "+eCode; 
			ResultSet rst;
			rst = stmt.executeQuery(query);
			while(rst.next()) {
				status = true;
				eName = rst.getString(2);
				designation = rst.getString(3);
				basicPay = rst.getDouble(4);
				DA = rst.getDouble(5);
				HRA = rst.getDouble(6);
				salary = rst.getDouble(7);
				
				temp = new EmployeeSalary(eCode, eName, designation, basicPay,DA ,HRA ,salary);
				return temp;
			}
			}catch (SQLException e) {
					e.printStackTrace();
			}
			return temp;
	}//end of function
	
	public Boolean checkFunction(EmployeeSalary obj) {
		status = false;
		eCode = obj.geteCode();
		Statement stmt;
		try {
			stmt = c.createStatement();
			query = "select Ecode from EmployeeSalary where Ecode = "+eCode; 
			ResultSet rst;
			rst = stmt.executeQuery(query);
			//System.out.println(rst.next());
			if(rst.next()) {
					status = true;
			}
		
		}catch (SQLException e) {
			System.out.println("\t\tSQL exception found!!!");
		}
		return status;
	
	}//endOf function

}
