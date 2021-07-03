package models;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class Employee extends Object implements Comparable<Employee> {

	
	

		private String name;
		private String age;
		private String sal;
		private String desig;
		private String emailId;
		private int id,deptno;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		

		public Employee() {
		// TODO Auto-generated constructor stub
	      }

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getSal() {
			return sal;
		}
		public void setSal(String sal) {
			this.sal = sal;
		}
		public String getDesig() {
			return desig;
		}
		public void setDesig(String desig) {
			this.desig = desig;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		
		@Override
		public int hashCode() 
		{
			return id;
		}

		@Override
		public String toString() {
			return "\nName: "+this.name +"\nEmailId: "+ this.emailId +"\nAge: "+this.age+ " \nSalary: "+this.sal+ " \nDesignation:"
					+this.desig + " \nDepartmentNo: "+ this.deptno;
		}
		
		@Override
		public boolean equals(Object obj) 
		{
			Employee u1 = (Employee)obj;
			
			String e1 = u1.getEmailId();
			String e2 = this.emailId;
			
		
		  boolean b1=e1.equals(e2);
			
			return  b1;
			
		}

		@Override
		public int compareTo(Employee e) 
		{
	        Employee u1 = (Employee)e;
			
			String e1 = u1.getEmailId();
			String e2 = this.emailId;	
			
			int res = e1.compareTo(e2);
			return res;
		}
		public void insert() throws IOException,SQLException
		{
			System.out.println("Enter name");
	        setName(br.readLine());

	        System.out.println("Enter age");
	        setAge(br.readLine());

	        System.out.println("Enter DepartmentNo");
	        setDeptno(Integer.parseInt(br.readLine()));

	        System.out.println("Enter Email id");
	        setEmailId(br.readLine());

		}
		
		
	}


