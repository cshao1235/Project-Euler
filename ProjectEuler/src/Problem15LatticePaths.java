public class Problem15LatticePaths
{
	public static long binomialCoefficient(int n, int r)
	{
		long[][] triangle = new long[n+1][n+1];
		triangle[0][0] = 1;
		for(int i = 1; i <= n; i++)
		{
			triangle[i][0] = 1;
			for(int j = 1; j <= i; j++)
			{
				triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];
			}
		}
		return triangle[n][r];
	}
	public static void main(String[] args) {
		System.out.println(binomialCoefficient(40, 20));

	}

}