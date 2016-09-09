import java.util.Arrays;


public class Problem31CoinSums {
	public static void main(String[] args) {
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int[][] waysToMake = new int[201][9];
		waysToMake[0][0] = 1;
		for(int i = 1; i <= 8; i++)
		{
			for(int j = 0; j <= 200; j++)
			{
				int coefficient = 0;
				while(j + coefficient*coins[i-1] <= 200)
				{
					waysToMake[j + coefficient*coins[i-1]][i] += waysToMake[j][i-1];
					coefficient++;
				}
			}
		}
		for(int i = 0; i <= 200; i++)
		{
			System.out.println(Arrays.toString(waysToMake[i]));
		}
		System.out.println(waysToMake[200][8]);
	}
}
