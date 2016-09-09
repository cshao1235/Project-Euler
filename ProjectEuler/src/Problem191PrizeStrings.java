import java.util.Arrays;


public class Problem191PrizeStrings {
	public static void main(String[] args) {
		int numDays = 30;
		int maxLates = 1;
		int maxAbsences = 3;
		long[][][] dp = new long[numDays][maxAbsences][maxLates + 1];
		dp[0][0][0] = 1;
		dp[0][1][0] = 1;
		dp[0][0][1] = 1;
		for(int i = 1; i < numDays; i++)
		{
			dp[i][0][0] = dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0];
			dp[i][1][0] = dp[i-1][0][0];
			dp[i][2][0] = dp[i-1][1][0];
			dp[i][0][1] = dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][2][0] + dp[i-1][0][1] + dp[i-1][1][1] + dp[i-1][2][1];
			dp[i][1][1] = dp[i-1][0][1];
			dp[i][2][1] = dp[i-1][1][1];
		}
		long[] sum = new long[numDays];
		for(int i = 0; i < numDays; i++)
		{
			sum[i] = dp[i][0][0] + dp[i][0][1] + dp[i][1][0] + dp[i][1][1] + dp[i][2][0] + dp[i][2][1];
		}
		System.out.println(Arrays.toString(sum));
	}

}
