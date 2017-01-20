package Stockss;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class StockDwonloader {
	/*public static final int DATE=0;
    public static final int OPEN=1;
    public static final int HIGH=2;
    public static final int LOW=3;
    public static final int CLOSE=4;
    public static final int VOLUME=5;
    public static final int ADJCLOSE=6;
   
    private ArrayList<GregorianCalendar> dates;
    private ArrayList<Double> opens;
    private ArrayList<Double> highs;
    private ArrayList<Double> lows;
    private ArrayList<Double> closes;
    private ArrayList<Integer> volumes;
    private ArrayList<Double> adjCloses;*/
    static  int count=0;
    
    
    
    public StockDwonloader(String symbol,GregorianCalendar start,GregorianCalendar end,String type)
    {
        /*dates = new ArrayList<GregorianCalendar> ();
        opens = new ArrayList<Double> ();
        highs = new ArrayList<Double> ();
        lows = new ArrayList<Double> ();
        closes = new ArrayList<Double> ();
        volumes = new ArrayList<Integer> ();
        adjCloses = new ArrayList<Double> ();*/
        String date1,name1,type1;
        BigDecimal volume1,open1,low1,high1,close1,adj;
  
        Connection conn=null;
        PreparedStatement pst;
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trademarket","root","root123");
        	System.out.println("Connection Establish at StockDownload Class");
        	//conn.close();
        
        //http://chart.finance.yahoo.com/table.csv?s=IBM&a=10&b=27&c=2016&d=11&e=27&f=2016&g=d&ignore=.csv
        
        String url= " http://chart.finance.yahoo.com/table.csv?s="+symbol+
                "&a="+start.get(Calendar.MONTH)+
                "&b="+start.get(Calendar.DAY_OF_MONTH)+
                "&c="+start.get(Calendar.YEAR)+
                "&d="+end.get(Calendar.MONTH)+
                "&e="+end.get(Calendar.DAY_OF_MONTH)+
                "&f="+end.get(Calendar.YEAR)+
                "&g=d&ignore=.csv";
         try
         {
             URL yahoofin = new URL(url);
             URLConnection data = yahoofin.openConnection();
             Scanner input = new Scanner(data.getInputStream());
             if(input.hasNext())//header link
             {
            	 	System.out.println("\n"+symbol);
                   System.out.println(input.nextLine());
             }
             
             //start reading data
             while(input.hasNextLine())
             {
            	 String line = input.nextLine();
                 String[] line1 = line.split(",");
                 
                 System.out.println(line);
                 //p_no++;
                 
                 name1=symbol;
                     date1=line1[0];
                	 open1 = new BigDecimal(line1[1]);
                	 high1= new BigDecimal(line1[2]);
                	 low1= new BigDecimal(line1[3]);
                		 close1= new BigDecimal(line1[4]);
                	 volume1= new BigDecimal(line1[5]);
                	 adj=new BigDecimal(line1[6]);
              type1=type;
              // Inserting into processingTable 
              pst=conn.prepareStatement("insert into processingTable values(?,?,?,?,?,?,?,?,?)");
             pst.setString(1,name1);
             pst.setString(2, date1);
             pst.setBigDecimal(3,open1);
             pst.setBigDecimal(4, high1);
             pst.setBigDecimal(5, low1);
             pst.setBigDecimal(6, close1);
             pst.setBigDecimal(7, volume1);
             pst.setBigDecimal(8, adj);
             pst.setString(9, type1);
             pst.executeUpdate();
             System.out.println(" Inserting");
             
           //conn.close();     
             
             }   
         }
          
         catch(Exception e)
         {
            System.err.println(e);
         
         
         }
         }
         catch(SQLException sx)
         {
        System.out.println("Error in Inserting");
         	sx.printStackTrace();
         }
         catch(ClassNotFoundException cx)
         {
         	cx.printStackTrace();
         }
       // count++;
        
    }
    
    
  
}
