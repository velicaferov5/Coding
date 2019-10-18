import java.util.List;

/* Class and function to calculate maximum result in subtraction of 2 numbers in list */

public class MaxDifference {

    public int maxDifference(List<Integer> arr) {
    	int maxDifference=-1;
    	for(int index1=0;index1<arr.size()-1;index1++) {
    		for(int index2=index1+1;index2<arr.size();index2++) {
    			int currentDifference = arr.get(index2)-arr.get(index1);
    			if(currentDifference>0 && currentDifference>maxDifference) {
    				maxDifference = currentDifference; 
    			}
    		}
    	}
    	return maxDifference;
    }
}
