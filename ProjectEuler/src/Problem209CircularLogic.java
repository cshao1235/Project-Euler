import java.util.Arrays;


public class Problem209CircularLogic {
	public static long[] fibonacci = new long[500];
	public static long validTables(int cycleLength) //number of ways to assign 0 or 1 to n distinct people in a circle such that no two neighbors both have 1
	{
		//if(cycleLength == 1)
		//	return 2;
		return fibonacci[cycleLength + 1] + fibonacci[cycleLength - 1];
	}
	public static long numTruthTables(int[] conditions) //conditions is such that (i AND conditions[i]) = 0
	{
		long numTruthTables = 1;
		boolean[] visited = new boolean[conditions.length];
		for(int i = 0; i < conditions.length; i++)
		{
			if(visited[i])
				continue;
			//int start = i;
			int current = conditions[i];
			int cycleLength = 1;
			visited[i] = true;
			while(!visited[current])
			{
				visited[current] = true;
				cycleLength++;
				current = conditions[current];
			}
			numTruthTables *= validTables(cycleLength);
		}
		return numTruthTables;
	}
	public static void main(String[] args) {
		int n = 6;
		int[] condition = new int[(int) Math.pow(2, n)];
		for(int i = 0; i < condition.length; i++)
		{
			int output = (2*i)%condition.length;
			int a = (i >>> n - 1) & 1;
			int b = (i >>> n - 2) & 1;
			int c = (i >>> n - 3) & 1;
			output += a ^ (b & c);
			condition[i] = output;
		}
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for(int i = 2; i < 500; i++)
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		System.out.println(Arrays.toString(condition));
		System.out.println(numTruthTables(condition));
	}

}
