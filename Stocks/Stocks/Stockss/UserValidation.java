package Stockss;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class UserValidation {
public String[] UserChecking()
{
	String name,password;
	ResultSet rs;
	Connection conn;
	PreparedStatement pst;
	int result,result1;
	int flag=0;
	String[] output=new String[2];
	Scanner in=new Scanner(System.in);
	
	try
	{
		System.out.println("Enter username and password ");
		name=in.nextLine();
		password=in.nextLine();
		Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
    	System.out.println("Connection Establish at Uservalidation Class  ");
    	pst=conn.prepareStatement("select * from userverification");
    	rs=pst.executeQuery();
    	System.out.println("select executed ");
    	//output[1]=name;
    	while(rs.next())
    	{
    		result=name.compareTo(rs.getString(2));
    		result1=password.compareTo(rs.getString(3));
    		if((result==0)&&(result1==0))
    		{
    			output[1]=name;
    			System.out.println("Access Granted ");
    			flag=1;
    			break;
    		}
    	}
    	if(flag==0)
    		{
    		System.out.println("Access Denie ");
    		}
    	
	}
	catch(SQLException sx)
	{
		System.out.println("Not validating ");
		sx.printStackTrace();
	}
	catch(ClassNotFoundException cx)
	{
		cx.printStackTrace();
	}
	output[0]=Integer.toString(flag);
	
	return output;
	
}
	
}
