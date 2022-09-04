package sorting.array.algos;

import java.util.Scanner;

public class Reversal_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		int rotate=sc.nextInt();

		Rotate_an_Array(arr,rotate);

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + "\t");
	}

	private static void Rotate_an_Array(int[] arr, int rotate) {
		// TODO Auto-generated method stub
		
		rotate = rotate % arr.length;		// agr rotate ki value n se size of array se bdi hai toh index ki 													value -ve bn skti hai..  arr[]={1,2,3} k=4 --> arr[-1]
		reverse(arr, arr.length-rotate, arr.length-1); 							//rev last n elements of array
		
		reverse(arr, 0, arr.length-1);					//rev whole array
		
		reverse(arr, rotate, arr.length-1);
		
	}
	
	public static void reverse(int[] arr, int p, int q)
	{
		for (int i = p, j=q; i<j ; i++,j--) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		
	}

}
