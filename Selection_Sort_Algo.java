package sorting.array.algos;

import java.util.Scanner;

public class Selection_Sort_Algo {
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		Selection_Sort(arr,n);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void Selection_Sort(int[] arr, int n) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<n-1)
		{
			int smallest=i+1;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[smallest]>arr[j])
					smallest=j;
			}
			
			if(arr[i]>arr[smallest])
				swap(i,smallest,arr);
			
			i++;
		}
		
	}

	public static void swap(int i, int smallest, int[] arr) {
		// TODO Auto-generated method stub
		int temp=arr[i];
		arr[i]=arr[smallest];
		arr[smallest]=temp;
	}
}