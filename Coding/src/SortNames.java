import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Class and methods to sort names with their roman number order in "Name Roman_number""
 * 1. Sorting all names in ascending order
 * 2. Sorting same names in ascending order according to roman number */

public class SortNames {

	/* Primary function to sort names and roman numbers. Input list, output list. */
    public static List<String> sortRoman(List<String> names) {

    	int N=names.size();
    	Collections.sort(names);
    	
    	String[] justNames = new String[N];
    	String[] romanNumbers = new String[N];
    	
    	/* splitting names and roman number to order */
    	
    	for(int index1=0; index1<N; index1++) {
    		String[] currentName = names.get(index1).split(" ");
    		justNames[index1] = currentName[0];
    		romanNumbers[index1] = currentName[1];
    	}
    	
    	/* Roman numbers converted to standard numbers and assigned. */
    	int[] numbers = toNumbers(romanNumbers);
    	
    	/* Sorting same names according to their numbers */
    	
    	int index1=0;
    	while(index1<N-1) {
    		int index2=index1+1;
    		while(index2<N && justNames[index1].equals(justNames[index2])) {
    			if(numbers[index1] > numbers[index2]) {
    				int tempInt = numbers[index1];
    				numbers[index1] = numbers[index2];
    				numbers[index2] = tempInt;
    				
    				String tempStr = romanNumbers[index1];
    				romanNumbers[index1] = romanNumbers[index2];
    				romanNumbers[index2] = tempStr;
    				
    			}
    			index2++;
    		}
    		index1++;
    	}
    	
    	List<String> sortedRoman = new ArrayList<String>();
    	for(int index2=0; index2<N; index2++) {
    		sortedRoman.add(justNames[index2] + " " + romanNumbers[index2]);
    	}
    	return sortedRoman;
    }
    
    /* Method to convert Roman numbers to standard numbers. Input String array, output int array */
    
    public static int[] toNumbers(String[] romanNumbers) {
    	int N = romanNumbers.length;
    	int[] numbers = new int[N];
    	for(int index1=0; index1<N; index1++) {
    		numbers[index1] = toNumber(romanNumbers[index1]);
    	}
    	return numbers;
    }
    
    /* Method to convert Roman number to standard number. Input String, output int */
    
    public static int toNumber(String roman) {
 
        int number = 0; 

        for (int index1=0; index1<roman.length(); index1++) 
        { 
            int first = romanCharacterToNumber(roman.substring(index1,index1+1)); 
      
            if (index1+1 < roman.length()) 
            { 
                int second = romanCharacterToNumber(roman.substring(index1+1,index1+2)); 
      
                if (first >= second) 
                { 
                	number = number + first; 
                } 
                else
                { 
                	number = number + second - first; 
                    index1++;
                } 
            } 
            else
            { 
            	number = number + first; 
                 
            } 
        } 
        return number; 
    }
    
    /* Method to convert roman character to number. Input String, output int */
    
	public static int romanCharacterToNumber(String letter) {
		switch(letter) {
			case "I": return 1;
			case "X": return 10;
			case "L": return 50;
			default: return -1;
		}
	}

}
