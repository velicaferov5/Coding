import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/* Program calculates similarity between texts */

public class CalculateSimilarity {

	public static String calculateScore(String text, String prefixString, String suffixString) {

		int prefixIndex=suffixString.length();
		boolean limitReached = false;

		while(prefixIndex > 0 && !limitReached){
			if(text.contains(prefixString.substring(prefixIndex-1))){
				prefixIndex--;
			}
			else{
				limitReached = true;
			}
		}
		
		int suffixIndex=0;
		limitReached = false;

		while(suffixIndex < suffixString.length() && !limitReached){
			if(text.contains(suffixString.substring(0, suffixIndex+1))){
				suffixIndex++;
			}
			else{
				limitReached = true;
			}
		}
		String prefixMatched = prefixString.substring(prefixIndex);
		String suffixMatched = suffixString.substring(0,suffixIndex);
		if(text.matches(prefixMatched+"+\\w+"+suffixMatched)){
			return text.substring(text.indexOf(prefixMatched),text.lastIndexOf(suffixMatched)+suffixMatched.length());
		}

		else if(prefixMatched.compareTo(suffixMatched)<0){

			return prefixMatched;
		}
		else return suffixMatched;
	}
}