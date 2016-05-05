

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
import dataType.DataTypeStock;

/*
 * This servlet will get all recent stock information with post
 */

public class ClientStockServlet extends HttpServlet {//might need to handle doGet.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	HttpSession session=request.getSession();
	 	String loginID = ""+session.getAttribute("login");
		String accountID = ""+session.getAttribute("account");
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";
		//get Parameters
		//String x = request.getParameter("x");
		String symbol = request.getParameter("stockSymbol");
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
			rs = stmt1.executeQuery("select * from stock where symbol='"+symbol+"' order by date desc");
			List<DataTypeStock> list = new ArrayList<DataTypeStock>();
			while(rs.next()){
				DataTypeStock data = new DataTypeStock();
				data.setSymbol(rs.getString(1));
				data.setDate(rs.getString(4));
				data.setPrice(rs.getString(5));
				list.add(data);
			}
			request.getSession().setAttribute("ClientStockHistoryTable", list);
			rs.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("clientStock.jsp");
		view.forward(request, response);    
	}
}