package main;
import java.util.ArrayList;
import java.util.List;

public class Bulbs {
	
    /**
     * Finds number of bulbs will be turned on if previous bulbs (according to indexes are turned on)
     * 
     * @param A
     * @return integer
     */
    public int turnedBulbs(int[] A) {
    	
    	// turnedBulbs collection to track bulbs turned on
    	List<Integer> turnedBulbs= new ArrayList<Integer>();
    	
    	int turnedOnCount = 0;
    	
    	// iterating over bulbs to count those turned on
    	for(int currentBulb:A) {
    		if(doesBulbTurnOn(turnedBulbs,currentBulb))
    			turnedOnCount++;
    		turnedBulbs.add(currentBulb);
    	}
    	return turnedOnCount;
    }
    
    /**
     * Detects if current bulb will turn on by checking if all bulbs before currentBulb are turned on.
     * 
     * @param turnedBulbs
     * @param currentBulb
     * @return {boolean}
     */
    public boolean doesBulbTurnOn(List<Integer> turnedBulbs, int currentBulb) {
    	int turnedOnSum=0;
    	for(int index1=0; index1<turnedBulbs.size(); index1++) {
    		if(turnedBulbs.get(index1)<currentBulb)
    			turnedOnSum+=turnedBulbs.get(index1);
    	}
    	
    	/* Detecting currentBulb will turn on by comparing sum of indexes previous turned of bulbs and all indexes. It won't turn on if turnedOnSum is less, which means there are bulb(s) turned off before currentBulb
    	*/
    	if(turnedOnSum == arithmeticSum(currentBulb-1))
    		return true;
    	else return false;
    }
    
    /**
     * Calculates arithmetic sum of current number and other numbers less than it
     *     
     * @param number
     * @return integer
     */
    public int arithmeticSum(int number) {
    	if(number<2)
    		return number;
    	else return number + arithmeticSum(number-1);
    }
}
