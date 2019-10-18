import java.util.ArrayList;
import java.util.List;

/* PackNumbers class and methods to pack sequentially duplicate numbers in Number:sequence and rest just number format */

public class PackNumbers {

    public List<String> packNumbers(List<Integer> arr) {
    	List<String> packedList = new ArrayList<String>();
    	
    	/* numbers added to packedList thorugh while loop */
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

    /* Alternative and shorter method for same functionality */
    
    public List<String> packNumbers_alternative(List<Integer> arr) {
        List<String> packedList = new ArrayList<String>();
        
        for(int index1=0;index1<arr.size()-1;index1++) {
            int number = arr.get(index1);
            int sequence=1;
            
            while(index1<arr.size()-1 && arr.get(index1)==arr.get(index1+1)) {
                sequence++;
                index1++;
            }
            if(sequence>1) {
                packedList.add(number+":"+sequence);
            }
            else {
                packedList.add(Integer.toString(number));
            }
        }
        return packedList;
    }

}
