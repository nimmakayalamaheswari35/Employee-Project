package frontpage;



import java.util.List;
import java.util.Scanner;
import java.util.Set;


import models.*;

import services.Service;



public class Main
{
	
	public static void main(String[]args)
	{
       Service s=new Service();
       Scanner sc=new Scanner(System.in);
      
       System.out.println("1. Menu");
       System.out.println("Enter any key to exit");
       String choice=sc.next();
       
       if(choice.equals("1")==false)
       {
    	   System.out.println("Thank you");
    	   System.exit(0);
       }
       while(choice.equals("1"))
       {
    	   try
    	   {
    		   System.out.println("1. Insert/create Employee Details");
    		   System.out.println("2. Update Employee Details");
    		   System.out.println("3. Delete Employee Details");
    		   System.out.println("4. Show Employee Details");
    		   System.out.println("5.Raise Salary");
    		   System.out.println("Any key to Exit");
    		   
    		   String choice2=sc.next();
    		   
    		   switch(choice2)
    		   {
    		      case "1": //Employee e1=new Employee();
    		                System.out.println("\nChoose the employee you want to create:");
    		                System.out.println("\n1.Clerk \n2.Programmer \n3.Manager");
    		                int ch=sc.nextInt();
    		                 
    		                if(ch==4)
    		                {
    		                	System.out.println("Exiting---");
    		                	System.exit(0);	
    		                }
    		                switch(ch)
    		                {
    		                case 1:  Employee e1=new Clerk();      
    		                	     e1.insert();
    		                          s.create(e1);
    		                          break;
    		                case 2: e1=new Programmer();
   		                             e1.insert();
   		                            s.create(e1);
   		                            break;
    		                case 3:  e1=new Manager();
	                                 e1.insert();
	                                 s.create(e1);
	                                  break;
    		                }         
    		                
    		                break;
    		      case "2": Employee e2=new Employee();
    		    	          System.out.println("Enter name");
    		    	          e2.setName(sc.next());
    		    	          
    		    	          System.out.println("Enter age");
    		    	          e2.setAge(sc.next());
    		    	          
    		    	          System.out.println("Enter email id");
    		    	           e2.setEmailId(sc.next());
    		    	           
    		    	           s.update(e2);
    		    	           break;
    		      case "3": System.out.println("Enter email");
    		                String email=sc.next();
    		                
    		               s.deleteByEmail(email);
    		               break;
    		         
    		      case "4":System.out.println("\n1.Show particular employee details using email id\n 2. Show all Employees \n3. Show sorted Employee details");
                           int otpn=sc.nextInt();
                           switch(otpn)
                           {
                           case 1: System.out.println("Enter email");
                                    String email1=sc.next();
                                    
                                    Employee e=s.getEmployeeByEmail(email1);
                                    System.out.println(e.toString());
                                    break;
                                    
                           case 2: System.out.println("Displaying all the employees in the table");
                                    List<Employee> employeeList=s.getAllEmployees();
                                    employeeList.forEach(employee -> System.out.println(employee));
                        	         break;
                        	       
                           case 3: System.out.println("Displaying all the employee details sorted by emailId");
                                   Set<Employee> employeeSet=s.getAllEmployeesSortByEmailId();
                                   employeeSet.forEach(employee->System.out.println(employee));
                                   break;
                           }
                           break;
    		      default : System.out.println("Exiting.......");
    		                System.exit(0);
    		              
    		   }
    		   
    	   }
    	   catch(Exception sqle)
    	   {
    		   sqle.printStackTrace();
    	   }
       }
       
	}
}


