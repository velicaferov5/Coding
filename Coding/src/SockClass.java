import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* sockMerchant function getting various socks as ar[]. Returning total number of pairs found in ar[] */

public class SockClass {

    public int sockMerchant(int[] ar) {
    	Map<Integer,Integer> sockMap = new HashMap<Integer,Integer>();
        for(int index=0;index<ar.length;index++){
            if(sockMap.containsKey(ar[index])) {
                sockMap.put(ar[index], sockMap.get(ar[index])+1);
            }
            else sockMap.put(ar[index], 1);
        }
        return sockMap.values().stream().mapToInt(i->i/2).sum();
    }
}
