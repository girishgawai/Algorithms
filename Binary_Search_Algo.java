package sorting.array.algos;
import java.util.Scanner;

public class Binary_Search_Algo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int find = sc.nextInt();				// item to find
		
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i] = sc.nextInt();
		
		int ans = findSquareRootOf(find,arr);
		System.out.println(ans);
	}
	
	
	public static int findSquareRootOf(int n, int[] arr)
	{
		
		
		int low=0,high=arr.length-1,mid=0;
		for(int i=0;low<=high;i++)
		{
			mid=(low+high)/2;
			
			if(arr[mid]==n)
				return mid;
			else if(arr[mid]>n)
				high=mid-1;
			else
				low=mid+1;
		}
		
		return -1;
	}

}
