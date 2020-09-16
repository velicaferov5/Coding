package main;
import java.util.ArrayList;
import java.util.List;

public class PackNumbers {

	/**
	 * Packs sequentially same numbers in Number:Sequence format and rest not formatted
	 * 
	 * @param arr
	 * @return packed list of numbers
	 */
    public List<String> packNumbers(List<Integer> arr) {
    	List<String> packedList = new ArrayList<String>();
    	
    	// Add numbers to packedList via while loop
    	Integer index1=0;
    	while(index1<arr.size()-1) {
    		Integer number = arr.get(index1);
    		Integer sequence=1;
    		
    		while(index1<arr.size()-1 && arr.get(index1).equals(arr.get(index1+1))) {
    			sequence++;
    			index1++;
    		}
    		
    		if(sequence>1) {
    			packedList.add(number+":"+sequence);
    		}
    		else {
    			packedList.add(Integer.toString(number));
    		}
    		index1++;
    	}
    	
    	if(arr.size()>1 && !arr.get(arr.size()-1).equals(arr.get(arr.size()-2)))
			packedList.add(Integer.toString(arr.get(arr.size()-1)));
    	
    	return packedList;
    }

    /**
     * Shorter alternative of {@link packNumbers()}
     * 
     * @param arr
     * @return packed list of numbers
     */
    public List<String> packNumbers_alternative(List<Integer> arr) {
        List<String> packedList = new ArrayList<String>();
        
        for (int index=0; index<arr.size()-1; index++) {
            int number = arr.get(index);
            int sequence=1;
            
            // Iterate over loop to pack same numbers
            while (index<arr.size()-1 && arr.get(index).equals(arr.get(index+1))) {
                sequence++;
                index++;
            }
            if (sequence>1) {
                packedList.add(number+":"+sequence);
            } else {
                packedList.add(Integer.toString(number));
                // Add last not same element
                if (index==arr.size()-2) {
                    packedList.add(Integer.toString(arr.get(arr.size()-1)));
                }
            }
        }
        return packedList;
    }

}
