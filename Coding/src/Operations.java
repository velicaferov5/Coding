import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Different methods performing different operations are listed in this class */

public class Operations {

	/* Following method returns list of Integers from 1 to n that are
	 * multiples of x or y, but not z */
	public List<Integer> multiplesOfXorYnotZ (int x, int y, int z, int n) {
		List<Integer> resultList = new ArrayList<Integer>();
		int X=x;
		int Y=y;
		int Z=z;
		if(x==0)
			X=1;
		
		if(y==0)
			Y=1;
		
		if(z==0)
			Z=1;
		
		for(Integer index1=1; index1<=n; index1++) {
			if((index1%X==0 || index1%Y==0) && index1%Z>0)
				resultList.add(index1);
		}
		return resultList;
	}
	
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
    
    /* stepsToEliminate method calculates required number of steps to reach 0 from decimal value of input binary by dividing by 2 if it is even, subtracting 1 if it is odd */
    public int stepsToEliminateBinary(String input) {
    	int decimal = binaryToDecimal(input);
    	int steps=0;
    	while(decimal>0) {
    		if(decimal%2 == 0)
    			decimal/=2;
    		else decimal--;
    		steps++;
    	}
    	return steps;
    }
    
    //Method converts binary input to decimal
    public int binaryToDecimal(String binary) {
    	int decimal = 0;
    	int indexPower=1;
    	for(int index1=binary.length()-1; index1>=0; index1--) {
    		int digit = Integer.parseInt(binary.substring(index1,index1+1));
    		decimal+=indexPower*digit;
    		indexPower*=2;
    	}
    	return decimal;
    }

	// Method counts identical pairs in input Array (A[P]=A[Q] where P<Q<A.length)
    public int countIdenticalPairs(int[] A) {
    	int identicalPairs = 0;
    	
    	/* Number of identical pairs is calculated by looping over A[] and comparing each index with bigger indexes */
    	for(int index1=0; index1<A.length-1; index1++) {
    		for(int index2=index1+1; index2<A.length; index2++) {
    			if(A[index1] == A[index2])
    				identicalPairs++;
    		}
    	}
		return identicalPairs;
    }
}
