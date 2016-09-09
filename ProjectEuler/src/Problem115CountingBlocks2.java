
public class Problem115CountingBlocks2 {
	private static final int SIZE = 200;
	private static long[][] ways = new long[SIZE+1][2]; //ways[i][0] ends in black, ways[i][1] ends in red
	public static void countingBlocks(int m)
	{
		//long[][] ways = new long[size+1][2];
		ways[1][0] = 1;
		//ways[0][1] = 1;
		for(int i = 2; i <= SIZE; i++)
		{
			ways[i][0] = ways[i-1][0] + ways[i-1][1];
			if(i >= m)
				ways[i][1] = 1;
			for(int j = 1; j <= i - m; j++)
				ways[i][1] += ways[j][0];
		}
		//for(int i = 1; i <= size; i++)
		//	System.out.print(ways[i][0] + ", ");
		//System.out.println();
		//for(int i = 1; i <= size; i++)
		//	System.out.print(ways[i][1] + ", ");
		//System.out.println();
		//return ways[size][0] + ways[size][1];
	}
	public static void main(String[] args) {
		countingBlocks(50);
		for(int i = 60; i < 200; i++)
			System.out.println(i + " " + (ways[i][0] + ways[i][1]));
	}

}
