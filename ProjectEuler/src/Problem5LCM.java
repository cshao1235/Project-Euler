public class Problem5LCM {
	public static long gcd(long a, long b)
	{
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		if(a == b)
			return a;
		else if(a > b)
			return gcd(a - b*(a/b), b);
		else
			return gcd(a, b - a*(b/a));
	}
	public static long lcm(long a, long b)
	{
		return a*b/gcd(a, b);
	}
	public static long lcm(long max)
	{
		if(max == 1)
			return 1;
		else
		{
			long n = lcm(max-1);
			if(n % max == 0)
				return n;
			else
				return lcm(n, max);
		}
	}
	public static void main(String[] args)
	{
		System.out.println(gcd(2, 3));
		System.out.println(lcm(30));
	}

}
