package main;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {
    private static final Scanner scanner = new Scanner(System.in);
    
	/**
	 * Counts valleys. D is downstep, U is upstep. Starting point is 0, Valley is area under 0
	 * 
	 * @param n
	 * @param s
	 * @return number of valleys
	 */
    public int countingValleys(int n, String s) {
    	int valleyCount=0, level=0;
    	for(int index1=0;index1<n;index1++) {
    		String stepStr=s.substring(index1,index1+1);
    		if(stepStr.equals("U")) {
    			level++;
    		}
    		else{
    			level--;
        		if(level==-1)
        			valleyCount++;
    		}
    	}
    	return valleyCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        
        CountingValleys countingValleys = new CountingValleys();
        int result = countingValleys.countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
