
public class MethodMatrixOperations {
	public static long[][] matrixMultiplication(int a, int b, int c, long[][] matrix1, long[][] matrix2) //multiplies matrix1, a x b, and matrix2, b x c
	{
		long[][] output = new long[a][c];
		for(int i = 0; i < a; i++)
		{
			for(int j = 0; j < c; j++)
			{
				for(int k = 0; k < b; k++)
				{
					output[i][j] += matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		return output;
	}
	public static long[][] matrixMultiplication(int a, int b, int c, long[][] matrix1, long[][] matrix2, long mod) //multiplies matrix1, a x b, and matrix2, b x c with entries mod "mod"
	{
		long[][] output = new long[a][c];
		for(int i = 0; i < a; i++)
		{
			for(int j = 0; j < c; j++)
			{
				for(int k = 0; k < b; k++)
				{
					output[i][j] = (output[i][j] + matrix1[i][k]*matrix2[k][j])%mod;
				}
			}
		}
		return output;
	}
	public static long[][] matrixExponentiation(long exp, int size, long[][] matrix)
	{
		String s = Long.toBinaryString(exp);
		return matrixExponentiation(s, size, matrix);
	}
	public static long[][] matrixExponentiation(String exp, int size, long[][] matrix) //exp is exponent as a binary String
	{
		long[][] result = matrix;
		for(int i = 1; i < exp.length(); i++)
		{
			result = matrixMultiplication(size, size, size, result, result);
			if(exp.charAt(i) == '1')
				result = matrixMultiplication(size, size, size, result, matrix);
		}
		return result;
	}
	public static long[][] matrixExponentiation(long exp, int size, long[][] matrix, long mod)
	{
		String s = Long.toBinaryString(exp);
		return matrixExponentiation(s, size, matrix, mod);
	}
	public static long[][] matrixExponentiation(String exp, int size, long[][] matrix, long mod)
	{
		long[][] result = matrix;
		for(int i = 1; i < exp.length(); i++)
		{
			result = matrixMultiplication(size, size, size, result, result, mod);
			if(exp.charAt(i) == '1')
				result = matrixMultiplication(size, size, size, result, matrix, mod);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
