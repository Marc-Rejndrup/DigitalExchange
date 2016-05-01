import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerateEmailServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
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
            
            			java.sql.Statement stmt1=conn.createStatement();
            			
            			java.sql.ResultSet rs;
            			
            			rs = stmt1.executeQuery("select Email from Client");


            			List<String> list = new ArrayList<String>();
            			
            			while(rs.next()){
            				list.add(rs.getString(1));
            			}
            			
            			request.setAttribute("emaillist", list);
            			rs.close();
            			conn.close();
            			
			} catch(Exception e)
			{
				e.printStackTrace();
				
			}
			finally{
			
				try{conn.close();}catch(Exception ee){};
			}
		
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("maillist.jsp");
		view.forward(request, response);
	}
}
