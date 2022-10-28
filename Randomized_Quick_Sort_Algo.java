package sorting.array.algos;

import java.util.Random;

public class Randomized_Quick_Sort_Algo {
					// Quick Sort givinf worst complexity n2 thats why randomized quick sort obtain ==> nlog(n)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8,2,5,1,3,6,-2,7,3};

		quickSort(arr,0,arr.length-1);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+"  ");
		}
	}

	private static void quickSort(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		if(si>ei)
		{
			return;
		}
		
		int pi = pivotPartition(arr,si,ei);
		
//		System.out.println("\n"+pi);
		
		
		quickSort(arr, si, pi-1);
		quickSort(arr, pi+1, ei);
		
	}

	private static int pivotPartition(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		
		// generate random pivot element index
		Random rn = new Random();
		int r = rn.nextInt(ei-si+1)+si;			// random index generate kra ke pivot element ka
		int tempoo = arr[r];
		arr[r]=arr[ei];					// hmesha hm last wala index ei lene ke wjah ab hm random index wale no ko pivot element lege
		arr[ei]=tempoo;					// ei wala element nd pi wala element ko interchange krdiye
		
		
		int pi=si;
		int item = arr[ei];
		
		for ( ; si < ei; ) 
		{
			if(arr[si]<item)
			{
				int temp = arr[si];
				arr[si]=arr[pi];
				arr[pi]=temp;
				
				pi++;
			}
			si++;
			
		}
		
//		pi will contains the exact index location to putr Pivot element
		arr[ei]=arr[pi];
		arr[pi]=item;
		
		return pi;
	}

}
