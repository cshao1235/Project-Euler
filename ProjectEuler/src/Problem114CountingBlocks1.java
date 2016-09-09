
public class Problem114CountingBlocks1
{
	public static void main(String[] args) {
		int size = 50;
		long[][] ways = new long[size+1][2]; //ways[i][0] ends in black, ways[i][1] ends in red
		ways[1][0] = 1;
		//ways[0][1] = 1;
		for(int i = 2; i <= size; i++)
		{
			ways[i][0] = ways[i-1][0] + ways[i-1][1];
			if(i >= 3)
				ways[i][1] = 1;
			for(int j = 1; j <= i - 3; j++)
				ways[i][1] += ways[j][0];
		}
		for(int i = 1; i <= size; i++)
			System.out.print(ways[i][0] + ", ");
		System.out.println();
		for(int i = 1; i <= size; i++)
			System.out.print(ways[i][1] + ", ");
		System.out.println();
		System.out.println(ways[size][0] + ways[size][1]);
	}

}
