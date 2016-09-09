import java.util.Arrays;


public class Problem217BalancedNumbers {
	private static final long MOD = (long) Math.pow(3, 15);
	private static long[] powersOf10 = new long[50];
	private static long[][] numPartitions = new long[9*50][50];
	public static long computeT(int n)
	{
		if(n == 1)
			return 45;
		long output = computeT(n-1);
		if(n%2 == 1)
		{
			int numDigits = n/2;
			for(int i = 0; i < n; i++)
			{
				if(i == n/2)
				{
					for(int digit = 1; digit < 10; digit++)
					{
						for(int j = 0; j <= 9*numDigits; j++)
						{
							long numToAdd = digit;
							numToAdd = (numToAdd * (numPartitions[j][numDigits] - numPartitions[j][numDigits - 1])) % MOD;
							numToAdd = (numToAdd * numPartitions[j][numDigits]) % MOD;
							numToAdd = (numToAdd * powersOf10[n - 1 - i]) % MOD;
							output = (output + numToAdd)%MOD;
						}
					}
				}
				else
				{
					for(int digit = 1; digit < 10; digit++)
					{
						for(int j = digit; j <= 9*numDigits; j++)
						{
							if(i == 0)
							{
								long numToAdd = digit * 10;
								numToAdd = (numToAdd * (numPartitions[j - digit][numDigits - 1])) % MOD;
								numToAdd = (numToAdd * numPartitions[j][numDigits]) % MOD;
								numToAdd = (numToAdd * powersOf10[n - 1 - i]) % MOD;
								output = (output + numToAdd)%MOD;
							}
							else if(i < n/2)
							{
								long numToAdd = digit * 10;
								numToAdd = (numToAdd * (numPartitions[j - digit][numDigits - 1] - numPartitions[j - digit][numDigits - 2])) % MOD;
								numToAdd = (numToAdd * numPartitions[j][numDigits]) % MOD;
								numToAdd = (numToAdd * powersOf10[n - 1 - i]) % MOD;
								output = (output + numToAdd)%MOD;
							}
							else
							{
								long numToAdd = digit * 10;
								numToAdd = (numToAdd * (numPartitions[j][numDigits] - numPartitions[j][numDigits - 1])) % MOD;
								numToAdd = (numToAdd * numPartitions[j - digit][numDigits - 1]) % MOD;
								numToAdd = (numToAdd * powersOf10[n - 1 - i]) % MOD;
								output = (output + numToAdd)%MOD;
							}
						}
					}
				}
			}
		}
		else
		{
			int numDigits = n/2;
			for(int i = 0; i < n; i++)
			{
				for(int digit = 1; digit < 10; digit++)
				{
					for(int j = digit; j <= 9*n/2; j++)
					{
						if(i == 0)
						{
							long numToAdd = digit;
							numToAdd = (numToAdd * (numPartitions[j - digit][numDigits - 1])) % MOD;
							numToAdd = (numToAdd * numPartitions[j][numDigits]) % MOD;
							numToAdd = (numToAdd * powersOf10[n - 1 - i]) % MOD;
							output = (output + numToAdd)%MOD;
						}
						else if(i < n/2)
						{
							long numToAdd = digit;
							numToAdd = (numToAdd * (numPartitions[j - digit][numDigits - 1] - numPartitions[j - digit][numDigits - 2])) % MOD;
							numToAdd = (numToAdd * numPartitions[j][numDigits]) % MOD;
							numToAdd = (numToAdd * powersOf10[n - 1 - i]) % MOD;
							output = (output + numToAdd)%MOD;
						}
						else
						{
							long numToAdd = digit;
							numToAdd = (numToAdd * (numPartitions[j][numDigits] - numPartitions[j][numDigits - 1])) % MOD;
							numToAdd = (numToAdd * numPartitions[j - digit][numDigits - 1]) % MOD;
							numToAdd = (numToAdd * powersOf10[n - 1 - i]) % MOD;
							output = (output + numToAdd)%MOD;
						}
					}
				}
			}
		}
		return output;
	}
	public static void main(String[] args) {
		powersOf10[0] = 1;
		for(int i = 1; i < powersOf10.length; i++)
			powersOf10[i] = (powersOf10[i-1]*10)%MOD;
		numPartitions[0][0] = 1;
		for(int j = 0; j < 49; j++)
		{
			for(int i = 0; i < 9*50; i++)
			{
				for(int k = 0; k < 10; k++)
				{
					if(i + k < 9*50)
						numPartitions[i+k][j+1] = (numPartitions[i+k][j+1] + numPartitions[i][j])%MOD;
				}
			}
		}
		/*for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 9*50; j++)
				System.out.print(numPartitions[j][i] + " ");
			System.out.println();
		}*/
		System.out.println(computeT(47));
		//System.out.println(334795890%MOD);
	}

}
