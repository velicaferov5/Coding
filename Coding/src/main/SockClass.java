package main;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockClass {

	/**
	 * Finds total number of pairs found in various {@param socks}
	 * 
	 * @param socks
	 * @return number of pairs
	 */
    public int sockMerchant(int[] socks) {
    	Map<Integer,Integer> sockMap = new HashMap<Integer,Integer>();
        for(int index=0;index<socks.length;index++){
            if(sockMap.containsKey(socks[index])) {
                sockMap.put(socks[index], sockMap.get(socks[index])+1);
            }
            else sockMap.put(socks[index], 1);
        }
        return sockMap.values().stream().mapToInt(i->i/2).sum();
    }
}
