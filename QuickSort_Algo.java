package MergeSort_QuickSort;

public class QuickSort_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,4,2,12,-2,5,-3,-5,3,2,8,6,11,7};
		
		quickSort(arr,0,arr.length-1);							// starting index of array & last element present index of array
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	private static void quickSort(int[] arr, int si, int ei) {
		// TODO Auto-generated method stub
		if(si>=ei)								// jb si bda hojayega ei se tb base case .. recursiion ruka dege
			return;									// si aage nikal gya ei ke  ==>  ei=-1 si=0 ==> ei<-- rhegya si--> ke
		
		
		int pivotPartition = pivotPartitionArray(arr,si,ei);
//		System.out.println(pivotPartition);
		
		quickSort(arr,si,pivotPartition-1);
		quickSort(arr, pivotPartition+1, ei);
		
	}

	private static int pivotPartitionArray(int[] arr,int si, int ei) {
		// TODO Auto-generated method stub
		int pi=si;								// storing 0 or starting index of small part of array to get it at pivot item
		int item = arr[ei];						// pivot element .. item me dala
		int i = si;
		
		while(i<ei)						// jab tk i< ei hai means first element ka index last ewlement index se chota hai tb tk hlo aage
		{
			if(arr[i]<item)	   // agr item ki value small hai toh i--> pi ki values ki swapping krdo and pi ko next index pe pointing kro
			{
				int temp = arr[i];
				arr[i]=arr[pi];
				arr[pi]=temp;
				
				pi++;					// agr swapping ki hai toh hi pi ko next index pe shift kro
			}
			i++;
		}
		
		// here we have to swap the last arr[ei or i] element with arr[pi] means pivot element ko apni correct location pe lao
		// ab pi se phle sare chote elements rhege and pi kle baad sare bde elements rhege
		int temp = arr[i];
		arr[i]=arr[pi];
		arr[pi]=temp;
		
		return pi;
	}

}
