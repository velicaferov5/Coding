import java.util.List;

/* Alaadin loses as much magic as the distance. He needs to make a full cycle by walking through points and to return starting point.
 * Following class and method finds first point (=most optimal) to make full cycle.
 * Returns -1 if full cycle not possible from any point */

public class AlaadinsJourney {

	public int optimalPoint(List<Integer> magic, List<Integer> dist) {

    	int N = magic.size();
    	for(int index1=0;index1<N;index1++) {
    		int steps=0;
    		int magicLeft=magic.get(index1);
    		int previousIndex=index1;
    		int index2=index1+1;

    		if(index2==N)
    			index2=0;

    		while(steps<N && magicLeft>=dist.get(previousIndex)) {
    			magicLeft-=dist.get(previousIndex);
    			steps++;
    			previousIndex=index2;
    			index2++;
        		if(index2==N) {
        			index2=0;
        		}
    			magicLeft+=magic.get(index2);
    		}
    		if(steps==N)
    			return index1;
    	}
    return -1;
    }
}