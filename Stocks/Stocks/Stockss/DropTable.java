package Stockss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropTable {
	 public void droppingProcessingTable()
	    {
	    	Connection conn;
	    	PreparedStatement pst;
	    	try
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	        	System.out.println("Connection Establish at DropTable class");
	        	pst=conn.prepareStatement("truncate table processingTable");
	        	pst.executeUpdate();
	        	conn.close();
	    	}
	    	catch(SQLException sx)
	        {
	       System.out.println("Error in truncate");
	        	sx.printStackTrace();
	        }
	        catch(ClassNotFoundException cx)
	        {
	        	cx.printStackTrace();
	        }
	    }
	 public void droppingHighRiskTable(String username)
	 {
		 Connection conn;
	    	PreparedStatement pst;
	    	try
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	        	System.out.println("Connection Establish at DropTable class");
	        	pst=conn.prepareStatement("delete from finalHighRisk where username=?");
	        	pst.setString(1, username);
	        	pst.executeUpdate();
	        	conn.close();
	    	}
	    	catch(SQLException sx)
	        {
	       System.out.println("Error in truncate");
	        	sx.printStackTrace();
	        }
	        catch(ClassNotFoundException cx)
	        {
	        	cx.printStackTrace();
	        }
	 }
	 public void droppingMidRiskTable(String username)
	 {
		 Connection conn;
	    	PreparedStatement pst;
	    	try
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	        	System.out.println("Connection Establish at DropTable class");
	        	pst=conn.prepareStatement("delete from finalMidRisk where username=?");
	           	pst.setString(1,username);
	        	pst.executeUpdate();
	        	conn.close();
	    	}
	    	catch(SQLException sx)
	        {
	       System.out.println("Error in truncate");
	        	sx.printStackTrace();
	        }
	        catch(ClassNotFoundException cx)
	        {
	        	cx.printStackTrace();
	        }
	 }
	 public void droppingSmallRiskTable(String username)
	 {
		 Connection conn;
	    	PreparedStatement pst;
	    	try
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	        	System.out.println("Connection Establish at DropTable class");
	        	pst=conn.prepareStatement("delete from finalSmallRisk where username=?");
	        	pst.setString(1,username);
	        	pst.executeUpdate();
	        	conn.close();
	    	}
	    	catch(SQLException sx)
	        {
	       System.out.println("Error in deleting entry");
	        	sx.printStackTrace();
	        }
	        catch(ClassNotFoundException cx)
	        {
	        	cx.printStackTrace();
	        }
	 }
}
