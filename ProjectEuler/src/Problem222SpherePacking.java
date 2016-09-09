import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Problem222SpherePacking {
	private static final float MAX = 10000000;
	static class Path
	{
		public HashSet<Integer> subset;
		public int destination;
	}
	/*public static double travelingSalesman(double[][] graph, int vertices)
	{
		HashMap<Path, Double> minCostPath = new HashMap<Path, Double>();
		
	}*/
	public static float travellingSalesman(float[][] graph, int v) //source 0
	{
		float[][] dp = new float[v][(int) Math.pow(2, v)];
		//for(int i = 0; i < v; i++)
		//	dp[i][0] = MAX;
		for(int i = 0; i < v; i++)
			dp[i][1 << i] = graph[i + 1][0];
		//for(int i = 0; i < v; i++)
		//	System.out.println(Arrays.toString(dp[i]));
		for(int i = 2; i < (int) Math.pow(2, v); i++)
		{
			int count = 0;
			for(int j = 0; j < v; j++)
			{
				if(((i >>> j) & 1) == 1)
					count++;
			}
			if(count == 1)
				continue;
			for(int j = 0; j < v; j++)
			{
				if(((i >>> j) & 1) == 0)
					continue;
				float min = MAX;
				for(int k = 0; k < v; k++)
				{
					if(((i >>> k) & 1) == 0 || k == j)
						continue;
					float newCost = dp[k][i - (1 << j)] + graph[k + 1][j + 1];
					if(min > newCost)
						min = newCost;
				}
				dp[j][i] = min;
			}
		}
		//for(int i = 0; i < v; i++)
		//	System.out.println(Arrays.toString(dp[i]));
		float output = MAX;
		for(int i = 0; i < v; i++)
		{
			if(dp[i][(int) Math.pow(2, v) - 1] + graph[0][i + 1] < output)
				output = dp[i][(int) Math.pow(2, v) - 1] + graph[0][i + 1];
		}
		return output;
	}
	public static void main(String[] args) {
		int size = 22;
		float min = 30000;
		float radius = 50000;
		float[] ballRadii = new float[size - 1];
		for(int i = 0; i < ballRadii.length; i++)
			ballRadii[i] = min + i*1000;
		float[][] graph = new float[size][size];
		for(int i = 1; i < size; i++)
		{
			graph[0][i] = ballRadii[i - 1];
			graph[i][0] = ballRadii[i - 1];
		}
		for(int i = 1; i < size; i++)
		{
			for(int j = 1; j < size; j++)
			{
				graph[i][j] = (float) Math.sqrt((ballRadii[i - 1] + ballRadii[j - 1])*(ballRadii[i - 1] + ballRadii[j - 1]) - (radius*2 - ballRadii[i - 1] - ballRadii[j - 1])*(radius*2 - ballRadii[i - 1] - ballRadii[j - 1]));
				graph[j][i] = graph[i][j];
			}
		}
		System.out.println(travellingSalesman(graph, size - 1));

	}

}
