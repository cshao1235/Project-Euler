
public class Problem174NumberOfDistinctLaminaeWithTiles {
	public static void main(String[] args) {
		int sum = 0;
		int max = 1000000;
		int maxPossibleArrangements = 10;
		for(int i = 2; i <= max/4; i++)
		{
			int numDivisors = 0;
			for(int j = 1; j < Math.sqrt(i); j++)
			{
				if(i % j == 0)
					numDivisors++;
			}
			if(numDivisors <= maxPossibleArrangements)
				sum++;
		}
		System.out.println(sum);
	}

}
