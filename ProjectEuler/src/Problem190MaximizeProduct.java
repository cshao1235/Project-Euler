
public class Problem190MaximizeProduct {
	public static void main(String[] args) {
		long sum = 0;
		int upper = 15;
		for(int i = 2; i <= upper; i++)
		{
			double product = 1;
			for(int j = 1; j <= i; j++)
				product *= Math.pow(2.0 * j / (i+1), j);
			sum += (long) product;
			if(i == 10)
				System.out.println(product);
		}
		System.out.println(sum);
	}

}
