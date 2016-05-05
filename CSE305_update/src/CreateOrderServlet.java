
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrderServlet extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  HttpSession session=request.getSession();  
		  
		  
		        String stuId = ""+session.getValue("login");
		          
		  		String accNum = request.getParameter("accNum");
		  		String orderType = request.getParameter("orderType");
		  		String numShares = request.getParameter("numShares");
		  		String fee = request.getParameter("fee");
		  		String priceType = request.getParameter("priceType");
		  		String price = request.getParameter("price");
		  		String percent = request.getParameter("percent");
		  		String stockSymbol = request.getParameter("stockSymbol");
		  		String filledPrice = request.getParameter("filledPrice");

		  		
		     	String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
		     	String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
		      	String mysUserID = "root"; 
		      	String mysPassword = "1234";

				Date d1 = new Date(System.currentTimeMillis());
				String d2 = "" + d1.getYear() + "-" + d1.getMonth() + "-" + d1.getDay();

					java.sql.Connection conn=null;
					try 
					{
		            	Class.forName(mysJDBCDriver).newInstance();
		    			java.util.Properties sysprops=System.getProperties();
		    			sysprops.put("user",mysUserID);
		    			sysprops.put("password",mysPassword);
		        
						//connect to the database
		            			conn=java.sql.DriverManager.getConnection(mysURL,sysprops);
		            			System.out.println("Connected successfully to database using JConnect");
		            
		            			java.sql.Statement stmt1=conn.createStatement();
		            			
		        				java.sql.ResultSet rs = stmt1.executeQuery("select coalesce(max(OrderId), 0) from Orders");
		        				rs.next();
		        								
		        				int orderId = Integer.parseInt(rs.getString(1)) + 1;
		        				
		        				rs.close();
		        				
		        				if(orderType.equals("sell")){
		        					if(priceType.equals("T") || priceType.equals("H")){
				        				if(percent.equals(""))
											stmt1.executeUpdate("insert into Orders VALUES"
													+ "('"+accNum+"', '"+orderId+"', '"+orderType+"', '"+numShares+"', NOW(), "
															+ "'"+fee+"', '"+stockSymbol+"', '"+price+"', NULL, "
																	+ "NULL, '"+priceType+"')");
				        				else
											stmt1.executeUpdate("insert into Orders VALUES"
													+ "('"+accNum+"', '"+orderId+"', '"+orderType+"', '"+numShares+"', NOW(), "
															+ "'"+fee+"', '"+stockSymbol+"', NULL, '"+percent+"', "
																	+ "NULL, '"+priceType+"')");
		        					}
			        				else{
										stmt1.executeUpdate("insert into Orders VALUES"
												+ "('"+accNum+"', '"+orderId+"', '"+orderType+"', '"+numShares+"', NOW(), "
														+ "'"+fee+"', '"+stockSymbol+"', NULL, NULL, "
																+ "'"+filledPrice+"', '"+priceType+"')");
										stmt1.executeUpdate("update holding set quantity=quantity-"+numShares+" where AccNum='"+accNum+"' and Symbol='"+stockSymbol+"'");
			        				}
		        				}
		        				else{
									stmt1.executeUpdate("insert into Orders VALUES"
											+ "('"+accNum+"', '"+orderId+"', '"+orderType+"', '"+numShares+"', NOW(), "
													+ "'"+fee+"', '"+stockSymbol+"', NULL, NULL, "
															+ "'"+filledPrice+"', '"+priceType+"')");
									rs = stmt1.executeQuery("select * from holding where AccNum='"+accNum+"' and Symbol='"+stockSymbol+"'");
									if(!rs.next())
										stmt1.executeUpdate("insert into holding values ('"+accNum+"', '"+stockSymbol+"', "+numShares+")");
									else
										stmt1.executeUpdate("update holding set quantity=quantity-"+numShares+" where AccNum='"+accNum+"' and Symbol='"+stockSymbol+"'");
		        				}
					} catch(Exception e)
					{
						e.printStackTrace();
					
					}
					finally{
					
						try{conn.close();}catch(Exception ee){};
					}
		 
		  
		  RequestDispatcher view = request.getRequestDispatcher("employeeOrder.jsp");
	      view.forward(request, response);    
	    }
}
