package services;


import java.util.HashMap;
import java.util.List;
import java.util.Set;

import dao.MySqlImplementation;
import models.Employee;

import java.io.IOException;
import java.sql.SQLException;

public class Service 
{
     private MySqlImplementation ms=new MySqlImplementation();
     
     public void create(Employee e) throws SQLException, IOException
     {
    	ms.initDB();
    	 
    	 int count=ms.create(e);
    	 
    	 if(count>0)
    	 {
    		 System.out.println("Employee is inserted");   		 
    	 }
    	 else
    	 {
    		 System.out.println("error while inserting employee details");
    	 }
	    ms.closeDB();
    	 
     }
     
     public void update(Employee e) throws SQLException,IOException 
     {
        
    	 ms.initDB();
    	  int count=ms.update(e);
    	  
    	  if(count>0)
    	  {
    		  System.out.println("Employee details are updated");
    	  }
    	  else
    	  {
    		  System.out.println("error while updating details");
    	  }
    	  ms.closeDB();
    	 
     }
     
     public void deleteByEmail(String emailId) throws SQLException, IOException 
     {
    	 ms.initDB();
    	  int count=ms.deleteByEmail(emailId);
    	  
    	  if(count>0)
    	  {
    		  System.out.println("employee details got deleted");
    	  }
    	  else
    	  {
    		  System.out.println("error while deleting");
    	  }
    	 
     }
     
     public Employee getEmployeeByEmail(String emailId) throws SQLException,IOException
     {
    	 ms.initDB();
    	 
    	 Employee e1= ms.getEmployeeByEmail(emailId);
    	 //System.out.println(e1.toString());
    	 ms.closeDB();
    	 return e1;
    	 
    	 
     }
     
     public List<Employee> getAllEmployees() throws SQLException,IOException
     {
    	 ms.initDB();
    	 
    	 List<Employee> employeeList=ms.getAllEmployees();
    	 
    	 //employeeList.forEach(employee -> System.out.println(employee));
    	 //ms.getAllEmployees().forEach(employee-> System.out.println(employee));
    	 
    	 
    	 ms.closeDB();
    	 return employeeList;
    	 
     }
     
     public Set<Employee> getAllEmployeesSortByEmailId() throws SQLException,IOException
     {
    	 ms.initDB();
    	 
    	 Set<Employee> employeeSet=ms.getAllEmployeesSortByEmailId();
    	 
    	// employeeSet.forEach(employee-> System.out.println(employee));
    	 
    	 ms.closeDB();
    	 return employeeSet;
     }
     
     
     
    public void searchEmployee(String email) throws SQLException, IOException
    {
    	HashMap<String,Employee> employeeTable=ms.getEmployeeTable();
    	Employee e1=employeeTable.get(email);
    	if(e1!=null)
    	{
    		System.out.println(" employee found");
    		System.out.println(e1);
    		
    	}
    	else
    	{
    		ms.initDB();
    		
    		Employee e2=ms.getEmployeeByEmail(email);
    		ms.closeDB();
    		
    		if(e2!=null)
    		{
    			System.out.println("employee found");
    			System.out.println(e2);
    		}
    		else
    		{
    			System.out.println("employee not found");
    		}
    	}
    }
    
  public void exit() throws SQLException, IOException
  {
	  ms.closeDB();
  }
     
}



