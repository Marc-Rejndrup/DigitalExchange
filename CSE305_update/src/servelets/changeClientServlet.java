package servelets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changeClientServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		  HttpSession session=request.getSession();  
		  
		  
		          String stuId = ""+session.getValue("login");
		          

		          
		  		String ssn = request.getParameter("clientssn");
				String name = request.getParameter("clientname");
				String address = request.getParameter("clientaddress");
				String zipcode = request.getParameter("clientzipcode");
				String telephone = request.getParameter("clienttelephone");
				String email = request.getParameter("clientemail");
				String creditcard = request.getParameter("clientcreditcard");
				String rating = request.getParameter("clientrating");
				
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
		            			if(!name.equals(""))
		            				stmt1.executeUpdate("update Person set Name='"+name+"' where ssn='"+ssn+"'");
		            			if(!address.equals(""))
		            				stmt1.executeUpdate("update Person set Zipcode='"+address+"' where ssn='"+ssn+"'");
		            			if(!zipcode.equals(""))
		            				stmt1.executeUpdate("update Person set Zipcode='"+zipcode+"' where ssn='"+ssn+"'");
		            			if(!telephone.equals(""))
		            				stmt1.executeUpdate("update Person set Telephone='"+telephone+"' where ssn='"+ssn+"'");
		            			if(!email.equals(""))
		            				stmt1.executeUpdate("update Client set Email='"+email+"' where Id='"+ssn+"'");
		            			if(!creditcard.equals(""))
		            				stmt1.executeUpdate("update Client set CreditCardNumber='"+creditcard+"' where Id='"+ssn+"'");
		            			if(!rating.equals(""))
		            				stmt1.executeUpdate("update Client set Rating='"+rating+"' where Id='"+ssn+"'");
		            			
					} catch(Exception e)
					{
						e.printStackTrace();
					
					}
					finally{
					
						try{conn.close();}catch(Exception ee){};
					}
		 
		   

		  
		  
		  
		  
		  
		  
		  RequestDispatcher view = request.getRequestDispatcher("FacultyInformation.jsp");
	      view.forward(request, response);    
	    }
}