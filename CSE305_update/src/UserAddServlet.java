
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

		//request.setAttribute("student", student);

		session.setAttribute("users", users);

		int Id = Integer.parseInt(request.getParameter("Id"));
		String Name = request.getParameter("Name");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String address = request.getParameter("address");
		String creditcard = request.getParameter("creditcard");
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
			if (request.getParameter("target").trim().equals("student"))
			{
				stmt1.executeUpdate("insert into Person values('"+Id+"', '"+Name+"', '"+address+"', '"+zipcode+"', '"+telephone+"')");
				stmt1.executeUpdate("insert into Client values('"+email+"', 1, '"+creditcard+"', '"+Id+"')");
				stmt1.close();
			}
			else
			{
				stmt1.executeUpdate("insert into Person values('"+Id+"', '"+Name+"', '"+address+"', '"+zipcode+"', '"+telephone+"')");
				stmt1.executeUpdate("insert into Employee values('"+Id+"', '"+Id+"', DATE_FORMAT(NOW(),'%Y-%m-%d'), 0)"); 
				System.out.println("Id:		"+Id);

				//							out.print("insert into Professor values('"+Id+"','"+Password1+"','"+Name+"','"+request.getParameter("DepID")+"')");;
				stmt1.close();
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