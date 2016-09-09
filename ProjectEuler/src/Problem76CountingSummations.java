import java.util.Arrays;


public class Problem76CountingSummations {
	public static void main(String[] args) {
		int target = 100;
		long[][] waysToMake = new long[target][target+1];
		waysToMake[0][0] = 1;
		for(int i = 1; i < target; i++)
		{
			waysToMake[i][0] = 1;
			for(int j = 1; j <= target; j++)
			{
				for(int k = 0; j - k >= 0; k += i)
				{
					waysToMake[i][j] += waysToMake[i-1][j - k];
				}
			}
		}
		for(int i = 0; i < target; i++)
		{
			System.out.println(Arrays.toString(waysToMake[i]));
		}
		System.out.println(waysToMake[target-1][target]);
	}

}
