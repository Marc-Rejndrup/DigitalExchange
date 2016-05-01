<%
if (request.getProtocol().compareTo("HTTP/1.0")==0)
      response.setHeader("Pragma","no-cache");
if (request.getProtocol().compareTo("HTTP/1.1")==0)
      response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires",0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>Your Course Information -- Student Registration System</title>

</head>
<body style="text-align: center" bgcolor="#ffff00">
    <span style="font-size: 14pt; font-family: Arial"><strong>Hello, Professor. Your ID is
        <%=session.getValue("login")%>. Here is Your Course Information.<br />
        <br />
        <table border="0" cellpadding="0" cellspacing="0" style="width: 100%; height: 100%">
            <tr>
                <td style="vertical-align: top; width: 11237px; text-align: left; height: 454px;">
                    <span style="font-size: 10pt">These are the courses you are teaching in this semester,
                        you can check the information of the corresponding course by select the "View" button to check more information.<br />
                        <br />
                    </span><br />
                    
                    Stock Information
                    <table border="8" id="TABLE1" onclick="return TABLE1_onclick()">
                    <tr>
                      <td style="width: 84px">
                          <span style="font-size: 10pt">
                          Stock Symbol</span></td>
                      <td style="width: 74px">
                            <span style="font-size: 10pt">Company Name</span></td>
                        
                      <td style="width: 187px">
                          <span style="font-size: 10pt">Stock Type</span></td>
                          
                      <td style="width: 100px">
                          <span style="font-size: 10pt">PricePerStock</span></td>
                          
                      <td style="width: 100px">
                          <span style="font-size: 10pt">Number Stocks</span></td>
                        
                         <td style="width: 7px">
                            <span style="font-size: 10pt">Set Num</span></td>
                    </tr>   
<%
		String crscode=request.getParameter("crscode");
        
		String mysJDBCDriver = "com.mysql.jdbc.Driver"; 
   	  	String mysURL ="jdbc:mysql://127.0.0.1:3306/cse305";
  	String mysUserID = "root"; 
  	String mysPassword = "1234";
        
        String profId = ""+session.getValue("login");
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
        
					java.sql.ResultSet rs = stmt1.executeQuery("select * from Stock");
      	  while(rs.next())
        	{
%>
                    <tr>
                      <td style="width: 84px">
                          <span style="font-size: 10pt"><%=rs.getString(1)%></span></td>
                      <td style="width: 187px">
                          <span style="font-size: 10pt"><%=rs.getString(2)%></span></td>
                        <td style="width: 74px">
                            <span style="font-size: 10pt"><%=rs.getString(3)%></span></td>
                                                    <td style="width: 100px">
                            <span style="font-size: 10pt"><%=rs.getString(4)%></span></td>
                                                    <td style="width: 100px">
                            <span style="font-size: 10pt"><%=rs.getString(5)%></span></td>
                        <td>
                        	<!-- <input type=button  onclick="javascript:window.open('FacultyDetailedCourseInfo.jsp?crscode=<%=rs.getString(1).trim()%>','_self');return;" value="Edit"> -->
        					<form action="changestock" method="post">
        						<input type=text name="amount" />
        					    <input type="hidden" name="stocksym" value=<%=rs.getString(1)%> />
        					</form>
                        </td>
                        		
                    </tr>
<%      		
        	}
  			} catch(Exception e)
			{
				e.printStackTrace();
				out.print(e.toString());
			}
			finally{
			
				try{conn.close();}catch(Exception ee){};
			}

  %>
  					</table>
                    
                    Edit Employee - given an SSN, change any of the following
                    <form action="changeemployee" method="post">
                    	SSN: <input type=text name="empssn" /><br/>
                    	Name: <input type=text name="empname" /><br/>
                    	Zipcode: <input type=text name="empzipcode" /><br/>
                    	Telephone: <input type=text name="emptelephone" /><br/>
                    	HourlyRate: <input type=text name="emphourlyrate" /><br/>
                    	<input id="Button2" type="submit" />
                    </form>
                    
                    Get Orders - given a stock symbol or customer number, produce a list of orders
                    <form action="getorder" method="get">
                    	Stock Symbol: <input type=text name="getsym" /><br/>
                    	Customer Number: <input type=text name="custnum" /><br/>
                    	<input id="Button3" type="submit" />
                    </form>
                    
                    Record Order - given the following, create an order
                    <form action="createorder" method="post">
                    	Order Id: <input type=text name="nooid" /><br/>
                    	Client Id: <input type=text name="nocid" /><br/>
                    	Stock: <input type=text name="nostock" /><br/>
                    	NumShares: <input type=text name="nonumshares" /><br/>
                    	PricePerShare: <input type=text name="nopps" /><br/>
                    	Price Type: <input type=text name="nopricetype" /><br/>
                    	Percentage: <input type=text name="nopercentage" /><br/>
                    	Order Type: <input id="Radio1" name="group1" checked="checked" type="radio" /><strong><span style="font-size: 10pt;
        font-family: Arial">Buy  &nbsp; &nbsp;<input id="Radio2" name="group1" type="radio" />Sell
                    	<input id="Button4" type="submit" />
                    </form>
                    
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <br />
                    <input id="Button1" type="button" value="Logout" onclick="window.open('index.htm','_self');" /><br />
                   
                <td style="width: 292px; height: 454px; vertical-align: top; text-align: left;">
                    <img src="Hospital.JPG" /></td>
            </tr>
        </table>
    </strong></span>

</body>
</html>