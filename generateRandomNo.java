import java.util.Iterator;
import java.util.Random;

public class generateRandomNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rn = new Random();
		int low=10;
		int high=100;
		
		int t=100;
		while(t>50)
		{
			System.out.print((rn.nextInt(high-low+1)+low)+ "  ");
			t--;
		}

	}

}
