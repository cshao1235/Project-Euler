import java.util.HashMap;


public class Problem169NumberOfWaysToExpressAsSumOfPowersOf2 { //number of ways to represent n as sum of powers of 2, where no power is used more than twice
	//f(n) = f(n/(2^(v_2(n)+1))) + v_2(n) * (f(n/2^(v_2(n)+1) * 2))
	
	//alternatively, f(2n) = f(n) + f(n-1), f(2n+1) = f(n)
	private static HashMap<Long, Long> ways = new HashMap<Long, Long>();
	public static long numberOfWays(long n)
	{
		//System.out.println(n);
		if(ways.keySet().contains(n))
			return ways.get(n); 
		long a = n;
		int v2 = 0;
		while(a % 2 == 0)
		{
			a /= 2;
			v2++;
		}
		if(a == 1)
		{
			ways.put(n, (long) v2 + 1);
			return v2 + 1;
		}
		else
		{
			long b = numberOfWays(a/2) + v2 * numberOfWays((a/2) * 2);
			ways.put(n, b);
			return b;
		}
	}
	public static void main(String[] args) {
		//long a = System.currentTimeMillis();
		System.out.println(Integer.toBinaryString(100));
		long pow = 1;
		for(int i = 1; i <= 25; i++)
			pow *= 5;
		System.out.println(numberOfWays(pow/2));
		System.out.println(25 * numberOfWays((pow/2) * 2) + numberOfWays(pow/2));
	}

}
