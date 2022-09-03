package sorting.array.algos;

public class Kadane_Algo_MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =  { 2, 3, -5, 11, -1, 3 };
		int maxSubArraySum = MaxSubArraySum(arr);
		System.out.println(maxSubArraySum);
	}

	private static int MaxSubArraySum(int[] arr) {
		// TODO Auto-generated method stub
		int sum=0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			sum=sum+arr[i];
			maxSum=Math.max(maxSum, sum);
			if(sum<0)
				sum=0;
		}
		
		return maxSum;
	}

}
