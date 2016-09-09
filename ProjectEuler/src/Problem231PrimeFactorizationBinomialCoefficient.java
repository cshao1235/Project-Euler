import java.util.ArrayList;


public class Problem231PrimeFactorizationBinomialCoefficient {
	public static int pAdicValuationFactorial(int n, int p) //v_p(n!)
	{
		int a = n;
		int sumOfDigits = 0;
		while(a > 0)
		{
			sumOfDigits += a%p;
			a/=p;
		}
		return (n - sumOfDigits)/(p - 1);
	}
	public static long binomialPrimeFactorize(int m, int n)
	{
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(m);
		//System.out.println(primes.toString());
		long sum = 0;
		for(int p : primes)
		{
			System.out.println(p);
			int exp = pAdicValuationFactorial(m, p) - pAdicValuationFactorial(n, p) - pAdicValuationFactorial(m-n, p);
			sum += p * exp;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(binomialPrimeFactorize(20000000, 15000000));

	}

}
