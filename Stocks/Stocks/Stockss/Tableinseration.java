package Stockss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Tableinseration extends GetSymbol  {
	public void inseratingData()
	{
		Connection conn;
		PreparedStatement pst;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
        	System.out.println("Connection Establish at Tableinseration Class");
        	
        	String[] large= gettingLargeSymbol();
        	String[] mid= gettingMidSymbol();
        	String[] small = gettingSmallSymbol();
		
		  for(int i=0;i<18;i++)
      {
      GregorianCalendar start = new GregorianCalendar(2017 , 0 , 1);
      GregorianCalendar end = new GregorianCalendar(2017 , 0 , 15);
      StockDwonloader test = new StockDwonloader(large[i] , start , end,"large");
      }
      for(int i=0;i<19;i++)
      {
      GregorianCalendar start = new GregorianCalendar(2016 , 1 , 18);
      GregorianCalendar end = new GregorianCalendar(2016 , 2 , 18);
      StockDwonloader test = new StockDwonloader(mid[i] , start , end,"mid");
      }
      for(int i=0;i<17;i++)
      {
      GregorianCalendar start = new GregorianCalendar(2016 , 1 , 18);
      GregorianCalendar end = new GregorianCalendar(2016 , 2 , 18);
      StockDwonloader test = new StockDwonloader(small[i] , start , end,"small");
      }
      System.out.println("Ending insertion\n==============");
      
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
