package com.lti.jerseyWebApp;
 
 import java.sql.*;

public class DatabaseConnector 
{
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String username="hr";
	String password="hr";
	String className="oracle.jdbc.driver.OracleDriver";
	
	
	Connection con=null;
	
	public Connection getConnection()
	{
		try
		{
			Class.forName(className);
			con=DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public PreparedStatement getPreparedStatement(String query)
	{
		PreparedStatement pstmt=null;
		try
		{
			con=getConnection();
			pstmt=con.prepareStatement(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return pstmt;
	}
	
	public ResultSet getResultSet(String query)
	{
		ResultSet rs=null;
		
		try
		{
			con=getConnection();
			Statement stmt=con.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public void closeConnection()
	{
		try
		{
			if(con!=null)
			{
				con.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
