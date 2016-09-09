import java.util.Arrays;


public class Problem227Chase {
	public static double[][] swap(int r1, int r2, double[][] matrix, int n)
	{
		double[][] m1 = matrix;
		for(int i = 0; i <= n; i++)
		{
			double temp = m1[r1][i];
			m1[r1][i] = m1[r2][i];
			m1[r2][i] = temp;
		}
		return m1;
	}
	public static double[] gaussianElimination(double[][] matrix, int n) //computes solutions to n x (n + 1) matrix
	{
		double[][] m1 = new double[n][n + 1];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j <= n; j++)
				m1[i][j] = matrix[i][j];
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = i + 1; j < n; j++)
			{
				for(int k = i + 1; k <= n; k++)
				{
					m1[j][k] = m1[j][k] - m1[i][k]*(m1[j][i]/m1[i][i]);
				}
				m1[j][i] = 0;
			}
			
		}
		
		for(int i = n - 1; i >= 0; i--)
		{
			m1[i][n] /= m1[i][i];
			m1[i][i] = 1.0;
			for(int j = i - 1; j >= 0; j--)
				m1[j][n] = m1[j][n] - m1[i][n]*m1[j][i];
		}
		double[] solutions = new double[n];
		for(int i = 0; i < n; i++)
			solutions[i] = m1[i][n];
		return solutions;
	}
	public static void main(String[] args) {
		/*double[][] matrix = {{2.0, 1.0, -1.0, 8.0},
		                     {-3.0, -1.0, 2.0, -11.0},
		                     {-2.0, 1.0, 2.0, -3.0}};
		System.out.println(Arrays.toString(gaussianElimination(matrix, 3)));*/
		int n = 100;
		int size = n/2;
		double[][] matrix = new double[size][size + 1];
		matrix[0][0] = -17.0;
		matrix[0][1] = 8.0;
		matrix[0][2] = 1.0;
		matrix[1][0] = 8.0;
		matrix[1][1] = -18.0;
		matrix[1][2] = 8.0;
		matrix[1][3] = 1.0;
		matrix[size-1][size-1] = -18.0;
		matrix[size-1][size-2] = 16.0;
		matrix[size-1][size-3] = 2.0;
		matrix[size-2][size-1] = 8.0;
		matrix[size-2][size-2] = -17.0;
		matrix[size-2][size-3] = 8.0;
		matrix[size-2][size-4] = 1.0;
		matrix[0][size] = -36.0;
		matrix[1][size] = -36.0;
		matrix[size-1][size] = -36.0;
		matrix[size-2][size] = -36.0;
		for(int i = 2; i < size - 2; i++)
		{
			matrix[i][i - 2] += 1.0;
			matrix[i][i - 1] += 8.0;
			matrix[i][i] -= 18.0;
			matrix[i][i + 1] += 8.0;
			matrix[i][i + 2] += 1.0;
			matrix[i][size] = -36.0;
		}
		for(int i = 0; i < size; i++)
			System.out.println(Arrays.toString(matrix[i]));
		System.out.println(Arrays.toString(gaussianElimination(matrix, size)));
	}

}
