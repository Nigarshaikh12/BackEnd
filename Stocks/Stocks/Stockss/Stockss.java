package Stockss;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Stockss {
	public static void main(String[] args) {
		String[] output=new String[2];
		
		Scanner in=new Scanner(System.in);
		FinalRiskTable fs=new FinalRiskTable();
		DisplayTable displayt=new DisplayTable();
        UserValidation uv=new UserValidation();
        output = uv.UserChecking();
        int res=output[0].compareTo("1");
        if(res==0)
        {
        	
        	Tableinseration ti=new Tableinseration();
    		ti.inseratingData();
    		
    		System.out.println("Press 1 for High Risk \t2 for Mid Risk\t3 for Low Risk ");
    		int choice=in.nextInt();
    		if(choice==1)
    		{
    		fs.HighRiskTable(output[1]);
    		displayt.displayHighRiskTable(output[1]);
    		}
    		if(choice==2)
    		{
    		fs.MidRiskTable(output[1]);
    		displayt.displayMidRiskTable(output[1]);
    		}
    		if(choice==3)
    		{
    		fs.LowRiskTable(output[1]);
    		displayt.displaySmallRiskTable(output[1]);
    		}
    		System.out.println("Do you want to save (for Yes press 1|for No press 0)");
    		int save=in.nextInt();
    		if(save==0)
    		{
    		DiscardTable ds=new DiscardTable();
    		ds.truncateTables(output[1]);
    		}
    		DropTable dt=new DropTable();
    		dt.droppingProcessingTable();
        }
       
		
    }
}
