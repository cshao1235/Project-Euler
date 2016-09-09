import java.util.ArrayList;


public class Problem203SquareFreeBinomialCoefficients {
	public static boolean isSquareFree(long n, ArrayList<Integer> primes)
	{
		for(int p : primes)
		{
			if(n % p == 0 && (n/p) % p == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int max = 50;
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(max);
		long[][] binomialCoefficients = new long[max+1][max+1];
		binomialCoefficients[0][0] = 1;
		for(int i = 1; i <= max; i++)
		{
			binomialCoefficients[i][0] = 1;
			for(int j = 1; j <= i; j++)
			{
				binomialCoefficients[i][j] = binomialCoefficients[i-1][j] + binomialCoefficients[i-1][j-1];
			}
		}
		ArrayList<Long> distinctCoefficients = new ArrayList<Long>();
		for(int i = 0; i <= max; i++)
		{
			for(int j = 0; j <= i/2; j++)
			{
				if(!distinctCoefficients.contains(binomialCoefficients[i][j]))
					distinctCoefficients.add(binomialCoefficients[i][j]);
			}
		}
		long sum = 0;
		for(long a : distinctCoefficients)
		{
			if(isSquareFree(a, primes))
				sum += a;
		}
		System.out.println(sum);
	}

}
