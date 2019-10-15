import java.util.HashMap;
import java.util.Map;

public class InternalNodes {
    public static int count(int[] tree) {
    	Map<Integer,Integer> mapCount = new HashMap<Integer, Integer>();
    	for(int index1=0;index1<tree.length;index1++) {
    		mapCount.put(tree[index1],tree[index1]);
    	}
    	return mapCount.size()-1;
    }

    public static void main(String[] args) {
        System.out.println(InternalNodes.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}