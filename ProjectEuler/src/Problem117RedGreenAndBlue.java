
public class Problem117RedGreenAndBlue {
	public static void main(String[] args) {
		int[] tiles = {1, 2, 3, 4};
		int size = 5;
		long[] numTilings = new long[size + 1];
		numTilings[0] = 1;
		for(int i = 1; i <= size; i++)
		{
			for(int j = 0; j < tiles.length; j++)
			{
				if(tiles[j] <= i)
					numTilings[i] += numTilings[i - tiles[j]];
			}
		}
		System.out.println(numTilings[size]);
	}

}
