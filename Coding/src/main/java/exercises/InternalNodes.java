package exercises;

import java.util.HashMap;
import java.util.Map;

public class InternalNodes {

    /**
     * Counts internal nodes (excluding root!) of {@param tree} expressed in an array indicating parent nodes with numbers
     *
     * @param tree
     * @return number of internal nodes of tree
     */
    public int count(int[] tree) {
        Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
        for (int index1 = 0; index1 < tree.length; index1++) {
            mapCount.put(tree[index1], tree[index1]);
        }
        return mapCount.size() - 1;
    }
}