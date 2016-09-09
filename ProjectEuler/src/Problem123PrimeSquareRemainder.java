import java.util.ArrayList;


public class Problem123PrimeSquareRemainder
{
	private static final long BOUND = 10000000000L;
	public static long nthPrime(int n)
	{
		if(n == 1)
			return 2;
		else if(n == 2)
			return 3;
		else
		{
			int primeCount = 2;
			boolean[] isPrime = new boolean[96*n+2];
			isPrime[2] = true;
			isPrime[3] = true;
			int prime = 0;
			for(int i = 1; i <= 16*n; i++)
			{
				int a = 6*i - 1;
				boolean isAPrime = true;
				for(int k = 2; k <= Math.sqrt(a); k++)
				{
					if(isPrime[k] && a%k == 0)
					{
						isAPrime = false;
						break;
					}
				}
				isPrime[a] = isAPrime;
				if(isAPrime)
					primeCount++;
				if(primeCount == n)
				{
					prime = a;
					break;
				}
				int b = 6*i + 1;
				boolean isBPrime = true;
				for(int k = 2; k <= Math.sqrt(b); k++)
				{
					if(isPrime[k] && b%k == 0)
					{
						isBPrime = false;
						break;
					}
				}
				isPrime[b] = isBPrime;
				if(isBPrime)
					primeCount++;
				if(primeCount == n)
				{
					prime = b;
					break;
				}
			}
			return prime;
		}
	}
	public static void main(String[] args) {
		//ArrayList<Integer> primes = SieveOfEratosthenes.primes(100000);
		//System.out.println(primes.toString());
		int count = 21001;
		//System.out.println("A");
		//while(count < primes.size() && 2L*(primes.get(count-1).longValue())*count < BOUND)
			//count++;
		long product = nthPrime(count)*2*count; 
		while(product <= BOUND)
		{
			System.out.println(count + " " + product);
			count+=2;
			product = nthPrime(count)*2*count;
		}
		System.out.println(count);
	}

}
