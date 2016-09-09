import java.math.BigInteger;
import java.util.ArrayList;


public class Problem133RepunitNonfactors {
	public static long gcd(long a, long b)
	{
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		if(a > b)
			return gcd(a%b, b);
		if(b > a)
			return gcd(a, b%a);
		else
			return a;
	}
	public static void main(String[] args) {
		int max = 100000;
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(max);
		long sum = 3;
		for(long p : primes)
		{
			if(p == 3)
				continue;
			int p1 = (int) p;
			int n = p1 - 1;
			int exp = 1;
			while(n % 2 == 0)
			{
				n/=2;
				exp *= 2;
			}
			while(n % 5 == 0)
			{
				n/=5;
				exp *= 5;
			}
			BigInteger a = (new BigInteger("10")).modPow(new BigInteger(exp+""), new BigInteger(p1 + ""));
			if(a.intValue() != 1)
				sum += p;
			else
				System.out.println(p);
		}
		System.out.println(sum);
	}

}
