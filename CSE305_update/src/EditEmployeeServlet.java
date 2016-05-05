
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * Servlet to EDIT AND DELETE an employee, his accounts, and his person
 */
public class EditEmployeeServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		  HttpSession session=request.getSession();  
		  
		  
		          String stuId = ""+session.getValue("login");
		          

		  		String ssn = request.getParameter("act");
		  		String delete = request.getParameter("delete");
				String name = request.getParameter("name" + ssn);
				String address = request.getParameter("address" + ssn);
				String zipcode = request.getParameter("zipCode" + ssn);
				String telephone = request.getParameter("telephone" + ssn);
				String hourlyrate = request.getParameter("hourlyRate" + ssn);
				
		     	String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		     	String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		      	String mysUserID = "root"; 
		      	String mysPassword = "1234";


		      	
					java.sql.Connection conn=null;
					try 
					{
		            	Class.forName(mysJDBCDriver).newInstance();
		    			java.util.Properties sysprops=System.getProperties();
		    			sysprops.put("user",mysUserID);
		    			sysprops.put("password",mysPassword);
		        
						//connect to the database
		            			conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
		            			System.out.println("Connected successfully to database using JConnect");
		            
	            				java.sql.Statement stmt1=conn.createStatement();

		            			if(ssn != null){
		            				stmt1.executeUpdate("update Person set Name='"+name+"' where ssn='"+ssn+"'");
		            				stmt1.executeUpdate("update Person set Address='"+address+"' where ssn='"+ssn+"'");
		            				stmt1.executeUpdate("update Person set Zipcode='"+zipcode+"' where ssn='"+ssn+"'");
		            				stmt1.executeUpdate("update Person set Telephone='"+telephone+"' where ssn='"+ssn+"'");
		            				stmt1.executeUpdate("update Employee set HourlyRate='"+hourlyrate+"' where ssn='"+ssn+"'");
		            			}
		            			else{
		            				/*
		            				stmt1.executeUpdate("delete from orders where AccNum='"+delete+"'");
		            				stmt1.executeUpdate("delete from account where empNum='"+delete+"'");
		            				stmt1.executeUpdate("delete from employee where ssn='"+delete+"'");
		            				stmt1.executeUpdate("delete from person where ssn='"+delete+"'");
		            				System.out.println("All traces of employee " + delete + " have been removed!");*/
		            			}
		            				
		            			
					} catch(Exception e)
					{
						e.printStackTrace();
					
					}
					finally{
					
						try{conn.close();}catch(Exception ee){};
					}
		 

		  
		  
		  RequestDispatcher view = request.getRequestDispatcher("managerEmployee.jsp");
	      view.forward(request, response);    
	    }
}