package MergeSort_QuickSort;

public class MergeSort_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,2,12,8,10,22,1,16,7,2,3,8,12,5,10,6};
		
		int[] ans = mergeSort(arr,0,arr.length-1);	// starting point of array 0 && end array ka last element jis index pe hai toh loc
		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]+"  ");
	}

	private static int[] mergeSort(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		if(si==ei)
		{
			int[] ans = new int[1];						// single element/number in array is sorted hota hai
			ans[0]=arr[si];
			return ans;
		}
		
		int mid = (si+ei)/2;								// array ko 2 parts me break down krne ke liye
		
		int[] oneSide = mergeSort(arr, si, mid);			// rightside ka part anotherSide[] me
		int[] anotherSide = mergeSort(arr, mid+1, ei);		// left side ka part oneSide[] me
		
		return mergeTwoArrays(oneSide, anotherSide);			// dono alg alg divided sorted array parts ko merge krne bhej dege
		
	}

	private static int[] mergeTwoArrays(int[] arrayLeftSide, int[] arrayRightSide) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		int[] mergedArray = new int[arrayLeftSide.length+arrayRightSide.length];
		int k=0;
		
		while(i<arrayLeftSide.length && j<arrayRightSide.length)
		{
			if(arrayLeftSide[i]<arrayRightSide[j])
			{
				mergedArray[k]=arrayLeftSide[i];
				i++;
				k++;
			}
			else
			{
				mergedArray[k]=arrayRightSide[j];
				j++;
				k++;
			}
		}
		
		while(i<arrayLeftSide.length)
		{
			mergedArray[k]=arrayLeftSide[i];
			i++;
			k++;
		}
		while(j<arrayRightSide.length)
		{
			mergedArray[k]=arrayRightSide[j];
			j++;
			k++;
		}
		
		return mergedArray;													// return merged array
	}

}
