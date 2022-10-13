package MergeSort_QuickSort;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2,5,6,10,12,13,16,20,22,26,29,31,32};
		int[] arr2 = {3,4,10,12,16,31};
		
		int[] ans = mergeTwoArrays(arr1,arr2);


		for (int m = 0; m < ans.length; m++) {
			System.out.print(ans[m]+ "\t");
		}
	}

	private static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int[] ans = new int[arr1.length+arr2.length];
		
		int i=0;
		int j=0;
		int k=0;
		
		for (k = 0; i<arr1.length && j<arr2.length; k++) 
		{
			if(arr1[i]<arr2[j])
			{
				ans[k]=arr1[i];
				i++;
			}
			else
			{
				ans[k]=arr2[j];
				j++;
			}
		}
		
		while(i<arr1.length)
		{
			ans[k]=arr1[i];
			i++;
			k++;
		}
		
		while(j<arr2.length)
		{
			ans[k]=arr2[j];
			j++;
			k++;
		}
		
		return ans;
	}

}
