import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Operations {

	/* findLargestSibling method to calculate maximum number can be formed from digits of number (siblings) */
	public int findLargestSibling(int N) {
		
		/* input number is converted to characters, added to numberList<> and sorted in descending order */
        String strN = Integer.toString(N);
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for(int index1=0;index1<strN.length()-1;index1++) {
        	int digit=Character.getNumericValue(strN.charAt(index1));
        	numberList.add(digit);
        }
        Collections.sort(numberList);
        
        /* Maximum sibling is obtained by calculating value of numberList<> */
        int maxNumber=0;
        int decimalPoints=1;
        for(int index1=0;index1<numberList.size();index1++) {
        	maxNumber+=(int)numberList.get(index1)*decimalPoints;
        	decimalPoints*=10;
        }
        
        return maxNumber;
    }
    
	/* widesPath() method to calculate widest path (X margin) between 2 points in XY graph */
    public int widestPath(int[] X, int[] Y) {

    	Arrays.sort(X);
    	int widestPath=1;
    	for(int index1=0;index1<X.length-1;index1++) {
    		int path = X[index1+1] - X[index1];
    		if(widestPath<path)
    			widestPath = path;
    	}
    	
    	return widestPath;
    }
}
