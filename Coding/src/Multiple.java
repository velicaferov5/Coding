import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Multiple {	
	
	public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
	    // Write your code here
		List<Integer> missingReservationList = new ArrayList<Integer>();
		
		int N = firstReservationList.get(0).get(0);
		int M = secondReservationList.get(0).get(0);
		
		Integer[] missingReservations = new Integer[M-2];
		Integer[] missingStamps = new Integer[M-2];
		
		int index1=2;
		while(index1<M) {
			boolean reservationExist=false;
			int index2=2;
			while(index2<N) {
				if(secondReservationList.get(index1).get(0).equals(firstReservationList.get(index2).get(0))) {
					reservationExist = true;
					index2=N-1;
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
		
		for(int index5=0; index5< missingReservations.length; index5++) {
			if(missingReservations[index5]!=null)
				missingReservationList.add(missingReservations[index5]);
		}
		
		return missingReservationList;
	}
	
}
