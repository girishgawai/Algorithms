package sorting.array.algos;

import java.util.Scanner;

public class Bubble_Sort_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[] arr = new long[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextLong();
		}
		
		Bubble_Sort_Algo(arr,n);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

	private static void Bubble_Sort_Algo(long[] arr, int n) {
		// TODO Auto-generated method stub
		int turns=0;
		
		while(turns<n-1)
		{
			for(int i=1;i<n-turns;i++)
			{
				if(arr[i]<arr[i-1])
				{	
					swap(i,i-1,arr);
					
				}
			}
			turns++;
		}
	}

	private static void swap(int i, int j, long[] arr) {
		// TODO Auto-generated method stub
		long temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	

}
