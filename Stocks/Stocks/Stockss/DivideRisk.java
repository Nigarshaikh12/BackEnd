package Stockss;

import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;

public class DivideRisk extends GetSymbol {
	public String[] LargeRisk()
	{
		
		BigDecimal close1=null;
		Connection conn;
		PreparedStatement pst;
		
		String symbol1;
		int res,i=0,j=0;
		ResultSet rs = null;

		
                String[] large=new String[18];
        
		//close price array
                 BigDecimal[] largemax = new BigDecimal[18];
		Arrays.fill(largemax, BigDecimal.ZERO);
		
		
		BigDecimal divisor=new BigDecimal(22);
		BigDecimal trialone=new BigDecimal(0);
		//finding top 5 compnay
		BigDecimal lmax=new BigDecimal(0);
		
		BigDecimal[] trailmax = new BigDecimal[18];
		Arrays.fill(trailmax, BigDecimal.ZERO);
		//store index of top company
		int[] large5=new int[5];
		
		//final return company symbol
		String[] finallarge=new String[5];
			try
	        {
			large=gettingLargeSymbol();
			
        		Class.forName("com.mysql.jdbc.Driver");
	        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	        	System.out.println("Connection Establish at DivideRisk Class");
	        	
	        	pst=conn.prepareStatement("select * from processingTable");
	        	 ResultSet rs1=pst.executeQuery();
	        	System.out.println("Processing Query executed ");
	        	for(i=0;i<18;i++)
	        	{
		        	for(j=0;j<22;j++)
		        	{
			        	if(rs1.next())
			        	{
			         		close1=rs1.getBigDecimal("close"); 
			         		largemax[i]=largemax[i].add(close1);
			        	}
			        	//System.out.println(j+" "+largemax[i]);
		        		
			        }
			        	largemax[i]=largemax[i].divide(divisor,0);
		        	//System.out.println(i+" "+largemax[i]);
	        	}
	        	System.out.println("\n");
        		
	        	for(i=0;i<18;i++)
	        	{
	        		trailmax[i]=largemax[i];
	        		//System.out.println(trailmax[i]);
	        	}
			lmax=new BigDecimal(0);
	        	for(i=0;i<5;i++)
	        	{
	        		for(j=0;j<18;j++)
	        		{
	        			res=lmax.compareTo(trailmax[j]);
	        			if(res==-1)
	        			{
						lmax=trailmax[j];
	        				
	        				large5[i]=j;
	        			}
	        		}
	        		//System.out.println("\nlarge max "+lmax);
	        		//System.out.println("index "+large5[i]);
				trailmax[large5[i]]=new BigDecimal(0);
				lmax=new BigDecimal(0);
	        	}
			for(i=0;i<5;i++)
			{
				for(j=0;j<18;j++)
				{
					if(j==large5[i])
						finallarge[i]=large[j];
						//System.out.println("Final symbol"+finallarge[i]);
				}
			}
	        	conn.close(); 
	        	 
	     }
	
		 catch(SQLException sx)
		 {
			System.out.println("Select query not executed ");
			 sx.printStackTrace(); 
		 }
		 catch(ClassNotFoundException cx)
		 {
			 System.out.println("Driver not initailsed ");
			 cx.printStackTrace();
		 }
		return finallarge;
	}
	
public String[] MidRisk()
	{
		
		BigDecimal close1=null;
		Connection conn;
		PreparedStatement pst;
		
		String symbol1;
		int res,i=0,j=0;
		ResultSet rs = null;

		//Company Symbol array
		
       	        String[] mid=new String[19];
                
        
		//close price array
                 
		BigDecimal[] midmax = new BigDecimal[19];
		Arrays.fill(midmax, BigDecimal.ZERO);
		
		BigDecimal divisor=new BigDecimal(22);
		BigDecimal trialone=new BigDecimal(0);
		//finding top 5 compnay
		
		BigDecimal mmax=new BigDecimal(0);
		
		//copy array
		BigDecimal[] trailmax = new BigDecimal[19];
		Arrays.fill(trailmax, BigDecimal.ZERO);
		//store index of top company
		int[] mid5=new int[5];
		//final return company symbol
		String[] finalmid=new String[5];

		try
	        {
			
        	mid=gettingMidSymbol();
        	
	        	Class.forName("com.mysql.jdbc.Driver");
	        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	        	System.out.println("Connection Establish at DivideRisk class ");
	        	
	        	pst=conn.prepareStatement("select * from processingTable");
	        	 ResultSet rs1=pst.executeQuery();
	        	System.out.println("Processing Query executed ");
	        	for(i=0;i<19;i++)
	        	{
		        	for(j=0;j<22;j++)
		        	{
			        	if(rs1.next())
			        	{
			         		close1=rs1.getBigDecimal("close"); 
			         		midmax[i]=midmax[i].add(close1);
			        	}
			        	//System.out.println(j+" "+largemax[i]);
		        		
			        }
			        	midmax[i]=midmax[i].divide(divisor,0);
		        	//System.out.println(i+" "+midmax[i]);
	        	}
	        	for(i=0;i<18;i++)
	        	{
	        		trailmax[i]=midmax[i];
	        		//System.out.println(trailmax[i]);
	        	}
			mmax=trailmax[0];
	        	for(i=0;i<5;i++)
	        	{
	        		for(j=0;j<18;j++)
	        		{
	        			res=mmax.compareTo(trailmax[j]);
	        			if(res==-1)
	        			{
						mmax=trailmax[j];
	        				
	        				mid5[i]=j;
	        			}
	        		}
	        		//System.out.println(mid5[i]);
				trailmax[mid5[i]]=new BigDecimal(0);
				mmax=new BigDecimal(0);
	        	}
			for(i=0;i<5;i++)
			{
				for(j=0;j<18;j++)
				{
					if(j==mid5[i])
						finalmid[i]=mid[j];
						//System.out.println("Final symbol"+finalmid[i]);
				}
			}
		conn.close();
	        	 
	        	 
	     }
	
		 catch(SQLException sx)
		 {
			System.out.println("Select query not executed ");
			 sx.printStackTrace(); 
		 }
		 catch(ClassNotFoundException cx)
		 {
			 System.out.println("Driver not initailsed ");
			 cx.printStackTrace();
		 }
		return finalmid;
	}
public String[] SmallRisk()
{
	
	BigDecimal close1=null;
	Connection conn;
	PreparedStatement pst;
	
	String symbol1;
	int res,i=0,j=0;
	ResultSet rs = null;

	//Company Symbol array
	String[] small=new String[17];
         
	//close price array
             
	BigDecimal[] smallmax = new BigDecimal[19];
	Arrays.fill(smallmax, BigDecimal.ZERO);
	
	BigDecimal divisor=new BigDecimal(22);
	BigDecimal trialone=new BigDecimal(0);
	//finding top 5 compnay
	
	BigDecimal smax=new BigDecimal(0);
	
	//copy array
	BigDecimal[] trailmax = new BigDecimal[17];
	Arrays.fill(trailmax, BigDecimal.ZERO);
	//store index of top company
	int[] small5=new int[5];
	//final return company symbol
	String[] finalsmall=new String[5];

	try
        {
		
    	small=gettingSmallSymbol();
    	
        	Class.forName("com.mysql.jdbc.Driver");
        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
        	System.out.println("Connection Establish at DivideRisk Class");
        	
        	pst=conn.prepareStatement("select * from processingTable");
        	 ResultSet rs1=pst.executeQuery();
        	System.out.println("Processing Query executed ");
        	for(i=0;i<17;i++)
        	{
	        	for(j=0;j<22;j++)
	        	{
		        	if(rs1.next())
		        	{
		         		close1=rs1.getBigDecimal("close"); 
		         		smallmax[i]=smallmax[i].add(close1);
		        	}
		        	//System.out.println(j+" "+largemax[i]);
	        		
		        }
		        	smallmax[i]=smallmax[i].divide(divisor,0);
	        	//System.out.println(i+" "+smallmax[i]);
        	}
        	for(i=0;i<17;i++)
        	{
        		trailmax[i]=smallmax[i];
        		//System.out.println(trailmax[i]);
        	}
		smax=new BigDecimal(0);
        	for(i=0;i<5;i++)
        	{
        		for(j=0;j<17;j++)
        		{
        			res=smax.compareTo(trailmax[j]);
        			if(res==-1)
        			{
					smax=trailmax[j];
        				
        				small5[i]=j;
        			}
        		}
        		//System.out.println(small5[i]);
			trailmax[small5[i]]=new BigDecimal(0);
			smax=new BigDecimal(0);
        	}
		for(i=0;i<5;i++)
		{
			for(j=0;j<17;j++)
			{
				if(j==small5[i])
					finalsmall[i]=small[j];
					//System.out.println("Final symbol"+finalsmall[i]);
			}
		}
	conn.close();
        	 
        	 
     }

	 catch(SQLException sx)
	 {
		System.out.println("Select query not executed ");
		 sx.printStackTrace(); 
	 }
	 catch(ClassNotFoundException cx)
	 {
		 System.out.println("Driver not initailsed ");
		 cx.printStackTrace();
	 }
	return finalsmall;
}
	}
