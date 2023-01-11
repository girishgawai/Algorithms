package sorting.array.algos;

import java.util.Arrays;

public class Counting_Sort_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,5,2,1,3,1,2,5,4,2,1,6,12,1,9};
		
		int[] ans = countingSort(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + "  ");
		}
	}

	private static int[] countingSort(int[] arr) {
		// TODO Auto-generated method stub
		int max = Arrays.stream(arr).max().getAsInt(); 									// yeh [] me se sbse bdi value dega dhund kr
		
//		jo sbse bdi value se +1 hogi utne hi size ka Frequency counting [] bnayege jo count rkhega freq ka woh nums kitne bar aye hai arr me
		// jo val hogi arr[i] ki uski freq freq[] me maintain rkhege
		int[] freq = new int[max+1];
		
		for(int i=0;i<arr.length;i++)		// arr[i] me jo v values hai unn values ko freq[val] idx pe +1 krege jb jb arr[i] me val milegi
		{
			int item = arr[i];
			freq[item]++;
		}
		
		// Ab iss freq[] ko hi Cummulative Sum wala [] bna lege jisme sare elements ki values ki sum rhegi av tk ke
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i] + freq[i-1];
		}
		
		// Ab ek ans[] bna lege jisme sare elements store krege sorted format mein
		int[] ans = new int[arr.length];
		
		// Ab hm Original arr[] mein traverse krege pichese.. woh easy jayega
		// aur arr[i] me jo element rhega .. uss element ke index pe Cumulative[] me jo value rhegi usko 1 se cum krege (-1)
		// means uss value pe data jayega av original arr[i] wala
		for (int i = arr.length-1; i >=0 ; i--) {
			int item = arr[i];
			
			freq[item]--;							// cumulative sum wale [] pe jo val hai usko 1 se cum krege (-1)
			int idx = freq[item];								// then uss idx pe ki value wala idx nikal lege
			
			ans[idx] = arr[i];			// uss cumulative freq wale index pe ki val -1 krne pe ane wale idx pe original arr[i] wala data rkhege
		}
		
		return ans;
	}

}
