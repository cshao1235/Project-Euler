
public class Problem146InvestigatingPrimePattern {
	public static boolean isPrime(long n)
	{
		if(n == 1)
			return false;
		if(n == 2)
			return true;
		for(int i = 3; i <= Math.sqrt(n); i+=2)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		long sum = 0;
		long max = 1000000L;
		long[] validResidues = {10, 220, 270, 290, 360, 430, 480, 550, 620, 640, 690, 900};
		for(long i = 0; i < max; i+=910)
		{
			for(int j = 0; j < validResidues.length; j++)
			{
				long k = i + validResidues[j];
				long square = k*k;
				if(isPrime(square + 1) && isPrime(square + 3) && isPrime(square + 7) && isPrime(square + 9) && isPrime(square + 13) && !isPrime(square + 21) && isPrime(square + 27))
					sum += k;
			}
		}
		System.out.println(sum);
		long b = System.currentTimeMillis();
		System.out.println(b - a);
	}

}
