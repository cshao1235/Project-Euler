import java.util.ArrayList;
import java.util.HashSet;


public class MethodSieveOfEratosthenes {
	public static ArrayList<Integer> primes(int limit)
	{
		boolean[] isNotPrime = new boolean[limit+1];
		for(int k = 2; k*k <= limit; k++)
		{
			if(!isNotPrime[k])
			{
				for(int i = 2*k; i <= limit; i+=k)
				{
					isNotPrime[i] = true;
				}
			}
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = 2; i <= limit; i++)
		{
			if(!isNotPrime[i])
				primes.add(i);
		}
		return primes;
		/*ArrayList<Long> sieve = new ArrayList<Long>();
		for(long i = 2; i <= limit; i++)
			sieve.add(i);
		for(long k = 2; k*k <= limit; k++)
		{
			for(long i = 2*k; i <= limit; i+=k)
				sieve.remove(new Long(i));
		}
		return sieve;*/
		//System.out.println(sieve.toString());
		//System.out.println(sieve.size());
	}
	public static void main(String[] args) {
		System.out.println(primes(100).toString());

	}

}
