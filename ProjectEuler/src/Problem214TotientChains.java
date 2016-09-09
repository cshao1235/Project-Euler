import java.util.ArrayList;


public class Problem214TotientChains {
	public static long eulerTotient(ArrayList<Integer> primes, long n) //primes must contain all primes < sqrt(n)
	{
		if(n == 1)
			return 0;
		for(int i = 0; i < primes.size(); i++)
		{
			if(primes.get(i) > n)
				return n;
			else if(n%primes.get(i) == 0)
			{
				n /= primes.get(i);
				n *= primes.get(i) - 1;
			}
		}
		return 0;
	}
	public static long primesWithChainLength(int bound, int length) //returns sum of primes < bound that generate totient chains of length "length"
	{
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(bound);
		System.out.println("A");
		long output = 0;
		for(int i = 0; i < primes.size(); i++)
		{
			int n = primes.get(i);
			int chainLength = 0;
			while(chainLength < length)
			{
				n = (int) eulerTotient(primes, n);
				chainLength++;
				if(n == 0)
					break;
			}
			if(n == 0 && chainLength == length)
				output += primes.get(i);
			if(i % 1000 == 0)
				System.out.println(primes.get(i));
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(primesWithChainLength(40000000, 25));

	}

}
