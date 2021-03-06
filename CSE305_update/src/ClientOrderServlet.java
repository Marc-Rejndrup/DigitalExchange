

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dataType.DataTypeOrder;


public class ClientOrderServlet extends HttpServlet {//might need to handle doGet.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	HttpSession session=request.getSession();
		String loginID = ""+session.getAttribute("login");
		String accountID = ""+session.getAttribute("account");
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";

		String accNum = request.getParameter("custNum");
		
		System.out.println("REACHED, custnum = " + accNum);
		
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
			rs = stmt1.executeQuery("SELECT * FROM orders WHERE AccNum = '"+accNum+"'");
			List<DataTypeOrder> list = new ArrayList<DataTypeOrder>();
			while(rs.next()){
				DataTypeOrder data = new DataTypeOrder();
				data.setAccountId(rs.getString(1));
				data.setId(rs.getString(2));
				data.setBuySell(rs.getString(3));
				data.setNumShares(rs.getString(4));
				data.setDateTime(rs.getString(5));
				data.setFee(rs.getString(6));
				data.setStock(rs.getString(7));
				data.setPricePerShare(rs.getString(8));
				data.setPercentage(rs.getString(9));
				data.setPrice(rs.getString(10));
				data.setOrderType(rs.getString(11));
				list.add(data);
			}
			request.getSession().setAttribute("ClientOrderTable", list);
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("clientOrder.jsp");
		view.forward(request, response);    
	}
}