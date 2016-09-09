
public class Problem202Laserbeam {
	public static long gcd(long a, long b)
	{
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		if(a > b)
			return gcd(a%b, b);
		if(a < b)
			return gcd(a, b%a);
		else
			return a;
	}
	public static void main(String[] args) {
		long n = 12017639147L;
		long sum = (n+3)/2;
		long a = n%3;
		//long b = n - a;
		long count = 0;
		while(a <= sum)
		{
			if(gcd(sum, a) == 1)
				count++;
			a += 3;
		}
		System.out.println(count);
	}

}
