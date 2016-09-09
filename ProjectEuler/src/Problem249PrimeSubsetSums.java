import java.util.ArrayList;
import java.util.Arrays;


public class Problem249PrimeSubsetSums {
	private static final long MOD = 10000000000000000L; //10^16
	public static long numPrimeSubsetSums(int bound) //number of subsets with prime sum in set of primes below bound
	{
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(bound);
		//System.out.println(primes.toString());
		int sum = 0;
		for(int i = 0; i < primes.size(); i++)
			sum += primes.get(i);
		long[] numSubsetsWithSum = new long[sum + 2]; //last one is max sum so far
		numSubsetsWithSum[0] = 1;
		numSubsetsWithSum[2] = 1;
		numSubsetsWithSum[sum + 1] = 2;
		for(int i = 1; i < primes.size(); i++)
		{
			int max = (int) numSubsetsWithSum[sum + 1];
			for(int j = max; j >= 0; j--)
			{
				int newIndex = j + primes.get(i);
				numSubsetsWithSum[newIndex] = numSubsetsWithSum[newIndex] + numSubsetsWithSum[j];
				while(numSubsetsWithSum[newIndex] > MOD)
					numSubsetsWithSum[newIndex] -= MOD;
			}
			numSubsetsWithSum[sum + 1] = max + primes.get(i);
		}
		//System.out.println(Arrays.toString(numSubsetsWithSum));
		ArrayList<Integer> primes1 = MethodSieveOfEratosthenes.primes(sum);
		long output = 0;
		for(int i = 0; i < primes1.size(); i++)
		{
			output = output + numSubsetsWithSum[primes1.get(i)]%MOD;
			while(output > MOD)
				output -= MOD;
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(numPrimeSubsetSums(5000));

	}

}
