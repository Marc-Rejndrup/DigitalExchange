

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
import dataType.DataTypeOrder;
import dataType.DataTypeStock;
import dataType.DataTypeStockCount;

/*
 * This servlet will get all recent stock information with post
 */

public class ClientStockServlet extends HttpServlet {//might need to handle doGet.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String type = request.getParameter("stockType");
		System.out.println("Symbol is " + symbol);
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
			
			if(symbol != null){
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
			}
			
			else if(type != null){
				rs = stmt1.executeQuery("select * from stock s inner join"
						+ " (select symbol, max(date) as md from stock where type='"+type+"' group by symbol) ss"
						+ " on s.symbol = ss.symbol and s.date = ss.md");
				List<DataTypeStock> list = new ArrayList<DataTypeStock>();
				while(rs.next()){
					DataTypeStock data = new DataTypeStock();
					data.setSymbol(rs.getString(1));
					data.setName(rs.getString(2));
					data.setType(rs.getString(3));
					data.setDate(rs.getString(4));
					data.setPrice(rs.getString(5));
					list.add(data);
				}
				request.getSession().setAttribute("ClientStockTypeTable", list);
				
				rs = stmt1.executeQuery("select * from orders as o "
						+ "inner join (select s.symbol, s.type from stock s inner join "
						+ "(select symbol, max(date) as md from stock group by symbol) "
						+ " ss on s.symbol = ss.symbol and s.date = ss.md) as stk "
						+ "where o.symbol = stk.symbol and o.FilledPrice IS NOT NULL and stk.type = '"+type+"'");
				List<DataTypeOrder> list2 = new ArrayList<DataTypeOrder>();
				while(rs.next()){
					DataTypeOrder data2 = new DataTypeOrder();
					data2.setAccountId(rs.getString(1));
					data2.setId(rs.getString(2));
					data2.setBuySell(rs.getString(3));
					data2.setNumShares(rs.getString(4));
					data2.setDateTime(rs.getString(5));
					data2.setFee(rs.getString(6));
					data2.setStock(rs.getString(7));
					data2.setPricePerShare(rs.getString(8));
					data2.setPercentage(rs.getString(9));
					data2.setPrice(rs.getString(10));
					data2.setOrderType(rs.getString(11));
					list2.add(data2);
				}
				request.getSession().setAttribute("ClientOrderTypeTable", list2);
				
				
			}
			
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("clientStock.jsp");
		view.forward(request, response);    
	}
	
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
			
			rs = stmt1.executeQuery("select O.Symbol, count(O.Symbol) as num "
					+ "from orders O "
					+ "where O.FilledPrice IS NOT NULL and O.orderType='sell'"
					+ "group by O.Symbol "
					+ "order by num desc;");
			List<DataTypeStockCount> list = new ArrayList<DataTypeStockCount>();
			while(rs.next()){
				DataTypeStockCount data = new DataTypeStockCount();
				data.setStock(rs.getString(1));
				data.setCount(rs.getString(2));
				list.add(data);
			}
			request.getSession().setAttribute("ClientStockBestTable", list);
			
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