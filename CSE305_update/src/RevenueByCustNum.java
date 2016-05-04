import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataType.DataTypeStock;

public class RevenueByCustNum {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	HttpSession session=request.getSession();
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		String mysUserID = "root"; 
		String mysPassword = "1234";
		
		java.sql.Connection conn = null;
		try {
			Class.forName(mysJDBCDriver).newInstance();
			java.util.Properties sysprops=System.getProperties();
			sysprops.put("user",mysUserID);
			sysprops.put("password",mysPassword);
			conn = java.sql.DriverManager.getConnection(mysURL,sysprops);
			System.out.println("Connected successfully to database using JConnect");

			java.sql.Statement stmt1=conn.createStatement();
			java.sql.ResultSet rs = stmt1.executeQuery(
					  "SELECT O.AccNum, SUM(O.CompPrice * O.NumShares) AS Revenue"
					+ "FROM Orders O"
					+ "WHERE O.OrderType = 'S'"
					+ "GROUP BY AccNum"
			);
			
			List<DataTypeStock> list = new ArrayList<DataTypeStock>();
			while(rs.next()){
				DataTypeStock data = new DataTypeStock();
				data.setSymbol(rs.getString(1));					// Double-check this since I'm not sure if this works
				data.setPrice(rs.getString(2)); 					// Double-check this since I'm not sure if this works
								
				list.add(data);
			}
			request.setAttribute("RevenueCNTable", list);
			rs.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{conn.close();}catch(Exception ee){};
		}
		RequestDispatcher view = request.getRequestDispatcher("revenueCust.jsp");
		view.forward(request, response);    
	}
}
