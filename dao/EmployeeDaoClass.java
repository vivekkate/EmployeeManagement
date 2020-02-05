package com.zensar.emdb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.zensar.emdb.bean.Employee;
import com.zensar.emdb.connection.DBUtil;

public class EmployeeDaoClass implements EmployeeInterface<Boolean, Employee,ArrayList> {
		//connection to oracle
			Connection c = DBUtil.getConnection();
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
			
			//insert function 
			public Boolean insert(Employee obj) {
				
				status = false;
				//Access variable
				eCode = obj.geteCode();
				eName = obj.geteName();
				designation = obj.getDesignation();
				age = obj.getAge(); 
				basicPay = obj.getBasicPay();
					
					  
				try {
					query = "insert into Employee values(?,?,?,?,?)";
					PreparedStatement pst = c.prepareStatement(query);
					pst.setInt(1, eCode);		
					pst.setString(2, eName);
					pst.setString(3, designation);
					pst.setInt(4, age);
					pst.setDouble(5, basicPay);
					int count= pst.executeUpdate();
					
					DA = basicPay* 0.2;
					HRA = basicPay * 0.1;
					salary = basicPay + DA + HRA;
					query = "insert into EmployeeSalary values(?,?,?,?,?,?,?)";
					pst = c.prepareStatement(query);
					pst.setInt(1, eCode);
					pst.setString(2, eName);
					pst.setString(3, designation);
					pst.setDouble(4, basicPay);
					pst.setDouble(5,DA);
					pst.setDouble(6, HRA);
					pst.setDouble(7, salary);
					count = pst.executeUpdate();
					if(count > 0){
							//if inserted succuessfully then set status 
							status= true;
					}
					} catch (SQLException e) {
						System.out.println("\n\t********USER Already Exist********");
					}
					return status;
					
				} //end of insert function
			

			//function delete 
			@Override
			public Boolean delete(Employee obj) {
				
			    eCode = obj.geteCode();
				try {
					PreparedStatement ps=c.prepareStatement("delete from Employee where Ecode= "+eCode+" ");
					int count=ps.executeUpdate();
					ps=c.prepareStatement("delete from EmployeeSalary where Ecode= "+eCode+" ");
					ps.executeUpdate();
					if(count>0) {
						status=true;
					}else {
						status=false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return status;
				
			} //end of function delete
			
			
			//function modify
			
			public Boolean modifySalary(Employee obj) {
				  boolean status = false;
				  eCode = obj.geteCode();
				  basicPay=obj.getBasicPay();
				
				try {
				    PreparedStatement pst = c.prepareStatement("update Employee set Basic_Pay=? where ECode=?");
					pst.setDouble(1, basicPay);		
					pst.setInt(2, eCode);
					int count= pst.executeUpdate();
					pst = c.prepareStatement("update EmployeeSalary set Basic_Pay=? where ECode=?");
					pst.setDouble(1, basicPay);		
					pst.setInt(2, eCode);
					
					pst.executeUpdate();
					if(count > 0){
						status= true;
					}
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				return status;
			} //modify salary end
			
		  //modify desgination function	
		  public Boolean modifyDesignation(Employee obj) {
					  boolean status = false;
					  eCode =  obj.geteCode();
					  designation=obj.getDesignation();
					
					try {
					    PreparedStatement pst = c.prepareStatement("update Employee set Designation=? where ECode=?");
						pst.setString(1,designation );		
						pst.setInt(2, eCode);
						int count= pst.executeUpdate();
						pst = c.prepareStatement("update EmployeeSalary set Designation=? where ECode=?");
						pst.setString(1, designation);		
						pst.setInt(2, eCode);
						
						pst.executeUpdate();	
						if(count > 0){
							status= true;
							
						}
					}catch (SQLException e) {
						
						e.printStackTrace();
					}
					return status;
				}//end modify designation
		 
		  
		  //display all function
		  public ArrayList<Employee> DisplayAll() {
			  
			  	ArrayList<Employee> arr = new ArrayList<Employee>();
				try {
					Statement st=c.createStatement();
					ResultSet rs=st.executeQuery("select * from Employee");
					
					while(rs.next()) {
						arr.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5)));
					}
				} catch (SQLException e) {
						//e.printStackTrace();
				}
				return arr;
			}//end of display all
		  
		  
		 //displayOne function
		  public Employee DisplayOne(Employee obj) {
				Employee emp = null;
				try {
				  Statement st = c.createStatement();
				  st = c.createStatement();				
				  ResultSet rs= st.executeQuery("select * from Employee where Ecode = "+obj.geteCode());
				  while(rs.next()) {
					  emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5));
				  }

			  } catch (SQLException e) {
				  	//e.printStackTrace();
			  }
			  return emp;
								
			}//endOf Display one
		  
		  public Boolean checkFunction(Employee obj) {
				status = false;
				eCode = obj.geteCode();
				Statement stmt;
				try {
					stmt = c.createStatement();
					query = "select Ecode from Employee where Ecode = "+eCode; 
					ResultSet rst;
					rst = stmt.executeQuery(query);
					//System.out.println(rst.next());
					if(rst.next()) {
							status = true;
					}
				
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return status;
			
			}//endOf function
		  
		  public Boolean checkAll(Employee obj) {
				status = false;
				Employee emp1=new Employee();
				eCode = obj.geteCode();
				Statement stmt;
				try {
					stmt = c.createStatement();
					query = "select Ecode,Ename, designation,age,basic_pay from Employee where Ecode = "+eCode; 
					ResultSet rst;
					rst = stmt.executeQuery(query);
					System.out.println(rst.next());
					if(rst.next()) {
							status = true;
					}
				
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return status;
			
			}//endOf function
}
