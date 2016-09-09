import java.util.Arrays;


public class Problem78CoinPartitions {
	public static void main(String[] args)
	{
		int mod = 1000000;
		int target = 1000000;
		int[] partitions = new int[target+1];
		partitions[0] = 1;
		int[] pentagonalNumbers = new int[2*target+2];
		for(int i = 0; i <= target; i++)
		{
			pentagonalNumbers[2*i] = i*(3*i - 1)/2;
			pentagonalNumbers[2*i+1] = i*(3*i + 1)/2;
		}
		for(int i = 1; i <= 10; i++)
			System.out.println(pentagonalNumbers[i]);
		for(int i = 1; i <= target; i++)
		{
			int count = 2;
			while(i - pentagonalNumbers[count] >= 0)
			{
				if((count/2)%2 == 1)
					partitions[i] = (partitions[i] + partitions[i - pentagonalNumbers[count]])%mod;
				else
					partitions[i] = (partitions[i] + mod - partitions[i - pentagonalNumbers[count]])%mod;
				count++;
			}
			if(partitions[i] == 0)
			{
				System.out.println(i);
				break;
			}
		}
		for(int i = 1; i <= 1000; i++)
			System.out.println(partitions[i]);
		/*long[][] waysToMake = new long[target][target+1];
		waysToMake[0][0] = 1;
		for(int i = 1; i < target; i++)
		{
			waysToMake[i][0] = 1;
			for(int j = 1; j <= target; j++)
			{
				for(int k = 0; j - k >= 0; k += i)
				{
					waysToMake[i][j] = (waysToMake[i][j] + waysToMake[i-1][j - k])%mod;
				}
			}
		}
		//for(int i = 0; i < target; i++)
		//{
		//	System.out.println(Arrays.toString(waysToMake[i]));
		//}
		for(int i = 1; i < target; i++)
		{
			if(waysToMake[i-1][i] == 0)
				System.out.println(i);
		}
		//System.out.println(waysToMake[target-1][target]);*/
	}
}
