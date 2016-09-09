
public class Problem116RedGreenOrBlue {
	public static void main(String[] args) {
		int[] tiles = {2, 3, 4};
		long sum = 0;
		int size = 5;
		for(int i = 0; i < tiles.length; i++)
		{
			long[] numTilings = new long[size+1];
			numTilings[0] = 1;
			for(int j = 1; j <= size; j++)
			{
				numTilings[j] = numTilings[j-1];
				if(j >= tiles[i])
					numTilings[j] += numTilings[j - tiles[i]];
			}
			sum += numTilings[size] - 1;
		}
		System.out.println(sum);
	}

}
