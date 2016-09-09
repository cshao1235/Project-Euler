import java.util.Arrays;


public class Problem216InvestigatingPrimality {
	public static boolean isPrime(int n)
	{
		for(int i = 2; i <= Math.sqrt(n); i++)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	public static int numPrimes(int max) //number of n <= max such that 2*n*n - 1 is prime
	{
		boolean[] sieve = new boolean[max + 1];
		for(int i = 2; i <= max; i++)
			sieve[i] = true;
		for(int i = 2; i <= max; i++)
		{
			if(sieve[i])
			{
				long p = 2*i*i - 1;
				for(long j = i + p; j <= max; j+=p)
					sieve[(int) j] = false;
				for(long j = p - i; j <= max; j+=p)
					sieve[(int) j] = false;
			}
		}
		int count = 0;
		for(int i = 2; i <= max; i++)
		{
			if(sieve[i])
				count++;
		}
		for(int i = 2; i <= max; i++)
		{
			System.out.println(sieve[i] + " " + (2 * i * i - 1));
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(numPrimes(10000));

	}

}
