

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataType.DataTypeClient;
import dataType.DataTypeEmployee;
import dataType.DataTypeHolding;

public class ManagerClientServlet extends HttpServlet {//might need to handle doGet.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	HttpSession session=request.getSession();
		String loginID = ""+session.getAttribute("login");
		String accountID = ""+session.getAttribute("account");
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";
		//get Parameters
		//String x = request.getParameter("y");
		java.sql.Connection conn = null;
		try {
			Class.forName(mysJDBCDriver).newInstance();
			java.util.Properties sysprops=System.getProperties();
			sysprops.put("user",mysUserID);
			sysprops.put("password",mysPassword);
			conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
			System.out.println("Connected successfully to database using JConnect");
			java.sql.ResultSet rs;
			java.sql.Statement stmt1=conn.createStatement();
			rs = stmt1.executeQuery("SELECT * FROM Client AS c, Person AS p WHERE c.ssn = p.ssn");
			List<DataTypeClient> list = new ArrayList<DataTypeClient>();
			while(rs.next()){
				DataTypeClient data = new DataTypeClient();
				data.setEmail(rs.getString(1));
				data.setCustNum(rs.getString(2));
				data.setCreditCard(rs.getString(3));
				data.setRating(rs.getString(4));
				data.setName(rs.getString(6));
				data.setAddress(rs.getString(7));
				data.setZipCode(rs.getString(8));
				data.setTelephone(rs.getString(9));
				list.add(data);
			}
			request.getSession().setAttribute("ManagerClientTable", list);
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("managerClient.jsp");
		view.forward(request, response);    
	}
}