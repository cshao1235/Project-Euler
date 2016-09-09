import java.math.BigInteger;


public class Problem148PascalsTriangle {
	public static long binomialCoefficientsNotDivisibleByP(int prime, long level)
	{
		int pow = (int) (Math.log(level) / Math.log(prime));
		long output = (long) Math.pow(prime * (prime + 1) / 2, pow);
		long factor = level/((long) Math.pow(prime, pow));
		System.out.println(factor);
		output *= factor * (factor + 1) / 2;
		int[] digits = new int[prime];
		for(int i = 0; i < prime; i++)
			digits[i] = i+1;
		for(long i = (long) (Math.pow(prime, pow) * factor); i < level; i++)
		{
			long notDivisible = 1;
			long temp = i;
			while(temp != 0)
			{
				notDivisible = notDivisible * (digits[(int) (temp%prime)]);
				temp = temp/prime;
			}
			output += notDivisible;
			if(i%10000 == 0)
				System.out.println(i);
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(binomialCoefficientsNotDivisibleByP(7, 1000000000));
	}

}
