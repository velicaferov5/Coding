package main;
import java.util.ArrayList;
import java.util.List;

public class FindCountries {
	/**
	 * Calculates number of different countries.
	 * Every value of {@param A} indicates colour of current point. Neighbours with same colours belong to the same country.
	 * 
	 * @param colors
	 * @return number of countries
	 */
    public int findCountries(int[][] colors) {
        
    	// Country indexes are assigned to keep record of different countries
    	int[][] countriesMatrix = new int[colors.length][colors[0].length];
    	
    	for(int index1=0;index1<colors.length;index1++) {
    		for(int index2=0;index2<colors[0].length;index2++) {
    			countriesMatrix[index1][index2]=-1;
    		}    		
    	}

    	countriesMatrix[0][0]=0;
    	int countries=1;
    	
        for(int index1=0;index1<colors.length;index1++) {
        	for(int index2=0;index2<colors[0].length;index2++) {
        		
        		if(index2<colors[0].length-1) {
	        		if(colors[index1][index2]==colors[index1][index2+1]) {
	        			countriesMatrix[index1][index2+1]=countriesMatrix[index1][index2];
	        		}
	        		else {
	        			if(countriesMatrix[index1][index2+1]<0) {
	        				countriesMatrix[index1][index2+1]=++countries;
	        			}
	        		}
        		}
        		
        		if(index1<colors.length-1) {
	        		if(colors[index1][index2]==colors[index1+1][index2]) {
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
