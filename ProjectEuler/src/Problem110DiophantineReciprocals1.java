
public class Problem110DiophantineReciprocals1 {
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
	public static void main(String[] args) {
		int max = 1000;
		int i = 1;
		while(numFactors(i*i) <= 2*max - 1)
			i++;
		System.out.println(i);
	}

}
