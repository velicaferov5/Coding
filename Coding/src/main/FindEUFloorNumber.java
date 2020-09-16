package main;

public class FindEUFloorNumber {
	
	/**
	 * Calculates actual floor numbers to build n-storey hotel
	 * Floor numbers containing '4' and '13' numbers are excluded in hotel.
	 * 
	 * @param n (number of floors)
	 * @return actual number of floors
	 */
    public int getActualFloorNumber(int n) {
    	int actualNumber=0;
    	int index=0;
    	while(++index<=n) {
			String floorStr=Integer.toString(++actualNumber);
			while(floorStr.contains("4") || floorStr.contains("13")) {
				++actualNumber;
				floorStr=Integer.toString(actualNumber);
			}
		}
		return actualNumber;
    }
}
