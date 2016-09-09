import java.util.Arrays;


public class Problem53CombinatoricSelections {
	public static void main(String[] args) {
		long bound = 1000000;
		int n = 100;
		long count = 0;
		long[][] binomialCoefficients = new long[n+1][n+1];
		binomialCoefficients[0][0] = 1;
		for(int i = 1; i <= n; i++)
		{
			binomialCoefficients[i][0] = 1;
			for(int j = 1; j <= i; j++)
			{
				binomialCoefficients[i][j] = binomialCoefficients[i-1][j-1] + binomialCoefficients[i-1][j];
				if(binomialCoefficients[i][j] > bound || binomialCoefficients[i][j] < 0)
					count++;
			}
		}
		for(int i = 0; i <= n; i++)
			System.out.println(Arrays.toString(binomialCoefficients[i]));
		System.out.println(count);
	}

}
