import java.util.ArrayList;


public class Problem155CapacitorCircuits {
	static class Rational
	{
		long numerator;
		long denominator;
		public Rational(long n, long d)
		{
			long gcd = gcd(n, d);
			numerator = n/gcd;
			denominator = d/gcd;
		} 
		public Rational add(Rational r)
		{
			return new Rational(this.numerator * r.denominator + this.denominator * r.numerator, this.denominator * r.denominator);
		}
		public boolean equals(Object o)
		{
			Rational r = (Rational) o;
			return (this.numerator == r.numerator && this.denominator == r.denominator);
		}
		public String toString()
		{
			return numerator + "/" + denominator;
		}
	}
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
	/*public static long lcm(long a, long b)
	{
		return a*b/gcd(a,b);
	}
	public static long lcm1toN(int n)
	{
		long lcm = 2;
		for(int i = 3; i <= n; i++)
			lcm = lcm(lcm, i);
		return lcm;
	}*/
	public static void main(String[] args) {
		int max = 18;
		ArrayList<ArrayList<Rational>> values = new ArrayList<ArrayList<Rational>>();
		for(int i = 0; i < max; i++)
			values.add(new ArrayList<Rational>());
		//values.get(0).add(new Rational(1, 1));
		values.get(0).add(new Rational(1, 1));
		System.out.println(values.get(0).toString());
		for(int i = 1; i < max; i++)
		{
			ArrayList<Rational> v = values.get(i-1);
			for(Rational eq : v)
			{
				Rational r1 = eq.add(new Rational(1, 1));
				Rational r2 = new Rational(eq.numerator, (eq.numerator + eq.denominator));
				if(!v.contains(r1))
					values.get(i).add(r1);
				if(!v.contains(r2))
					values.get(i).add(r2);
			}
			if(i < 10)
				System.out.println(values.get(i).toString());
		}
	}

}
