package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Transaction class to find special bakery packs and their prices.
 * 
 * @author vjafarov
 */

public class Transaction {
		
	private static double total;

	public double getPrice(String code, int packs) {
		switch(code) {
		case "VS5": 
			switch(packs) {
			case 3: return 6.99;
			case 5: return 8.99;
			default: return 0.0;
		}
		case "MB11":
			switch(packs) {
			case 2: return 9.95;
			case 5: return 16.95;
			case 8: return 24.95;
			default: return 0.0;
			}
		case "CF":
			switch(packs) {
			case 3: return 5.95;
			case 5: return 9.95;
			case 9: return 16.99;
			default: return 0.0;
			}
		default: return -1;
		}
	}
	
	public int getPackSize(String code, int index) {
		switch(code) {
		case "VS5": 
			switch(index) {
			case 0: return 5;
			case 1: return 3;
			default: return 0;
		}
		case "MB11":
			switch(index) {
			case 0: return 8;
			case 1: return 5;
			case 2: return 2;
			default: return 0;
			}
		case "CF":
			switch(index) {
			case 0: return 9;
			case 1: return 5;
			case 2: return 3;
			default: return 0;
			}
		default: return -1;
		}
	}
	
	public List<String> buy(String code, int items) {
		List<String> result = new ArrayList<>();
		Map<Integer,Integer> packs = new HashMap<Integer, Integer>();
		int reminder1=1;
		int reminder2=1;
		int reminder3=1;
		int packIndex1=0;
		
		while(getPackSize(code, 0)>0 && reminder1>0  && reminder2>0  && reminder3>0 && getPackSize(code, 0)*packIndex1<items) {
			packs = new HashMap<Integer, Integer>();
			reminder1 = items%getPackSize(code, 0)+getPackSize(code, 0)*packIndex1;
			
			if(items/getPackSize(code, 0)-packIndex1>0)
				packs.put(getPackSize(code, 0),items/getPackSize(code, 0)-packIndex1);
			
			int packIndex2 = 0;
			while(getPackSize(code, 1)>0 && reminder1>0 && reminder2>0 && reminder3>0 && getPackSize(code, 1)*packIndex2<items) {
				reminder2 = reminder1%getPackSize(code, 1)+getPackSize(code, 1)*packIndex2;
				
				if(reminder1/getPackSize(code, 1)-packIndex2>0)
					packs.put(getPackSize(code, 1),reminder1/getPackSize(code, 1)-packIndex2);
				
				int packIndex3 = 0;
				
				while (getPackSize(code, 2)>0 && reminder1>0 && reminder2>0 && reminder3>0 && getPackSize(code, 2)*packIndex3<items) {
					reminder3 = reminder2%getPackSize(code, 2)+getPackSize(code, 2)*packIndex3;
					
					if(reminder2/getPackSize(code, 2)-packIndex3>0)
						packs.put(getPackSize(code, 2),reminder2/getPackSize(code, 2)-packIndex3);
					packIndex3++;
				}
				packIndex2++;
			}
			packIndex1++;
		} 
		total=0;
		packs.forEach((k,v)->{
			total = total+v*getPrice(code,k);
		});
		result.add(items+" "+code+" $"+total);

		packs.forEach((k,v)->{
			result.add(v+" x "+k +" $" + getPrice(code,k));
		});
		return result;
	}
}
