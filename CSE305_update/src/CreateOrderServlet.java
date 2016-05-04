
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
		          
		  		String accNum = request.getParameter("accNum");
				String orderID = request.getParameter("orderID");
		  		String orderType = request.getParameter("orderType");
		  		String numShares = request.getParameter("numShares");
		  		String dateTrans = request.getParameter("dateTrans");
		  		String fee = request.getParameter("fee");
		  		String priceType = request.getParameter("priceType");
		  		String price = request.getParameter("price");
		  		String percent = request.getParameter("percent");
		  		String stockSymbol = request.getParameter("stockSymbol");
		  		String booleanFilled = request.getParameter("booleanFilled");
		  		String employeeNumber = request.getParameter("employeeNumber");

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
											+ "('"+accNum+"', '"+orderID+"', '"+orderType+"', '"+numShares+"', '"+dateTrans+"', "
													+ "'"+fee+"', '"+priceType+"', '"+price+"', '"+percent+"', '"+stockSymbol
													+"', '"+booleanFilled+"', '"+employeeNumber+"')");
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
