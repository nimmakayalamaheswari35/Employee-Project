package dao;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import models.Employee;


public class MySqlImplementation implements Dao {

	
	    Connection con=null;
	    Statement st=null;
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    
	    private HashMap<String,Employee> employeeTable=new HashMap<String,Employee>();
	    
	   
		
		public HashMap<String, Employee> getEmployeeTable() {
			return employeeTable;
		}
		

		public void setEmployeeTable(HashMap<String, Employee> employeeTable) {
			this.employeeTable = employeeTable;
		}

		@Override
		public void initDB() throws SQLException, IOException {
			// TODO Auto-generated method stub
			try {
				Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driver class loaded");
	         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahi","root","Mahi@1122");  
	        System.out.println("got database connection");
	        st=con.createStatement();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		}
		
		@Override
		public void closeDB() throws SQLException {
			
			con.close();
		}
	    

		@Override
		public int create(Employee e) throws SQLException
		{
		
			pst=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			String get_empid="select coalesce((select max(id)+1 from employee),1) as getid";
			
			rs=pst.executeQuery(get_empid);
			rs.next();
			
			pst.setInt(1, rs.getInt("getid"));
			pst.setString(2, e.getName());
			pst.setString(3, e.getAge());
			pst.setString(4,e.getSal(																																																																																	));
			pst.setString(5, e.getDesig());
			pst.setString(7, e.getEmailId());
			pst.setInt(6, e.getDeptno());
			
			int count= pst.executeUpdate();
			
			return count;
		}

		@Override
		public int update(Employee e) throws SQLException {
			
			pst=con.prepareStatement("update employee set age=? where emailId=? and name=? ");
			
			pst.setString(2, e.getEmailId());
			pst.setString(3, e.getName());
			pst.setString(1,e.getAge());
			
			int count=pst.executeUpdate();
			
			return count;
		}

		@Override
		public int deleteByEmail(String emailId) throws SQLException 
		{
			pst=con.prepareStatement("delete from employee where emailId=?");
			
			pst.setNString(1, emailId);
			int count=pst.executeUpdate();
			
			return count;
		}
		

		@Override
		public int deleteById(int id) throws SQLException {
			
			pst=con.prepareStatement("delete from employee where id=?");
			pst.setInt(1, id);
			int count=pst.executeUpdate();
			
			return count;
		}

		@Override
		public Employee getEmployeeByEmail(String emailId) throws SQLException {
			
			pst=con.prepareStatement("select * from employee where emailId=?");
			pst.setString(1, emailId);
			 
			rs=pst.executeQuery();
			rs.next();
			
			Employee e1=new Employee();
			e1.setEmailId(rs.getString(7));
			e1.setName(rs.getString(2));
			e1.setAge(rs.getString(3));
			e1.setSal(rs.getString(4));
			e1.setDesig(rs.getString(5));
			e1.setDeptno(rs.getInt(6));
			
			
			return e1;
		}

		@Override
		public List<Employee> getAllEmployees() throws SQLException {
			
			pst=con.prepareStatement("select * from employee");
			
			rs=pst.executeQuery()
	;
			List<Employee> employeeList=new LinkedList<Employee>();
			
			while(rs.next())
			{
				int columnIndex=2;
				
				Employee e1=new Employee();
				String name=rs.getString(columnIndex);
				
				e1.setName(name);
				columnIndex++;
				
				e1.setAge(rs.getString(columnIndex++));
				e1.setSal(rs.getString(columnIndex++));
				e1.setDesig(rs.getString(columnIndex++));
				e1.setDeptno(rs.getInt(columnIndex++));
				e1.setEmailId(rs.getString(columnIndex++));
				
				employeeList.add(e1);
				
				
			}
			
			return employeeList;
		}

		@Override
		public Set<Employee> getAllEmployeesSortByEmailId() throws SQLException {
	pst=con.prepareStatement("select * from employee");
			
			rs=pst.executeQuery()
	;
			Set<Employee> employeeSet=new TreeSet<Employee>();
			
			while(rs.next())
			{
				int columnIndex=2;
				
				Employee e1=new Employee();
				String name=rs.getString(columnIndex);
				
				e1.setName(name);
				columnIndex++;
				
				e1.setAge(rs.getString(columnIndex++));
				e1.setSal(rs.getString(columnIndex++));
				e1.setDesig(rs.getString(columnIndex++));
				e1.setDeptno(rs.getInt(columnIndex++));
				e1.setEmailId(rs.getString(columnIndex++));
				
				employeeSet.add(e1);
				
				
			}
			
			return employeeSet;
		}


		
		}

		
		
		
	


