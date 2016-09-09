import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Problem18MaxPathSum1
{
	public static void main(String[] args)
	{
		try
		{
			int size = 15;
			BufferedReader f = new BufferedReader(new FileReader("Problem18.txt"));
			int[][] triangle = new int[size][size];
			for(int i = 1; i <= size; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				for(int j = 1; j <= i; j++)
					triangle[i-1][j-1] = Integer.parseInt(st.nextToken());
			}
			int[][] maxPath = new int[size][size];
			maxPath[0][0] = triangle[0][0];
			for(int i = 1; i < size; i++)
			{
				maxPath[i][0] = maxPath[i-1][0] + triangle[i][0];
				for(int j = 1; j <= i; j++)
				{
					if(maxPath[i-1][j-1] > maxPath[i-1][j])
						maxPath[i][j] = maxPath[i-1][j-1] + triangle[i][j];
					else
						maxPath[i][j] = maxPath[i-1][j] + triangle[i][j];
				}
			}
			int max = 0;
			for(int i = 0; i < size; i++)
			{
				if(maxPath[size-1][i] > max)
					max = maxPath[size-1][i];
			}
			System.out.println(max);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
