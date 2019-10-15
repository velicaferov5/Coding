import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Operations {

    public int findLargestSibling(int N) {
        // write your code in Java SE 8
        String strN = Integer.toString(N);
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for(int index1=0;index1<strN.length()-1;index1++) {
        	int digit=Character.getNumericValue(strN.charAt(index1));
        	numberList.add(digit);
        }
        Collections.sort(numberList);

        int maxNumber=0;
        int decimalPoints=1;
        for(int index1=0;index1<numberList.size();index1++) {
        	maxNumber+=(int)numberList.get(index1)*decimalPoints;
        	decimalPoints*=10;
        }
        
        return maxNumber;
    }
    
    public int widestPath(int[] X, int[] Y) {
        // write your code in Java SE 8
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
