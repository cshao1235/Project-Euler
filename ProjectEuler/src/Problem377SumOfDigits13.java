import java.math.BigInteger;
import java.util.Arrays;


public class Problem377SumOfDigits13 {
	private static final long MOD = 100000000L;
	public static void main(String[] args) {
		int n = (int) Math.pow(13, 2);
		long[] b = new long[n];
		b[0] = 1;
		for(int i = 1; i < 9; i++)
			b[i] = 2*b[i - 1];
		for(int i = 9; i < n; i++)
		{
			for(int j = 1; j <= 9; j++)
				b[i] = (b[i - j] + b[i])%MOD;
		}
		System.out.println(Arrays.toString(b));
		long[][] recursion = new long[9][9];
		for(int i = 0; i < 9; i++)
			recursion[0][i] = 1;
		for(int i = 1; i < 9; i++)
			recursion[i][i - 1] = 1;
		long[][] vector = new long[9][1];
		vector[8][0] = 1;
		vector[7][0] = 1;
		for(int i = 7; i > 0; i--)
			vector[i - 1][0] = 2*vector[i][0];
		long sum = 0;
		for(int i = 1; i <= 17; i++)
		{
			BigInteger a = new BigInteger("13");
			//a = a.pow(i).subtract(BigInteger.ONE);
			a = a.pow(i);
			String s = a.toString(2);
			System.out.println(s);
			long[][] r = MethodMatrixOperations.matrixExponentiation(s, 9, recursion, MOD);
			long[][] result = MethodMatrixOperations.matrixMultiplication(9, 9, 1, r, vector, MOD);
			System.out.println(result[8][0]);
			sum = (sum + result[8][0])%MOD;
		}
		System.out.println(sum);
	}

}
