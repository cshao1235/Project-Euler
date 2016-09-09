
public class Problem158ExploringStrings {
	public static void main(String[] args) {
		//number of permutations with exactly one ascent = 26Cn * (2^(n+1) - n - 2)
		int n = 26;
		int[][] binomialCoefficients = new int[n+1][n+1];
		binomialCoefficients[0][0] = 1;
		for(int i = 1; i <= n; i++)
		{
			binomialCoefficients[i][0] = 1;
			for(int j = 1; j <= i; j++)
			{
				binomialCoefficients[i][j] = binomialCoefficients[i-1][j-1] + binomialCoefficients[i-1][j];
			}
		}
		System.out.println(binomialCoefficients[26][3]);
		long max = 0;
		for(int i = 1; i <= n; i++)
		{
			long a = (long) binomialCoefficients[n][i] * ((long) (Math.pow(2, i)) - i - 1);
			System.out.println(a);
			if(a > max)
				max = a;
		}
		System.out.println(max);
	}

}
