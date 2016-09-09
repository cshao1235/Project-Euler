import java.math.BigInteger;


public class Problem329PrimeFrog {
	private static Rational pOnPrime = new Rational(2, 3);
	private static Rational nOnPrime = new Rational(1, 3);
	private static Rational pOnNotPrime = new Rational(1, 3);
	private static Rational nOnNotPrime = new Rational(2, 3);
	private static int min = 1;
	private static int max = 500;
	private static boolean[] isPrime = new boolean[max + 1];
	static class Rational{
		private BigInteger numerator;
		private BigInteger denominator;
		public Rational(long n, long d)
		{
			long gcd = gcd(n, d);
			n /= gcd;
			d /= gcd;
			numerator = new BigInteger(n+"");
			denominator = new BigInteger(d + "");
		}
		public Rational(BigInteger n, BigInteger d)
		{
			numerator = n;
			denominator = d;
		}
		public Rational add(Rational r1)
		{
			return new Rational(numerator.multiply(r1.denominator).add(denominator.multiply(r1.numerator)), denominator.multiply(r1.denominator)); 
		}
		public Rational multiply(Rational r1)
		{
			return new Rational(numerator.multiply(r1.numerator), denominator.multiply(r1.denominator));
		}
		public String toString()
		{
			return numerator.toString() + "/" + denominator.toString();
		}
		public double getValue()
		{
			return numerator.doubleValue()/denominator.doubleValue();
		}
	}
	public static long gcd(long a, long b)
	{
		if(a == 0)
			return b;
		else if(b == 0)
			return a;
		if(a > b)
			return gcd(a%b, b);
		else
			return gcd(a, b%a);
	}
	public static BigInteger gcd(BigInteger a, BigInteger b)
	{
		if(a.equals(BigInteger.ZERO))
			return b;
		else if(b.equals(BigInteger.ZERO))
			return a;
		if(a.compareTo(b) > 0)
			return gcd(a.mod(b), b);
		else
			return gcd(a, b.mod(a));
	}
	public static boolean isPrime(int i)
	{
		if(i == 1)
			return false;
		if(i == 2 || i == 3)
			return true;
		if(i%2 == 0 || i%3 == 0)
			return false;
		for(int j = 6; j + 1 <= Math.sqrt(i); j+=6)
		{
			if(i%(j - 1) == 0)
				return false;
			if(i%(j + 1) == 0)
				return false;
		}
		return true;
	}
	public static Rational dfs(int current, int numSteps, String croaks)
	{
		if(numSteps == 0)
		{
			Rational output = new Rational(0, 1);
			Rational prob = new Rational(1, max - min + 1);
			for(int i = min; i <= max; i++)
				output = output.add(prob.multiply(dfs(i, 1, croaks)));
			return output;
		}
		else if(numSteps == croaks.length() + 1)
			return new Rational(1, 1);
		else
		{
			boolean croakedP = (croaks.charAt(numSteps - 1) == 'P');
			if(current == min)
			{
				if(isPrime[current])
				{
					if(croakedP)
						return pOnPrime.multiply(dfs(current + 1, numSteps + 1, croaks));
					else
						return nOnPrime.multiply(dfs(current + 1, numSteps + 1, croaks));
				}
				else
				{
					if(croakedP)
						return pOnNotPrime.multiply(dfs(current + 1, numSteps + 1, croaks));
					else
						return nOnNotPrime.multiply(dfs(current + 1, numSteps + 1, croaks));
				}
			}
			else if(current == max)
			{
				if(isPrime[current])
				{
					if(croakedP)
						return pOnPrime.multiply(dfs(current - 1, numSteps + 1, croaks));
					else
						return nOnPrime.multiply(dfs(current - 1, numSteps + 1, croaks));
				}
				else
				{
					if(croakedP)
						return pOnNotPrime.multiply(dfs(current - 1, numSteps + 1, croaks));
					else
						return nOnNotPrime.multiply(dfs(current - 1, numSteps + 1, croaks));
				}
			}
			else
			{
				Rational half = new Rational(1, 2);
				if(isPrime[current])
				{
					if(croakedP)
						return half.multiply(pOnPrime).multiply(dfs(current + 1, numSteps + 1, croaks).add(dfs(current - 1, numSteps + 1, croaks)));
					else
						return half.multiply(nOnPrime).multiply(dfs(current + 1, numSteps + 1, croaks).add(dfs(current - 1, numSteps + 1, croaks)));
				}
				else
				{
					if(croakedP)
						return half.multiply(pOnNotPrime).multiply(dfs(current + 1, numSteps + 1, croaks).add(dfs(current - 1, numSteps + 1, croaks)));
					else
						return half.multiply(nOnNotPrime).multiply(dfs(current + 1, numSteps + 1, croaks).add(dfs(current - 1, numSteps + 1, croaks)));
				}
			}
		}
	}
	public static void main(String[] args) {
		for(int i = 1; i <= max; i++)
		{
			if(isPrime(i))
				isPrime[i] = true;
		}
		Rational r = dfs(0, 0, "PPPPNNPPPNPPNPN");
		System.out.println(r.toString() + " " + r.getValue());
	}

}
