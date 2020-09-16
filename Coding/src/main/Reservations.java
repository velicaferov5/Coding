package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reservations {	
	
	/**
	 * Finds list of reservations existing in secondReservationList but missing in first.
	 * 1st values in input lists is number of reservations, 2nd is number of spaces (always 2) and rest are reservations and time-stamps
	 * 
	 * @param firstReservationList
	 * @param secondReservationList
	 * @return list of missing reservations
	 */
	public List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
	   
		List<Integer> missingReservationList = new ArrayList<Integer>();
		
		int N = firstReservationList.get(0).get(0);
		int M = secondReservationList.get(0).get(0);
		
		Integer[] missingReservations = new Integer[M-N];
		Integer[] missingStamps = new Integer[M-N];
		
		for(int index1=0; index1<M+2; index1++) {
			boolean reservationExist=false;
			int index2=0;
			while(index2<N+2) {
				if(secondReservationList.get(index1).get(0).equals(firstReservationList.get(index2).get(0))) {
					reservationExist = true;
					index2=N+1;
				}
				index2++;
			}
			if(!reservationExist) {
				missingReservations[index1-2] = secondReservationList.get(index1).get(0);
				missingStamps[index1-2] = secondReservationList.get(index1).get(1);
			}
			index1++;
		}
		
		for(int index3=0; index3< missingStamps.length; index3++) {
			for(int index4=index3+1; index4< missingStamps.length; index4++) {
				if(missingStamps[index3]>missingStamps[index4]) {
					int temp = missingReservations[index3];
					missingReservations[index3] = missingReservations[index4];
					missingReservations[index4] = temp;
					
					temp = missingStamps[index3];
					missingStamps[index3] = missingStamps[index4];
					missingStamps[index4] = temp;
				}
			}
		}
		
		return missingReservationList;
	}	
}