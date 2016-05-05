

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
import dataType.DataTypeRevenue;

public class ManagerRevenueServlet extends HttpServlet {//might need to handle doGet.
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
		String x = request.getParameter("getby");
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
			
			rs = stmt1.executeQuery("select O.Symbol, sum(O.FilledPrice * O.NumShares) AS Revenue "
						+ "from Orders as O "
						+ "where O.OrderType='sell' "
						+ "group by O.Symbol order by Revenue desc");
			List<DataTypeRevenue> list = new ArrayList<DataTypeRevenue>();
			DataTypeRevenue data;
			while(rs.next()){
				data = new DataTypeRevenue();
				data.setSymbol(rs.getString(1));
				data.setRevenue(rs.getString(2));
				list.add(data);
			}
			request.getSession().setAttribute("ManagerSymbolRevenueTable", list);
			rs.close();
			
			rs = stmt1.executeQuery("select O.AccNum, sum(O.FilledPrice * O.NumShares) AS Revenue "
					+ "from Orders as O "
					+ "where O.OrderType='sell' "
					+ "group by O.AccNum order by Revenue desc");
			list = new ArrayList<DataTypeRevenue>();
			while(rs.next()){
				data = new DataTypeRevenue();
				data.setAccNum(rs.getString(1));
				data.setRevenue(rs.getString(2));
				list.add(data);
			}
			request.getSession().setAttribute("ManagerAccountRevenueTable", list);
			rs.close();
			
			rs = stmt1.executeQuery("select S.type, sum(Rev.Revenue) as Revenue "
					+ "from (select s.symbol, s.type from stock s inner join ( "
					+ "select symbol, max(date) as md from stock group by symbol "
					+ ") ss on s.symbol = ss.symbol and s.date = ss.md) as S "
					+ "left outer join (select O.symbol as symbol, sum(O.FilledPrice * O.NumShares) AS Revenue "
					+ "from Orders as O "
					+ "where O.OrderType='sell' "
					+ "GROUP BY symbol) as Rev "
					+ "on Rev.symbol=S.symbol "
					+ "GROUP by S.type "
					+ "order by Revenue desc");
			list = new ArrayList<DataTypeRevenue>();
			while(rs.next()){
				data = new DataTypeRevenue();
				data.setType(rs.getString(1));
				data.setRevenue(rs.getString(2));
				list.add(data);
			}
			request.getSession().setAttribute("ManagerTypeRevenueTable", list);
			
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("managerRevenue.jsp");
		view.forward(request, response);    
	}
}