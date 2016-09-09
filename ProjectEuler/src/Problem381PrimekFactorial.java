import java.util.ArrayList;
import java.util.Arrays;


public class Problem381PrimekFactorial {
	public static int[] extendedEuclideanAlgorithm(int a, int b)
	{
		if(a == 0)
		{
			int[] values = new int[3];
			values[0] = b;
			values[1] = 0;
			values[2] = 1;
			return values;
		}
		
		int[] values1 = extendedEuclideanAlgorithm(b%a, a);
		int temp1 = values1[1];
		int temp2 = values1[2];
		values1[1] = temp2 - (b/a)*temp1;
		values1[2] = temp1;
		return values1;
	}
	public static void main(String[] args) {
		int limit = (int) Math.pow(10, 8);
		ArrayList<Integer> primes = MethodSieveOfEratosthenes.primes(limit);
		long sum = 0;
		for(int i = 2; i < primes.size(); i++)
		{
			int p = primes.get(i);
			int coefficient = (-1*extendedEuclideanAlgorithm(24, p)[1] + p + p)%p;
			coefficient = (coefficient*9)%p;
			sum += coefficient;
		}
		System.out.println(sum);
	}

}
