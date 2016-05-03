
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrderServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  HttpSession session=request.getSession();  
		  
		  
		          String stuId = ""+session.getValue("login");
		          
		  		String nooid = request.getParameter("nooid");
				String nocid = request.getParameter("nocid");
		  		String nostock = request.getParameter("nostock");
		  		String nonumshares = request.getParameter("nonumshares");
		  		String nopps = request.getParameter("nopps");
		  		//String nodatetime = request.getParameter("nodatetime");
		  		String nopricetype = request.getParameter("nopricetype");
		  		String nopercentage = request.getParameter("nopercentage");
		  		String noordertype = request.getParameter("group1");

		     	String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		     	String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		      	String mysUserID = "root"; 
		      	String mysPassword = "1234";

				Date d1 = new Date(System.currentTimeMillis());
				String d2 = "" + d1.getYear() + "-" + d1.getMonth() + "-" + d1.getDay();

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
									stmt1.executeUpdate("insert into Orders VALUES"
											+ "('"+nonumshares+"', '"+nopps+"', '"+nooid+"', '"+d2+"', '"+nopercentage+"', "
													+ "'"+nopricetype+"', '"+noordertype+"', '"+nocid+"', '"+nostock+"')");
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
