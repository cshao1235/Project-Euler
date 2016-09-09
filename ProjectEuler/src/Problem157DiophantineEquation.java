import java.util.ArrayList;


public class Problem157DiophantineEquation {
	public static long numFactors(long n)
	{
		if(n == 1)
			return 1;
		long numFactors = 2;
		for(int i = 2; i <= n/2; i++)
		{
			if(n % i == 0)
				numFactors++;
		}
		return numFactors;
	}
	public static long numSolutions(int n) //number of solutions to 1/a + 1/b = p/10^n
	{
		long numSolutions = 0;
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= n; j++) //a = 5^i, b = 2^j
			{
				long a = (long) Math.pow(5, i);
				long b = (long) Math.pow(2, j);
				numSolutions += (n-i+1) * (n-j+1) * numFactors(a + b);
			}
		}
		for(int i = 0; i <= n; i++)
		{
			for(int j = 0; j <= n; j++) //a = 1, b = 5^i * 2^j
			{
				if(i != 0 && j != 0)
				{
					long b = (long) (Math.pow(5, i) * Math.pow(2, j));
					numSolutions += (n-i+1) * (n-j+1) * numFactors(b + 1);
				}
				else if(j == 0)
				{
					long b = (long) Math.pow(5, i);
					numSolutions += (n-i+1) * (n+2) * numFactors((b+1)/2);
				}
				else
				{
					long b = (long) Math.pow(2, j);
					if(j % 4 != 2)
						numSolutions += (n-j+1) * (n+1) * numFactors(b+1);
					else
						numSolutions += (n-j+1) * (n+2) * numFactors((b+1)/5);
				}
			}
		}
		return numSolutions;
	}
	public static void main(String[] args) {
		long sum = 0;
		int max = 9;
		for(int i = 1; i <= max; i++)
		{
			System.out.println(i);
			long a = numSolutions(i);
			System.out.println(a);
			sum += a;
		}
		System.out.println(sum);
	}

}
