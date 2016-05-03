package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataType.DataTypeStock;

public class PersonalizedStockServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String getsym = request.getParameter("getsym");
		String custnum = request.getParameter("custnum");
		
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
   	  	String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
   	  	String mysUserID = "root"; 
   	  	String mysPassword = "1234";
   	  	
   	  	
   	// code start here
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
   	            			
   	            			List<DataTypeStock> list = new ArrayList<DataTypeStock>();
   	            			
   	            			java.sql.Statement stmt1=conn.createStatement();
   	            			java.sql.ResultSet rs = stmt1.executeQuery(
	   	            		"SELECT * FROM Stock AS S WHERE S.Type LIKE "
	   	            		+ "( SELECT X.Type "
	   	            		+ "  FROM ( SELECT S.Type, H.Quantity "
	   	            		+ "         FROM Holding AS H, Stocks AS S, Account AS A "
	   	            		+ "         WHERE H.AccNum = A.AccNum AND H.Symbol = S.Symbol AND A.CustNum = "+custnum+" "
	   	            				+ " GROUP BY S.Type) AS X "
	   	            		+	"WHERE X.QUANTITY = (SELECT MAX(Quantity) FROM X));"
	   	            			
   	            			);
   	            			
   	            			while(rs.next()){
   	            				DataTypeStock data = new DataTypeStock();
   	            				data.setSymbol(rs.getString(1));
   	            				data.setName(rs.getString(2));
   	            				data.setType(rs.getString(3));
   	            				data.setPrice(rs.getString(4));
   	            				data.setDate(rs.getString(5));
   	            				
   	            				list.add(data);
   	            			}
   	            			
   	            			request.setAttribute("stockinfo", list);
   	            			rs.close();
   	            			conn.close();
   	            			
   				} catch(Exception e)
   				{
   					e.printStackTrace();
   					
   				}
   				finally{
   				
   					try{conn.close();}catch(Exception ee){};
   				}
   			
   			
   			
   			
   			RequestDispatcher view = request.getRequestDispatcher("orderlist.jsp");
   			view.forward(request, response);
   		}

	
}	