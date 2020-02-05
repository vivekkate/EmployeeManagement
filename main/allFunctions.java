package com.zensar.emdb.main;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.zensar.emdb.bean.Employee;
import com.zensar.emdb.bean.EmployeeSalary;
import com.zensar.emdb.dao.EmployeeDaoClass;
import com.zensar.emdb.dao.EmployeeSalaryDaoClass;
import com.zensar.emdb.exception.AgeException1;
import com.zensar.emdb.exception.BasicPayException;
import com.zensar.emdb.exception.DesignationException;
import com.zensar.emdb.exception.EcodeException;
import com.zensar.emdb.exception.EnameException;
import com.zensar.emdb.exception.UserNotFound;


public class allFunctions {
	static Scanner sc = new Scanner(System.in);
	static int choice,eCode,age;
	static String designation,eName;
	static double basicPay;
	static Employee tempEmp = null;
	static EmployeeDaoClass tempDao =  new EmployeeDaoClass();
	
	public static void insert() {

		
			try {
				System.out.print("\n\tEnter ID of Employee: ");
				eCode=sc.nextInt();
		 
				int num=Integer.toString(eCode).length();
				if(num>4 || num<4) 
				{
					throw new EcodeException();
				}

				System.out.print("\n\tEnter Name of Employee: ");
				eName=sc.next();

				if(eName.length() > 20) {
					throw new EnameException();
				}

				char arr[] = eName.toCharArray();
				for(int lc= 0; lc<arr.length; lc++ ) {
					if( arr[lc] >= 97 && arr[lc] <= 122 ) 
						throw new EnameException();
				}

				System.out.print("\n\tEnter Designation of Employee: ");
				designation=sc.next();
					
				if(designation.equals("SE") || designation.equals("SSE")
						|| designation.equals("SS")|| designation.equals("SSS")) {
					
				}else {
					throw new DesignationException();
				}
				
				System.out.print("\n\tEnter Age of Employee: ");
				age=sc.nextInt();

				if(age < 18 || age > 80) {
					throw new AgeException1();
				}

				System.out.print("\n\tEnter Basic Pay of Employee: ");
				basicPay=sc.nextDouble();
				if(basicPay < 6000) {
					throw new BasicPayException();
				}

				tempEmp = new Employee(eCode , eName, designation , age , basicPay);
				tempDao.insert(tempEmp);

			}
			catch(EnameException e) {
				System.out.println("\t"+e);
				
			}catch(EcodeException e) {
				System.out.println("\t"+e);
			}
			catch(DesignationException e) {
				System.out.println("\t"+e);
			}
			catch(AgeException1 e) {
				System.out.println("\n\t"+ e);
			}
			catch(BasicPayException e) {
				System.out.println("\t"+e);
			}
		
   }

		//delete function
		
		public static void delete() {
			tempEmp =new Employee();
			try {
			System.out.print("\n\tEnter ID of Employee: ");
			eCode=sc.nextInt();
			tempEmp.seteCode(eCode);
			
			if(tempDao.delete(tempEmp) ) {
				System.out.println("\n\t------------(:Deleted Successfully:)------------");
			}else {
				throw new UserNotFound();
		}
   		  }catch(UserNotFound e1) {
   		  		System.out.println(e1);
   		  }
		}
		
