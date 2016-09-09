import java.util.Arrays;


public class Problem269PolynomialsWithOneIntegerRoot {
	public static void main(String[] args) {
		int exp = 5;
		long output = (long) Math.pow(10, exp - 1);
		long[][] dp1 = new long[exp + 1][9*exp + 1];
		for(int i = 1; i < 10; i++)
			dp1[1][i] = 1;
		for(int i = 1; i < exp; i++)
		{
			for(int j = 0; j <= 9*i; j++)
			{
				for(int k = 0; k < 10; k++)
					dp1[i + 1][j + k] += dp1[i][j];
			}
		}
		long[][] dp2 = new long[exp + 1][9*exp + 1];
		for(int i = 0; i < 10; i++)
			dp2[1][i] = 1;
		for(int i = 1; i < exp; i++)
		{
			for(int j = 0; j <= 9*i; j++)
			{
				for(int k = 0; k < 10; k++)
					dp2[i + 1][j + k] += dp2[i][j];
			}
		}
		//for(int i = 1; i <= exp; i++)
		//	System.out.println(Arrays.toString(dp1[i]));
		int first = (exp + 1)/2;
		int second = exp/2;
		for(int i = 1; i <= 9*exp; i++)
			output += dp1[first][i]*dp2[second][i];
		System.out.println(output);
	}

}
