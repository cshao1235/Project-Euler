
public class Problem221AlexandrianIntegers {
	public static long numFactorPairs(long n)
	{
		if(n == 1)
			return 1;
		long numFactors = 0;
		for(int i = 1; i <= Math.sqrt(n); i++)
		{
			if(n % i == 0)
				numFactors++;
		}
		return numFactors;
	}
	public static long nthAlexandrianInteger(int target)
	{
		int count = 0;
		long p = 1;
		while(count < target)
		{
			count += numFactorPairs(p*p + 1);
			p++;
		}
		p--;
		long n = p*p + 1;
		for(int i = 1; i <= Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				if(count > target)
					count--;
				else
				{
					return (p * (i + p) * (n / i + p));
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++)
			System.out.println(nthAlexandrianInteger(i));
		System.out.println(nthAlexandrianInteger(150000));
	}

}
