import java.math.BigInteger;


public class MethodEuclideanAlgorithm {
	public static long gcd(long a, long b)
	{
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		if(a == b)
			return a;
		else if(a > b)
			return gcd(a%b, b);
		else
			return gcd(a, b%a);
	}
	public static long[] extendedEuclideanAlgorithm(long a, long b)
	{
		if(a == 0)
		{
			long[] values = new long[3];
			values[0] = b;
			values[1] = 0;
			values[2] = 1;
			return values;
		}
		
		long[] values1 = extendedEuclideanAlgorithm(b%a, a);
		long temp1 = values1[1];
		long temp2 = values1[2];
		values1[1] = temp2 - (b/a)*temp1;
		values1[2] = temp1;
		return values1;
	}
	public static BigInteger[] extendedEuclideanAlgorithm(BigInteger a, BigInteger b)
	{
		if(a.equals(BigInteger.ZERO))
		{
			BigInteger[] values = new BigInteger[3];
			values[0] = b;
			values[1] = BigInteger.ZERO;
			values[2] = BigInteger.ONE;
			return values;
		}
		
		BigInteger[] values1 = extendedEuclideanAlgorithm(b.mod(a), a);
		BigInteger temp1 = values1[1];
		BigInteger temp2 = values1[2];
		values1[1] = temp2.subtract((b.divide(a)).multiply(temp1));
		values1[2] = temp1;
		return values1;
	}
	public static long chineseRemainderTheorem(long a1, long n1, long a2, long n2) //solution to x = a1 mod n1, x = a2 mod n2 where gcd(n1, n2) = 1
	{
		if(n1 == 1)
			return a2;
		if(n2 == 1)
			return a1;
		long[] bezout = extendedEuclideanAlgorithm(n1, n2);
		return (a2*n1*bezout[1] + a1*n2*bezout[2] + n1*n2)%(n1*n2);
	}
	public static BigInteger chineseRemainderTheorem(BigInteger a1, BigInteger n1, BigInteger a2, BigInteger n2)
	{
		if(n1.equals(BigInteger.ONE))
			return a2;
		if(n2.equals(BigInteger.ONE))
			return a1;
		BigInteger[] bezout = extendedEuclideanAlgorithm(n1, n2);
		BigInteger term1 = a2.multiply(n1).multiply(bezout[1]);
		BigInteger term2 = a1.multiply(n2).multiply(bezout[2]);
		BigInteger mod = n1.multiply(n2);
		return (term1.add(term2)).mod(mod);
	}
	public static void main(String[] args)
	{
		System.out.println(chineseRemainderTheorem(3, 5, 2, 7));
		System.out.println(chineseRemainderTheorem(new BigInteger("3"), new BigInteger("5"), new BigInteger("2"), new BigInteger("7")));
	}
}
