import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changeStockServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  HttpSession session=request.getSession();  
		  
		  
		          String stuId = ""+session.getValue("login");
		          

		  		String amt = request.getParameter("amount");
				String symbol = request.getParameter("stocksym");
		     	String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		     	String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		      	String mysUserID = "root"; 
		      	String mysPassword = "1234";


		      	System.out.println(amt);
		      	System.out.println(symbol);
		      	
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
									stmt1.executeUpdate("update Stock set PricePerShare='"+amt+"' where StockSymbol='"+symbol+"'");
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
