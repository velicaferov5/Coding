import java.util.HashMap;
import java.util.Map;

public class InternalNodes {
	
	/* Service to count internal nodes (excluding root!) of tree expressed in an array indicating parent nodes with numbers */
    public int count(int[] tree) {
    	Map<Integer,Integer> mapCount = new HashMap<Integer, Integer>();
    	for(int index1=0;index1<tree.length;index1++) {
    		mapCount.put(tree[index1],tree[index1]);
    	}
    	return mapCount.size()-1;
    }
}