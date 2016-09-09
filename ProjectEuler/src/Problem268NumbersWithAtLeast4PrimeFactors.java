import java.util.ArrayList;


public class Problem268NumbersWithAtLeast4PrimeFactors {
	public static void main(String[] args) {
		int limit = 100;
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(limit);
		int numPrimes = primes.size();
		//System.out.println(numPrimes);
		int minPrimeFactors = 4;
		int maxPrimeFactors = 0;
		//long max = 1000;
		long max = (long) Math.pow(10, 16);
		long product = 1;
		for(int i = 0; i < numPrimes; i++)
		{
			maxPrimeFactors++;
			product *= primes.get(i);
			if(product > max)
				break;
		}
		long output = 0;
		long[][] binomial = new long[numPrimes + 1][numPrimes + 1];
		binomial[0][0] = 1;
		for(int i = 1; i <= numPrimes; i++)
		{
			binomial[i][0] = 1;
			for(int j = 1; j <= numPrimes; j++)
				binomial[i][j] = binomial[i - 1][j - 1] + binomial[i - 1][j];
		}
		long[] correction = new long[numPrimes + 1];
		for(int i = minPrimeFactors; i <= numPrimes; i++)
		{
			//int sign = 1;
			correction[i] = 1;
			for(int j = minPrimeFactors; j < i; j++)
			{
				correction[i] -= correction[j]*binomial[i][j];
			}
			//sign *= -1;
		}
		long[] divisors = new long[(int) Math.pow(2, numPrimes - 1)];
		divisors[0] = 1;
		for(int i = 0; i < divisors.length; i++)
		{
			if(divisors[i] == 0)
				continue;
			for(int j = 0; j < numPrimes - 1; j++)
			{
				if(divisors[i]*primes.get(j) > max)
					break;
				if(((i >>> j) & 1) == 0)
				{
					divisors[i + (int) Math.pow(2, j)] = divisors[i]*primes.get(j);
				}
			}
		}
		for(int i = 1; i < (int) Math.pow(2, numPrimes - 1); i++)
		{
			if(divisors[i] == 0)
				continue;
			int primeCount = 0;
			for(int j = 0; j < numPrimes - 1; j++)
			{
				if(((i >>> j) & 1) == 1)
					primeCount++;
			}
			output += correction[primeCount]*(max/divisors[i]);
			output += correction[primeCount + 1]*(max/(divisors[i]*primes.get(numPrimes - 1)));
			/*long divisor = 1;
			int primeCount = 0;
			System.out.println(i);
			boolean canAdd = true;
			for(int j = 0; j < numPrimes; j++)
			{
				if(((i >>> j) & 1) == 1)
				{
					divisor *= primes.get(j);
					primeCount++;
					if(primeCount > maxPrimeFactors)
					{
						canAdd = false;
						break;
					}
				}
			}
			if(canAdd && primeCount >= minPrimeFactors)
				output += correction[primeCount]*(max/divisor);*/
		}
		System.out.println(output);
	}

}
