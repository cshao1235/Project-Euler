
public class Problem173FormingSquareLaminae {
	public static void main(String[] args) {
		int numLaminae = 0;
		int max = 1000000;
		for(int i = 2; i <= max/4; i++)
		{
			for(int j = 1; j < Math.sqrt(i); j++)
			{
				if(i % j == 0)
					numLaminae++;
			}
		}
		System.out.println(numLaminae);
	}

}
