import java.util.ArrayList;
import java.util.List;

/* Every value of matrix indicates a color of current point. Neighbours with same colours belong to same country.
 * findCountries function calculates number of different countries. */

public class FindCountries {
    public int findCountries(int[][] A) {
        
    	/* Countries matrix is declared and -1 allocated. Country indexes will be assigned.
    	 * It will be used to keep record of different countries */
    	
    	int[][] countriesMatrix = new int[A.length][A[0].length];
    	
    	for(int index1=0;index1<A.length;index1++) {
    		for(int index2=0;index2<A[0].length;index2++) {
    			countriesMatrix[index1][index2]=-1;
    		}    		
    	}

    	countriesMatrix[0][0]=0;
    	int countries=1;
    	
        for(int index1=0;index1<A.length;index1++) {
        	for(int index2=0;index2<A[0].length;index2++) {
        		
        		if(index2<A[0].length-1) {
	        		if(A[index1][index2]==A[index1][index2+1]) {
	        			countriesMatrix[index1][index2+1]=countriesMatrix[index1][index2];
	        		}
	        		else {
	        			if(countriesMatrix[index1][index2+1]<0) {
	        				countriesMatrix[index1][index2+1]=++countries;
	        			}
	        		}
        		}
        		
        		if(index1<A.length-1) {
	        		if(A[index1][index2]==A[index1+1][index2]) {
	        			countriesMatrix[index1+1][index2]=countriesMatrix[index1][index2];
	        		}
	        		else {
	        			if(countriesMatrix[index1+1][index2]<0) {
	        				countriesMatrix[index1+1][index2]=++countries;
	        			}
	        		}
        		}
        	}
        }
        return countries;
    }
}
