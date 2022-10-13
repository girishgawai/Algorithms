package MergeSort_QuickSort;

public class Partition_Pivot_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12,6,2,11,10,12,15,8,7,20,16,18,3,5};
		
		int pivotLoc = pivotPartition(arr,0,arr.length-1);
		System.out.println(pivotLoc);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ "  ");
		}
	}

	private static int pivotPartition(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		int pi=si;
		int item=arr[ei];		// last element daal diye pivot element
		int i=0;
		while(i<ei)
		{
			if(arr[i]<item)
			{
				swap(arr,i,pi);			// swap if arr[i] is less than item
				pi++;					// swap ke baad pi ke loc aage krdo next index pe
			}
			i++;
		}
		
		swap(arr,i,pi);					// swap kro ab last element item ko ppi se.. kyu ki item ko swap nh kia tha
		return pi;				// pi correct index aaya .. smaller sare phle and bigger sare aage
	}

	private static void swap(int[] arr, int i, int pi) {
		// TODO Auto-generated method stub
		int temp=arr[i];
		arr[i]=arr[pi];
		arr[pi]=temp;
	}

}
