import java.util.ArrayList;
//import java.util.HashSet;


public class Problem10SummationOfPrimes {
	public static void main(String[] args)
	{
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(2000000);
		long sum = 0;
		for(int p : primes)
			sum += p;
		System.out.println(sum);
	}

}
