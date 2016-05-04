

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
import dataType.DataTypeStock;

public class ClientHistoryServlet extends HttpServlet {//might need to handle doGet.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	HttpSession session=request.getSession();
		String loginID = ""+session.getAttribute("login");
		String accountID = ""+session.getAttribute("account");
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";
		//get Parameters
		String orderId = request.getParameter("OrderId");
		String stockSym = request.getParameter("stockSym");
		
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
			if(orderId != null){
				//get the relevant order.
				rs = stmt1.executeQuery("SELECT OrderType, NumShares, Date, Fee, Symbol, Price, Percent, FilledPrice FROM Order WHERE OrderId = "+ orderId);
				DataTypeOrder o = new DataTypeOrder();
				o.setOrderType(rs.getString(1));
				o.setNumShares(rs.getString(2));
				o.setDateTime(rs.getString(3));
				o.setFee(rs.getString(4));
				o.setStock(rs.getString(5));
				o.setPricePerShare(rs.getString(6));
				o.setPercentage(rs.getString(7));
				o.setPrice(rs.getString(8));
				request.setAttribute("Order", o);
				rs = stmt1.executeQuery("SELECT Date, MarketPrice FROM Stock WHERE symbol = "+ o.getStock());
			} else {
				rs = stmt1.executeQuery("SELECT Date, MarketPrice FROM Stock WHERE symbol = "+ stockSym);
			}
			List<DataTypeStock> list = new ArrayList<DataTypeStock>();
			while(rs.next()){
				DataTypeStock data = new DataTypeStock();
				data.setDate(rs.getString(1));
				data.setPrice(rs.getString(2));
				list.add(data);
			}
			request.setAttribute("ClientHistoryTable", list);
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("clientHistory.jsp");
		view.forward(request, response);    
	}
}