package Stockss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinalRiskTable extends DivideRisk {
//For High Risk
public void HighRiskTable(String username)
{
	try
	{
	Connection conn;
	PreparedStatement pst;
	
	//Get top 5 list of company
	String[] large1=LargeRisk();
	String[] mid1=MidRisk();
	String[] small1=SmallRisk();
	
	//get all company name
	String[] largecompany=gettingLargeCompany();
	String[] midcompany=gettingMidCompany();
	String[] smallcompany=gettingSmallCompany();
	
	//
	String[] companyname=new String[2];
	String[] midcompanyname=new String[3];
	String[] smallcompanyname=new String[5];
	
	//get all company symbol
	String[] Symbol=gettingLargeSymbol();
	String[] MidSymbol=gettingMidSymbol();
	String[] SmallSymbol=gettingSmallSymbol();
	
	String companysymbol,company;
	String[] cap=new String[] {"Large","Mid","Small"};
	int result;
	
	//For LargeCap
	for(int i=0;i<2;i++)
	{
		
		for(int j=0;j<18;j++)
		{
			
			result=Symbol[j].compareToIgnoreCase(large1[i]);
			
			if(result==0)
			{
				
				companyname[i]=largecompany[j];
				//System.out.println("Added"+companyname[i]+" "+large1[i]);
			}
		}
	}
	
	//MidCap
	
	
	for(int i=0;i<3;i++)
	{
		
		for(int j=0;j<19;j++)
		{
			
			result=MidSymbol[j].compareToIgnoreCase(mid1[i]);
			
			if(result==0)
			{
				
				midcompanyname[i]=midcompany[j];
				
			}
		}
	}
	
	//Small Cap
	for(int i=0;i<5;i++)
	{
		
		for(int j=0;j<17;j++)
		{
			
			result=SmallSymbol[j].compareToIgnoreCase(small1[i]);
			
			if(result==0)
			{
				
				smallcompanyname[i]=smallcompany[j];
				//System.out.println("Added Small"+smallcompanyname[i]+" "+small1[i]);
			}
		}
	}
	
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	System.out.println("Connection Establish at FinalRiskTable(High) Class");
	for(int i=0;i<2;i++)
	{
		company=companyname[i];
		companysymbol=large1[i];
		pst=conn.prepareStatement("insert into finalhighrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2, companysymbol);
		pst.setString(3,cap[0]);
		pst.setString(4, username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final high risk Large ");
	}
	for(int i=0;i<3;i++)
	{
		company=midcompanyname[i];
		companysymbol=mid1[i];
		pst=conn.prepareStatement("insert into finalhighrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2,companysymbol);
		pst.setString(3,cap[1] );
		pst.setString(4, username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final high risk Mid");
	}
	
	for(int i=0;i<5;i++)
	{
		company=smallcompanyname[i];
		companysymbol=small1[i];
		pst=conn.prepareStatement("insert into finalhighrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2, companysymbol);
		pst.setString(3,cap[2]);
		pst.setString(4, username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final high risk small");
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
//For Mid Risk
public void MidRiskTable(String username)
{
	try
	{
	Connection conn;
	PreparedStatement pst;
	
	//Get top 5 list of company
	String[] large1=LargeRisk();
	String[] mid1=MidRisk();
	String[] small1=SmallRisk();
	
	//get all company name
	String[] largecompany=gettingLargeCompany();
	String[] midcompany=gettingMidCompany();
	String[] smallcompany=gettingSmallCompany();
	
	//
	String[] companyname=new String[3];
	String[] midcompanyname=new String[3];
	String[] smallcompanyname=new String[4];
	
	//get all company symbol
	String[] Symbol=gettingLargeSymbol();
	String[] MidSymbol=gettingMidSymbol();
	String[] SmallSymbol=gettingSmallSymbol();
	
	String companysymbol,company;
	String[] cap=new String[] {"Large","Mid","Small"};
	int result;
	
	//For LargeCap
	for(int i=0;i<3;i++)
	{
		
		for(int j=0;j<18;j++)
		{
			
			result=Symbol[j].compareToIgnoreCase(large1[i]);
			
			if(result==0)
			{
				
				companyname[i]=largecompany[j];
				//System.out.println("Added"+companyname[i]+" "+large1[i]);
			}
		}
	}
	
	//MidCap
	
	
	for(int i=0;i<3;i++)
	{
		
		for(int j=0;j<19;j++)
		{
			
			result=MidSymbol[j].compareToIgnoreCase(mid1[i]);
			
			if(result==0)
			{
				
				midcompanyname[i]=midcompany[j];
				
			}
		}
	}
	
	//Small Cap
	for(int i=0;i<4;i++)
	{
		
		for(int j=0;j<17;j++)
		{
			
			result=SmallSymbol[j].compareToIgnoreCase(small1[i]);
			
			if(result==0)
			{
				
				smallcompanyname[i]=smallcompany[j];
				//System.out.println("Added Small"+smallcompanyname[i]+" "+small1[i]);
			}
		}
	}
	
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	System.out.println("Connection Establish at FinalRiskTable(Mid) Class");
	for(int i=0;i<3;i++)
	{
		company=companyname[i];
		companysymbol=large1[i];
		pst=conn.prepareStatement("insert into finalmidrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2, companysymbol);
		pst.setString(3,cap[0]);
		pst.setString(4,username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final mid risk Large ");
	}
	for(int i=0;i<3;i++)
	{
		company=midcompanyname[i];
		companysymbol=mid1[i];
		pst=conn.prepareStatement("insert into finalmidrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2,companysymbol);
		pst.setString(3, cap[1]);
		pst.setString(4,username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final mid risk Mid");
	}
	
	for(int i=0;i<4;i++)
	{
		company=smallcompanyname[i];
		companysymbol=small1[i];
		pst=conn.prepareStatement("insert into finalmidrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2,companysymbol);
		pst.setString(3, cap[2]);
		pst.setString(4,username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final mid risk small");
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

//For Low Risk
public void LowRiskTable(String username)
{
	try
	{
	Connection conn;
	PreparedStatement pst;
	
	//Get top 5 list of company
	String[] large1=LargeRisk();
	String[] mid1=MidRisk();
	String[] small1=SmallRisk();
	
	//get all company name
	String[] largecompany=gettingLargeCompany();
	String[] midcompany=gettingMidCompany();
	String[] smallcompany=gettingSmallCompany();
	
	//
	String[] companyname=new String[5];
	String[] midcompanyname=new String[3];
	String[] smallcompanyname=new String[2];
	
	//get all company symbol
	String[] Symbol=gettingLargeSymbol();
	String[] MidSymbol=gettingMidSymbol();
	String[] SmallSymbol=gettingSmallSymbol();
	
	String companysymbol,company;
	String[] cap=new String[] {"Large","Mid","Small"};
	int result;
	
	//For LargeCap
	for(int i=0;i<5;i++)
	{
		
		for(int j=0;j<18;j++)
		{
			
			result=Symbol[j].compareToIgnoreCase(large1[i]);
			
			if(result==0)
			{
				
				companyname[i]=largecompany[j];
				//System.out.println("Added"+companyname[i]+" "+large1[i]);
			}
		}
	}
	
	//MidCap
	
	
	for(int i=0;i<3;i++)
	{
		
		for(int j=0;j<19;j++)
		{
			
			result=MidSymbol[j].compareToIgnoreCase(mid1[i]);
			
			if(result==0)
			{
				
				midcompanyname[i]=midcompany[j];
				
			}
		}
	}
	
	//Small Cap
	for(int i=0;i<2;i++)
	{
		
		for(int j=0;j<17;j++)
		{
			
			result=SmallSymbol[j].compareToIgnoreCase(small1[i]);
			
			if(result==0)
			{
				
				smallcompanyname[i]=smallcompany[j];
				//System.out.println("Added Small"+smallcompanyname[i]+" "+small1[i]);
			}
		}
	}
	
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
	System.out.println("Connection Establish at FinalRiskTable(Low) Class");
	for(int i=0;i<5;i++)
	{
		company=companyname[i];
		companysymbol=large1[i];
		pst=conn.prepareStatement("insert into finalsmallrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2, companysymbol);
		pst.setString(3,cap[0]);
		pst.setString(4,username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final small risk Large ");
	}
	for(int i=0;i<3;i++)
	{
		company=midcompanyname[i];
		companysymbol=mid1[i];
		pst=conn.prepareStatement("insert into finalsmallrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2,companysymbol);
		pst.setString(3, cap[1]);
		pst.setString(4,username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final low risk Mid");
	}
	
	for(int i=0;i<2;i++)
	{
		company=smallcompanyname[i];
		companysymbol=small1[i];
		pst=conn.prepareStatement("insert into finalsmallrisk values(?,?,?,?)");
		pst.setString(1,company);
		pst.setString(2,companysymbol);
		pst.setString(3,cap[2] );
		pst.setString(4,username);
		pst.executeUpdate();
		//System.out.println("Query Executed in final low risk small");
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
