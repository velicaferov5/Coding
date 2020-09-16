package main;
import java.util.List;

public class MaxDifference {

	/**
	 * Calculates maximum result in subtraction of 2 numbers in list
	 * 
	 * @param numbers
	 * @return max difference of 2 numbers
	 */
    public int maxDifference(List<Integer> numbers) {
    	int maxDifference=-1;
    	for(int index1=0;index1<numbers.size()-1;index1++) {
    		for(int index2=index1+1;index2<numbers.size();index2++) {
    			int currentDifference = numbers.get(index2)-numbers.get(index1);
    			if(currentDifference>0 && currentDifference>maxDifference) {
    				maxDifference = currentDifference; 
    			}
    		}
    	}
    	return maxDifference;
    }
}
