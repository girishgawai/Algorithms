package sorting.array.algos;

import java.util.Scanner;

public class DNF_DutchNationalFlagAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}

		letsDoDNF(arr,n);
	}

	public static void letsDoDNF(int[] arr, int n)
	{
		int i=0;		// i--> pos rkhega 0 ko save krne ki
		int j=n-1;		// j--> position rkhega 2 ko sve krne ki
		int k=0;		// traverse over array
		
		while(k<=j)
		{
			int temp=0;
			if(arr[k]==0)
			{
				temp=arr[i];
				arr[i]=arr[k];
				arr[k]=temp;
				
				i++;
				k++;
			}
			else if(arr[k]==2)
			{
				temp=arr[j];
				arr[j]=arr[k];
				arr[k]=temp;
				
				j--;
			}
			else
			{
				k++;			//jb arr[k] ki value 1 rkhegi tb kuch nhi krna
			}
		}
		
		for (int l = 0; l < arr.length; l++) {
			System.out.println(arr[l]);
		}
	}

}
