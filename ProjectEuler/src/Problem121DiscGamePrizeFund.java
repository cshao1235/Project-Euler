import java.util.Arrays;


public class Problem121DiscGamePrizeFund {
	public static void main(String[] args) {
		int n = 15;
		long[] coefficients = new long[n+1];
		long[] powers = new long[n];
		for(int i = 1; i <= n/2; i++)
		{
			for(int j = 1; j <= n; j++)
				powers[i] += (long) Math.pow(-1*j, i);
		}
		coefficients[n] = 1;
		for(int i = n-1; i > n/2; i--)
		{
			long sum = 0;
			for(int j = 0; j < n-i; j++)
			{
				sum += coefficients[n-j] * powers[n-i-j];
			}
			coefficients[i] = -1*sum/(n-i);
		}
		long factorial = 1;
		for(int i = 2; i <= n+1; i++)
			factorial *= i;
		long sumCoefficients = 0;
		for(int i = n; i > n/2; i--)
			sumCoefficients += coefficients[i];
		System.out.println(factorial/sumCoefficients);
		System.out.println(Arrays.toString(powers));
		System.out.println(Arrays.toString(coefficients));
	}

}