		public static void modifySalary() {
			tempEmp =new Employee();
			try {
			System.out.print("\n\tEnter ID of Employee: ");
   		  	eCode=sc.nextInt();
   		    tempEmp.seteCode(eCode);
			if(!tempDao.checkFunction(tempEmp))
			{
				throw new UserNotFound();
			}
   		  	System.out.print("\tEnter new Basic Pay of Employee: ");
   		  	basicPay=sc.nextDouble();
   		  	
   		 if(basicPay < 6000) {
				throw new BasicPayException();
			}

   		  	tempEmp.seteCode(eCode);
   		  	tempEmp.setBasicPay(basicPay);
   		  
   		  	if(tempDao.modifySalary(tempEmp)) {
   		  		System.out.println("\n\t------------(:Modification done Successfully:)------------");
   		  	}else {
   		  		System.out.println("\n\t------------Entered ID not found!!!------------");
   		  	}
			}catch(BasicPayException e) {
				System.out.println("\t"+e);
			}catch( UserNotFound e) {
				System.out.println("\t"+e);
			}
		
		}
		
		
		public static void modifyDesignation() {
			tempEmp =new Employee();
			try {
				System.out.print("\n\tEnter ID of Employee: ");
				eCode=sc.nextInt();
				tempEmp.seteCode(eCode);
				if(!tempDao.checkFunction(tempEmp))
			{
				throw new UserNotFound();
			}
			System.out.print("\n\tEnter new Designation of Employee: ");
			designation=sc.next();
			if(designation.equals("SE") || designation.equals("SSE")
					|| designation.equals("SS")|| designation.equals("SSS")) {
				
			}else {
				throw new DesignationException();
			}
			}
			catch( UserNotFound e) {
				System.out.println("\t"+e);
			}
			catch(DesignationException e) {
				System.out.println("\t"+e);
			}
			
			
   		  	tempEmp.setDesignation(designation);
   		  
   		  	if(tempDao.modifyDesignation(tempEmp)) {
   		  		System.out.println("\n\t------------(: Modification done Successfully :)------------");
   		  	}
   		}
		
		
		public static void showMySalary() {
			 EmployeeSalaryDaoClass tempDao = new EmployeeSalaryDaoClass();
			 Date date = new Date();
			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 EmployeeSalary tempEmp =new EmployeeSalary();
			 System.out.print("\n\tEnter ID of Employee: ");
    		 eCode=sc.nextInt();
    		 tempEmp.seteCode(eCode);
    		 try {
    		 if(tempDao.checkFunction(tempEmp)) { 
    			 EmployeeSalary tempSal = tempDao.showMySalary(tempEmp);
    			 System.out.println("\n\t\t\t____________________ZENSAR____________________"); 
    			 System.out.println("\t\t\t\t\t\t\tDate: "+formatter.format(date));
    			 System.out.println("\t\tEmployee  Code: "+tempSal.geteCode());
    			 System.out.println("\t\tEmployee Name: " +tempSal.geteName());
    			 System.out.println("\t\tEmployee Designation :"+tempSal.getDesignation());
    			 System.out.println();
    			 System.out.println("\t\tBasic Salary: "+tempSal.getBasicPay());
    			 System.out.println("\t\tHRA: "+tempSal.getHRA());
    			 System.out.println("\t\tDA: "+tempSal.getDA());
    			 System.out.println("\t\tsalary: "+tempSal.getSalary());
    		 }
    		 else {
 				throw new UserNotFound();
    		 }
    		  }catch(UserNotFound e1) {
    		  		System.out.println(e1);
    		  }
    	}
		
		//displayAll
		public static void displayAll() {
			ArrayList<Employee> arr = new ArrayList<Employee>();
			arr = tempDao.DisplayAll();
			boolean statu=false;
			Iterator<Employee> it = arr.iterator();
			int count=1;
			while(it.hasNext()) {
				Employee e= it.next();
				statu=true;
				System.out.println("\n\t\tEmployee "+ count+": ");
				System.out.println("\t\tID: " + e.geteCode());
				System.out.println("\t\tName:"+e.geteName());
				System.out.println("\t\tDesignation: "+ e.getDesignation());
				System.out.println("\t\tAge: "+e.getAge());
				System.out.println("\t\tBasic Salary: "+e.getBasicPay());
				System.out.println("___________________________________________________________________");
				count++;
			}
			if(!statu) {
				System.out.println("\tNo Record Found!!");
			}
		}
			
		public static void displayOne() {
			Employee e  = new Employee();
			tempEmp = new Employee();
			System.out.print("\nEnter ID: ");
   		  	eCode=sc.nextInt();
   		  	tempEmp.seteCode(eCode);
   		  	try {
			e = tempDao.DisplayOne(tempEmp);
			if(tempDao.checkFunction(tempEmp)) {
				System.out.println("\n\t\t_______________________Employee Information________________________");
				System.out.println("\tID: " + e.geteCode());
				System.out.println("\tName:"+e.geteName());
				System.out.println("\tDesignation: "+ e.getDesignation());
				System.out.println("\tAge: "+e.getAge());
				System.out.println("\tBasic Salary: "+e.getBasicPay());
		 }
		else {
				throw new UserNotFound();
		}
   		  }catch(UserNotFound e1) {
   		  		System.out.println(e1);
   		  }

		}//endOf one
}
