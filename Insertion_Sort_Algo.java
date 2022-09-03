package sorting.array.algos;

import java.util.Scanner;

public class Insertion_Sort_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}

		Insertion_Sort_Algo(arr);

		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}

	}

	private static void Insertion_Sort_Algo(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 1; i < arr.length; i++) {
			int item = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > item) {
				arr[j + 1] = arr[j];
				j--;
			}
			j++;
			arr[j]=item;

		}
	}
}
