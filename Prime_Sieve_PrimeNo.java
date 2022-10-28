package prime.sieve;

public class Prime_Sieve_PrimeNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=19;
		
		boolean ans = checkPrime(n);
		System.out.println(ans);
		
	}

	private static boolean checkPrime(int n) {
		// TODO Auto-generated method stub
		int i=2;
		while(i*i<=n)			// square root checking 2x2, 3x3, ...
		{
			if(n%i==0)				// agr woh ith no divide krta hoga n ko toh prime nh hai
				return false;
			i++;
		}
		
		return true;
	}

}
