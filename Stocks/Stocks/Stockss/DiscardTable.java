package Stockss;

public class DiscardTable extends DropTable {
     public void truncateTables(String username)
     {
    	 droppingHighRiskTable(username);
    	 droppingMidRiskTable(username);
    	 droppingSmallRiskTable(username);
     }
}
