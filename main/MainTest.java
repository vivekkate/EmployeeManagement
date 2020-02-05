package com.zensar.emdb.main;
import java.util.Scanner;


public class MainTest{
	
	public static void main(String[] args) {
	
			Scanner sc = new Scanner(System.in);
			int choice,ch;
			char continueMenu;
			
			do {
				System.out.println("\n\t******************* Main Menu *******************");
				System.out.println("\t\t1.HR ");
				System.out.println("\t\t2.Employee ");
				System.out.println("\t\t3.Quit");
				System.out.print("\tEnter your choice: ");

				ch = sc.nextInt();



				switch(ch) {
				case 1:
				{
	        	do {
	        		System.out.println("\n\t******************* HR Menu *******************");
	        		System.out.println("\t\t1.Insert new Employee ");
	        		System.out.println("\t\t2.Delete Existing Employee ");
	        		System.out.println("\t\t3.Modify Salary of Employee ");
	        		System.out.println("\t\t4.Modify Designation of Employee ");
	        		System.out.println("\t\t5.Display ALL ");
	        		System.out.print("\tEnter your choice: ");
	        		choice=sc.nextInt();
	        		switch(choice) {
	        		case 1:
	        			allFunctions.insert();
	        			break;
	        		case 2:
	        			allFunctions.delete();
	        			break;
	        		case 3:
	        			allFunctions.modifySalary();
	        			break;
	        		case 4:
	        			allFunctions.modifyDesignation();
	        			break;
	        		case 5:
	        			
	        			allFunctions.displayAll();
	        			break;
	        		case 6: 
	   	        	 //System.out.println("\n\t******************* Thank You *******************");
	   	        	 break;
	        		 default:
	 	        		System.out.println("\n\tEnter valid option. Try again!!!");
	 	        		break;
	        	 }
	        	System.out.print("\n\tDo you Want to Continue HR Menu(y/n): ");
	        	continueMenu = sc.next().charAt(0);
	        	}while(continueMenu == 'y' || continueMenu == 'Y');
	        	break;
	         }//endOf case1 
	         
	         case 2:
	           {
	        	   do {
	        		   System.out.println("\n\t*******************Employee Menu ******************* ");
	        		   System.out.println("\t\t1.Display my Details ");
	        		   System.out.println("\t\t2.Display my Salary slip");
	        		   System.out.print("\t\tEnter your choice: ");
	        		   int ch2;
	        		   ch2=sc.nextInt();
	        		   switch(ch2) {
	        		   case 1:
	        			   allFunctions.displayOne();
	        			   break;

	        		   case 2:
	        			   allFunctions.showMySalary();
	        			   break;
		       		   default:
	   	        			System.out.println("\n\tEnter valid option. Try again!!!");
	   	        			break;
	   	        		
	        		   }//endOf  inner switch
	        		   
	        		   System.out.print("\n\tDo you Want to Continue Employee Menu(y/n): ");
	   	        	continueMenu = sc.next().charAt(0);
	   	        	}while(continueMenu == 'y' || continueMenu == 'Y');
	        	   break;
	           }//endOf case 2
	           
	         case 3: 
	        	 System.out.println("\n\t******************* Thank You *******************");
	        	 System.exit(0);
	        default:
	        		System.out.println("\n\tEnter valid option. Try again!!!");
	        }//endOf outer switch
	     System.out.print("\n\tDo you Want to Continue main menu(y/n): ");
	     continueMenu = sc.next().charAt(0);
		}while(continueMenu == 'y' || continueMenu == 'Y'); //endOf Do 
	}//end of main
}//end of class




