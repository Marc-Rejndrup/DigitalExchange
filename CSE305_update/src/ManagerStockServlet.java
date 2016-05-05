

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
import dataType.DataTypeStockCount;

public class ManagerStockServlet extends HttpServlet {
	// to change stock price
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	HttpSession session=request.getSession();
		String loginID = ""+session.getAttribute("login");
		String accountID = ""+session.getAttribute("account");
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";
		
		String symbol = request.getParameter("edit");
		String newPrice = request.getParameter("price" + symbol);
		
		java.sql.Connection conn = null;
		try {
			Class.forName(mysJDBCDriver).newInstance();
			java.util.Properties sysprops=System.getProperties();
			sysprops.put("user",mysUserID);
			sysprops.put("password",mysPassword);
			conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
			System.out.println("Connected successfully to database using JConnect");
			
			java.sql.Statement stmt1=conn.createStatement();
			java.sql.ResultSet rs;
			rs = stmt1.executeQuery("select * from Stock where symbol='"+symbol+"'");
			rs.next();
			String name = rs.getString(2);
			String type = rs.getString(3);
			System.out.println(newPrice);

			stmt1.executeUpdate("insert into stock values ('"+symbol+"', '"+name+"', '"+type+"', NOW(), '"+newPrice+"')");
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("managerStock.jsp");
		view.forward(request, response);    
	}
	
	// to get stock info
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String loginID = ""+session.getAttribute("login");
		String accountID = ""+session.getAttribute("account");
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";
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
			//make query
			rs = stmt1.executeQuery("select * from stock s inner join"
					+ " (select symbol, max(date) as md from stock group by symbol) ss"
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
			request.getSession().setAttribute("ManagerStockTable", list);
			rs.close();
			
			rs = stmt1.executeQuery("select O.Symbol, count(O.Symbol) as num "
					+ "from orders O "
					+ "where O.FilledPrice IS NOT NULL "
					+ "group by O.Symbol "
					+ "order by num desc;");
			List<DataTypeStockCount> list2 = new ArrayList<DataTypeStockCount>();
			while(rs.next()){
				DataTypeStockCount data = new DataTypeStockCount();
				data.setStock(rs.getString(1));
				data.setCount(rs.getString(2));
				list2.add(data);
			}
			request.getSession().setAttribute("ManagerStockCountTable", list2);
			
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("managerStock.jsp");
		view.forward(request, response);    
	}
}