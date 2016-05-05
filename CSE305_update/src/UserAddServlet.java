
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import other.User;

public class UserAddServlet extends HttpServlet {

	public static String join(List<String> list, String delim) {

		StringBuilder sb = new StringBuilder();

		String loopDelim = "";

		for(String s : list) {

			sb.append(loopDelim);
			sb.append(s);            

			loopDelim = delim;
		}

		return sb.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("useradd");
		HttpSession session=request.getSession();  
		System.out.println(session.getValue("login"));



		List<User> users = new ArrayList<User>();

		User user = new User();


		user.setId(4);
		user.setName("name");

		users.add(user);

		session.setAttribute("users", users);

		// person attributes
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		String Name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String address = request.getParameter("address");
		
		
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
			
			stmt1.executeUpdate("insert into Person values('"+Name+"', '"+address+"', '"+zipcode+"', '"+telephone+"', '"+ssn+"')");

			if (request.getParameter("target").trim().equals("client"))
			{
				// client specific
				String email = request.getParameter("email");
				String creditcard = request.getParameter("creditcard");
				
				stmt1.executeUpdate("insert into Client values('"+email+"', '"+ssn+"', '"+creditcard+"', 1, '"+ssn+"')");
				
				java.sql.ResultSet rs = stmt1.executeQuery("select coalesce(max(AccNum), 0) from Account");
				rs.next();
								
				int accnum = Integer.parseInt(rs.getString(1)) + 1;
				
				accnum=ssn;
				
				stmt1.executeUpdate("insert into Account values('"+accnum+"', '"+ssn+"', NULL, DATE_FORMAT(NOW(),'%Y-%m-%d'))");
				
				stmt1.close();
				rs.close();
			}
			else
			{			
				// employee specific
				double hourlyrate = Double.parseDouble(request.getParameter("hourlyrate"));
				String manager = request.getParameter("manager");
				
				stmt1.executeUpdate("insert into Employee values('"+hourlyrate+"', DATE_FORMAT(NOW(),'%Y-%m-%d'), '"+ssn+"', '"+ssn+"', '"+manager+"')"); 
				
				java.sql.ResultSet rs = stmt1.executeQuery("select coalesce(max(AccNum), 0) from Account");
				rs.next();
								
				int accnum = Integer.parseInt(rs.getString(1)) + 1;
				
				accnum=ssn;
				
				stmt1.executeUpdate("insert into Account values('"+accnum+"', NULL, '"+ssn+"', DATE_FORMAT(NOW(),'%Y-%m-%d'))");

				stmt1.close();
				rs.close();
			}
		} catch(Exception e)
		{
			e.printStackTrace();

		}
		finally{

			try{conn.close();}catch(Exception ee){};
		}

		RequestDispatcher view = request.getRequestDispatcher("useradd.jsp");
		view.forward(request, response);    
	}


}