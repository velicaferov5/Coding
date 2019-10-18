import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Optional;

/* Class and function to calculate first and most occurring character in text */

public class MaximumOccurringCharacter {
    public char maximumOccurringCharacter(String text) {

    	/* LinkedHashMap<> is used to put and get Strings (1 character) and their occurrences in order  */

    	LinkedHashMap<String, Integer> occurenceMap = new LinkedHashMap<String, Integer>(); 
    	for(int index1=0;index1<text.length()-1;index1++) {
    		String character = text.substring(index1,index1+1);
    		if(occurenceMap.get(character)!=null) {
    			occurenceMap.put(character,occurenceMap.get(character)+1);
    		}
    		else {
    			occurenceMap.put(character,1);
    		}
    	}
    	
    	int occurence=0;
    	char maxChar=text.charAt(0);
    	for(String str:occurenceMap.keySet()){
    		if(occurenceMap.get(str)>occurence) {
    			occurence=occurenceMap.get(str);
    			maxChar=str.charAt(0);
    		}
    	}
    	return maxChar;
    }

}
