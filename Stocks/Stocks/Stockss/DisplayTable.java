package Stockss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayTable {
public void displayHighRiskTable(String username)
{
	Connection conn;
    PreparedStatement pst;
    ResultSet rs;
   
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
    	System.out.println("Connection Establish at DisplayTable(HighRisk) ");
    	pst=conn.prepareStatement("select * from finalhighrisk where username=?");
    	pst.setString(1,username);
    	rs=pst.executeQuery();
    	System.out.println("Name\t\tSymbol\tCapital\tUsername");
    	while(rs.next())
    	{
    		System.out.println(rs.getString(1)+"\t\t "+rs.getString(2)+"\t   "+rs.getString(3)+"\t   "+rs.getString(4));
    	}
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
}
public void displayMidRiskTable(String username)
{
	Connection conn;
    PreparedStatement pst;
    ResultSet rs;
   
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
    	System.out.println("Connection Establish at DisplayTable class(MidRisk) ");
    	pst=conn.prepareStatement("select * from finalmidrisk where username=?");
    	pst.setString(1,username);
    	rs=pst.executeQuery();
    	System.out.println("Name\t\tSymbol\tCapital\tUsername");
    	while(rs.next())
    	{
    		System.out.println(rs.getString(1)+"\t\t "+rs.getString(2)+"\t   "+rs.getString(3)+"\t   "+rs.getString(4));
    	}
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
}
public void displaySmallRiskTable(String username)
{
	Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    //String username;
    //username=name;
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
    	System.out.println("Connection Establish at DisplayTable(LowRisk) ");
    	pst=conn.prepareStatement("select * from finalsmallrisk where username=?");
    	pst.setString(1,username);
    	rs=pst.executeQuery();
    	System.out.println("Name\t\t\t\t\tSymbol\t\t\tCapital\t\t\tUsername");
    	while(rs.next())
    	{
    		System.out.println(rs.getString(1)+"\t\t\t\t "+rs.getString(2)+"\t\t\t  "+rs.getString(3)+"\t\t\t  "+rs.getString(4));
    	}
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
}

}
