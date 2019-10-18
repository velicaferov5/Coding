/* Floor numbers containing '4' and '13' numbers will be excluded in hotel. 
 * So, getActualFloorNumber function calculates actual floor numbers to build n-storey hotel */ 

public class FindEUFloorNumber {

    public int getActualFloorNumber(int n) {
    	int actualVersion=0;
    	for(int index1=1;index1<=n;index1++) {
    		actualVersion++;
			String floorStr=Integer.toString(actualVersion);
			while(floorStr.contains("4") || floorStr.contains("13")) {
				actualVersion++;
				floorStr=Integer.toString(actualVersion);
			}
		}
		return actualVersion;
    }
}
