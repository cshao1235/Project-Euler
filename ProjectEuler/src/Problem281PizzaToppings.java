import java.util.Arrays;

public class Problem281PizzaToppings {
	private static final long MAX = (long) Math.pow(10, 15);
	public static long multinomialCoefficient(int m, int n) //computes (mn)!/((n!)^m)
	{
		long output = 1;
		for(int i = 1; i < m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				output = (n*i + j)*output/j;
			}
		}
		return output;
	}
	public static void main(String[] args) {
		long[][] g = new long[50][50];
		for(int i = 1; i < 50; i++)
			g[1][i] = 1;
		for(int i = 2; i < 50; i++)
		{
			g[i][1] = (i - 1)*g[i-1][1];
			if(g[i][1] > MAX)
				break;
			for(int j = 2; j < 50; j++)
			{
				long value = multinomialCoefficient(i, j);
				if(value < 0 || value > MAX*100)
					break;
				for(int d = 1; d <= j/2; d++)
				{
					if(j % d != 0)
						continue;
					value -= i*d*g[i][d];
				}
				value /= i*j;
				g[i][j] = value;
				if(g[i][j] > MAX)
					break;
			}
		}
		long sum = 0;
		for(int i = 2; i < 50; i++)
		{
			for(int j = 1; j < 50; j++)
			{
				if(g[i][j] == 0)
					break;
				long f = g[i][j];
				for(int d = 1; d <= j/2; d++)
				{
					if(j % d == 0)
						f += g[i][d];
				}
				System.out.println("B");
				if(f < MAX)
					sum += f;
			}
			System.out.println("C");
		}
		System.out.println(sum);
		//for(int i = 1; i < 50; i++)
		//	System.out.println(Arrays.toString(g[i]));
	}

}
