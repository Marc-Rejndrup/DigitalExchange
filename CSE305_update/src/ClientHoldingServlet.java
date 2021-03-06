
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dataType.DataTypeHolding;
public class ClientHoldingServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	HttpSession session=request.getSession();
	 	//always
		String loginID = ""+session.getAttribute("login");
		String accountID = ""+session.getAttribute("account");
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";
		System.out.println("REACHED");
		//end always
		//get Parameters
		//String ssn = request.getParameter("empssn");
		java.sql.Connection conn = null;
		try {
			System.out.println("your account ID: " + accountID);
			Class.forName(mysJDBCDriver).newInstance();
			java.util.Properties sysprops=System.getProperties();
			sysprops.put("user",mysUserID);
			sysprops.put("password",mysPassword);
			conn = java.sql.DriverManager.getConnection(mysURL,sysprops);
			System.out.println("Connected successfully to database using JConnect");

			java.sql.Statement stmt1=conn.createStatement();
			java.sql.ResultSet rs = stmt1.executeQuery("SELECT * FROM HOLDING WHERE AccNum = " + loginID);
			List<DataTypeHolding> list = new ArrayList<DataTypeHolding>();
			while(rs.next()){
				DataTypeHolding data = new DataTypeHolding();
				data.setAccNum(rs.getString(1));
				data.setSymbol(rs.getString(2));
				data.setAmount(rs.getString(3));
				list.add(data);
			}
			request.getSession().setAttribute("HoldingTable", list);
			rs.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("clientHolding.jsp");
		view.forward(request, response);    
	}
}