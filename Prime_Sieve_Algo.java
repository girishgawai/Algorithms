package prime.sieve;

public class Prime_Sieve_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =100;										// Print all prime nos upto n
		
		printPrime(n);
	}

	private static void printPrime(int n) {
		// TODO Auto-generated method stub
													// true--> non-prime		false--> prime
		boolean[] numberBoard = new boolean[n+1];
		numberBoard[0]=true;
		numberBoard[1]=true;
		
		for (int i = 2; i*i<=n; i++) 
		{
			if(numberBoard[i]==false)
			{
				for (int mult = 2; mult*i <= n; mult++) 
				{
					numberBoard[mult*i]=true;		// jo v nums divide hoe hai ya factorial//mulitples hai i ke sbko non prime mark krdo
				}
				
			}
			
		}
		
		for (int i = 0; i < numberBoard.length; i++) {
			if(numberBoard[i]==false)
				System.out.print(i + "  ");
		}
		
	}

}
