package main;
import java.util.*;

/** 
 * Various operations are performed via methods of the class.
 * 
 * @author vjafarov
 */
public class Functions extends FindEUFloorNumber {

	public static void main(String[] args) {
	}

	/**
	 * Finds list of Integers from 1 to n that are
	 * multiples of x or y, but not z.
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param n
	 * 
	 * @return list of multiples
	 */
	public List<Integer> multiplesOfXorYnotZ (int x, int y, int z, int n) {
		List<Integer> resultList = new ArrayList<Integer>();
		int X = x;
		int Y = y;
		int Z = z;
		if(x == 0)
			X = 1;
		
		if(y == 0)
			Y = 1;
		
		if(z == 0)
			Z = 1;
		
		for(Integer index1 = 1; index1 <= n; index1++) {
			if((index1%X == 0 || index1%Y == 0) && index1%Z > 0)
				resultList.add(index1);
		}
		return resultList;
	}
	
	/**
	 * Calculates maximum number (siblings) can be formed from digits of {@param N}.
	 * 
	 * @param N
	 * @return largest sibling
	 */
	public int findLargestSibling(int N) {
		
		/* input number is converted to characters, added to numberList<> and sorted in descending order */
        String strN = Integer.toString(N);
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for(int index1 = 0; index1 < strN.length() - 1; index1++) {
        	int digit = Character.getNumericValue(strN.charAt(index1));
        	numberList.add(digit);
        }
        Collections.sort(numberList);
        
        /* Maximum sibling is obtained by calculating value of numberList<> */
        int maxNumber=0;
        int decimalPoints=1;
        for(int index1 = 0; index1 < numberList.size(); index1++) {
        	maxNumber+=(int) numberList.get(index1) * decimalPoints;
        	decimalPoints *= 10;
        }
        
        return maxNumber;
    }
    
	/**
	 * Calculates widest path (X margin) between 2 points in XY graph.
	 * 
	 * @param X
	 * @param Y
	 * @return widest path
	 */
    public int widestPath(int[] X, int[] Y) {

    	Arrays.sort(X);
    	int widestPath=1;
    	for(int index1 = 0; index1 < X.length - 1; index1++) {
    		int path = X[index1+1] - X[index1];
    		if(widestPath < path)
    			widestPath = path;
    	}
    	
    	return widestPath;
    }
    
    /**
     * Calculates required number of steps to reach 0 from decimal value of {@param input} binary by dividing by 2 if it is even,
     * subtracting 1 if it is odd.
     * 
     * @param input
     * @return steps
     */
    public int stepsToEliminateBinary(String input) {
    	int decimal = binaryToDecimal(input);
    	int steps = 0;
    	while(decimal > 0) {
    		if(decimal%2 == 0)
    			decimal /= 2;
    		else decimal--;
    		steps++;
    	}
    	return steps;
    }
    
    /**
     * Converts binary input to decimal
     * 
     * @param binary
     * @return decimal from {@param binary}
     */
    public int binaryToDecimal(String binary) {
    	int decimal = 0;
    	int indexPower = 1;
    	for(int index1 = binary.length()-1; index1 >= 0; index1--) {
    		int digit = Integer.parseInt(binary.substring(index1,index1+1));
    		decimal += indexPower*digit;
    		indexPower *= 2;
    	}
    	return decimal;
    }

	/** Counts identical pairs in {@param A} where (A[P]=A[Q] where P<Q<A.length)
	 * 
	 * @param A
	 * @return # of pairs
	 */
    public int countIdenticalPairs(int[] A) {
    	int identicalPairs = 0;
    	
    	/* Number of identical pairs is calculated by looping over A[] and comparing each index with bigger indexes */
    	for(int index1=0; index1<A.length-1; index1++) {
    		for(int index2 = index1+1; index2 < A.length; index2++) {
    			if(A[index1] == A[index2])
    				identicalPairs++;
    		}
    	}
		return identicalPairs;
    }
    
    /**
	 * {@param steps}: string with 4 steps (up-down-left-right directions): 'U', 'D', 'L', 'R'.
	 * Method calculates and returns maximum number of useless steps (e.g up-downs) in {@param s}.
	 * 
	 * @param steps
	 * @return maximum # of steps can be deleted
	 */
	public static int getMaxDeletions(String steps) {
		// Define arrays for calculation
        int[] stepCount = new int[] {0, 0, 0, 0};
        // Get count of each step through loop
        for(int index1 = 0; index1 < steps.length(); index1++) {
            switch(steps.charAt(index1)) {
                case 'U': stepCount[0]++; break;
                case 'D': stepCount[1]++; break;
                case 'L': stepCount[2]++; break;
                case 'R': stepCount[3]++; break;
            }
        }
        // Twice of (Minimum of up and down) + (minimum of right and left) is the number of max deletions.
        // (because there are 2 * (up-down) and/or 2* (right-left) useless movements)
        return 2 * (Math.min(stepCount[0], stepCount[1]) + Math.min(stepCount[2], stepCount[3]));
    }

	public static int countPairs(List<Integer> numbers, int k) {
		int length = numbers.size();

		for (int index1=0; index1< length; index1++) {
			for (int index2=index1+1; index2<length; index2++) {

			}
		}

		Integer[] numberArray = new Integer[length];
		numberArray = numbers.toArray(numberArray);
		Set<Integer> pairSet = new HashSet<>();
		for (int index1=0; index1<length-1; index1++) {
			for (int index2=index1+1; index2<length; index2++) {
				int dif = numberArray[index2] - numberArray[index1];
				if (dif == k) {
					pairSet.add(numberArray[index1]);
				} else if (dif == -k) {
					pairSet.add(numberArray[index2]);
				}
			}
		}
		return pairSet.size();
	}

	public static int countPairs2(List<Integer> numbers, int k) {
		int length = numbers.size();
		Integer[] numberArray = new Integer[length];
		numberArray = numbers.toArray(numberArray);
		Set<Integer> pairSet = new HashSet<>();
		for (int index1=0; index1<length-1; index1++) {
			for (int index2=index1+1; index2<length; index2++) {
				int dif = numberArray[index2] - numberArray[index1];
				if (dif == k) {
					pairSet.add(numberArray[index1]);
				} else if (dif == -k) {
					pairSet.add(numberArray[index2]);
				}
			}
		}
		return pairSet.size();
	}

	public static int comparatorValue(List<Integer> a, List<Integer> b, int d) {
		int lengthA = a.size();
		Integer[] arrayA = new Integer[lengthA];
		arrayA = a.toArray(arrayA);
		int lengthB = b.size();
		Integer[] arrayB = new Integer[lengthB];
		arrayB = b.toArray(arrayB);
		int comparators = 0;
		for (int indexA=0; indexA<lengthA; indexA++) {
			comparators++;
			for (int indexB=0; indexB<lengthB; indexB++) {
				if (Math.abs(arrayA[indexA]-arrayB[indexB]) <= d) {
					comparators--;
					break;
				}
			}
		}
		return comparators;
	}

	public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {

	}
}
