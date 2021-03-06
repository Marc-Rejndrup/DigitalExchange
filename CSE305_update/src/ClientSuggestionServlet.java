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

public class ClientSuggestionServlet extends HttpServlet {//might need to handle doGet.
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
			String type = "";
			rs = stmt1.executeQuery("select type from Stock S, "
					+ "(select h.symbol, max(quantity) from holding as h where accnum='"+loginID+"') as hold limit 1");
			if(rs.next())
				type=rs.getString(1);
			rs = stmt1.executeQuery("select * from stock s inner join "
					+ "(select symbol, max(date) as md from stock group by symbol) "
					+ "ss on s.symbol = ss.symbol and s.date = ss.md and s.type='"+type+"'");
			//type the list.
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
			request.getSession().setAttribute("ClientSuggestionTable", list);
			rs.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("clientSuggestion.jsp");
		view.forward(request, response);    
	}
}