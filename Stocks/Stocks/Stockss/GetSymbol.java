package Stockss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetSymbol {
	public String[] small=new String[17];
	public String[] large=new String[18];
	public String[] mid=new String[19];
	public String[] smallcompany=new String[17];
	public String[] largecompany=new String[18];
	public String[] midcompany=new String[19];
	public String[] gettingSmallSymbol()
	{
		
	List<String> small1=new ArrayList<String>();
   
    Connection conn;
    PreparedStatement pst;
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
    	System.out.println("Connection Establish at GetSymbol class");
    	pst=conn.prepareStatement("select * from smallcap");
    	ResultSet rs=pst.executeQuery();
    	while(rs.next())
    	{
    		small1.add(rs.getString("symbol"));
    	}

    	conn.close();
    	small = small1.toArray(new String[small1.size()]);
    	
    }
    catch(SQLException sx)
    {
    	sx.printStackTrace();
    }
    catch(ClassNotFoundException cx)
    {
    	cx.printStackTrace();
    }
    return small;
	}
	public String[] gettingMidSymbol()
	{
		List<String> mid1=new ArrayList<String>();
		Connection conn;
	    PreparedStatement pst;
	    ResultSet rs;
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	    	System.out.println("Connection Establish at GetSymbol class ");
	    	pst=conn.prepareStatement("select * from midcap");
	    	rs=pst.executeQuery();
	    	while(rs.next())
	    	{
	    		mid1.add(rs.getString("symbol"));
	    	}
	    	mid = mid1.toArray(new String[mid1.size()]);
	    	
	    	conn.close();
	    }
	    catch(SQLException sx)
	    {
	    	sx.printStackTrace();
	    }
	    catch(ClassNotFoundException cx)
	    {
	    	cx.printStackTrace();
	    }
	    return mid;
	}
	public String[] gettingLargeSymbol()
	{
		List<String> large1=new ArrayList<String>();
		Connection conn;
	    PreparedStatement pst;
	    ResultSet rs;
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	    	System.out.println("Connection Establish at at GetSymbol class ");
	    	pst=conn.prepareStatement("select * from largecap");
	    	rs=pst.executeQuery();
	    	while(rs.next())
	    	{
	    		large1.add(rs.getString("symbol"));
	    	}
	    	large = large1.toArray(new String[large1.size()]);
	    	
	    	conn.close();
	    }
	    catch(SQLException sx)
	    {
	    	sx.printStackTrace();
	    }
	    catch(ClassNotFoundException cx)
	    {
	    	cx.printStackTrace();
	    }
	    return large;
	}
	
	public String[] gettingSmallCompany()
	{
		
	List<String> small1=new ArrayList<String>();
   
    Connection conn;
    PreparedStatement pst;
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
    	System.out.println("Connection Establish at at GetSymbol class ");
    	pst=conn.prepareStatement("select * from smallcap");
    	ResultSet rs=pst.executeQuery();
    	while(rs.next())
    	{
    		small1.add(rs.getString("company"));
    	}

    	conn.close();
    	smallcompany = small1.toArray(new String[small1.size()]);
    	
    }
    catch(SQLException sx)
    {
    	sx.printStackTrace();
    }
    catch(ClassNotFoundException cx)
    {
    	cx.printStackTrace();
    }
    return smallcompany;
	}

	public String[] gettingMidCompany()
	{
		List<String> mid1=new ArrayList<String>();
		Connection conn;
	    PreparedStatement pst;
	    ResultSet rs;
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	    	System.out.println("Connection Establish at GetSymbol class");
	    	pst=conn.prepareStatement("select * from midcap");
	    	rs=pst.executeQuery();
	    	while(rs.next())
	    	{
	    		mid1.add(rs.getString("company"));
	    	}
	    	midcompany = mid1.toArray(new String[mid1.size()]);
	    	
	    	conn.close();
	    }
	    catch(SQLException sx)
	    {
	    	sx.printStackTrace();
	    }
	    catch(ClassNotFoundException cx)
	    {
	    	cx.printStackTrace();
	    }
	    return midcompany;
	}
	public String[] gettingLargeCompany()
	{
		List<String> large1=new ArrayList<String>();
		Connection conn;
	    PreparedStatement pst;
	    ResultSet rs;
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	    	System.out.println("Connection Establish at GetSymbol class ");
	    	pst=conn.prepareStatement("select * from largecap");
	    	rs=pst.executeQuery();
	    	while(rs.next())
	    	{
	    		large1.add(rs.getString("company"));
	    	}
	    	largecompany = large1.toArray(new String[large1.size()]);
	    	
	    	conn.close();
	    }
	    catch(SQLException sx)
	    {
	    	sx.printStackTrace();
	    }
	    catch(ClassNotFoundException cx)
	    {
	    	cx.printStackTrace();
	    }
	    return largecompany;
	}
}