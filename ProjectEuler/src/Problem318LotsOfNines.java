
public class Problem318LotsOfNines {
	public static long sumN(int bound, int numNines) //returns sum of N(p, q), min n so that fractional part of (sqrt(p) + sqrt(q))^2n has at least numNines at the beginning, over p < q, p + q <= bound
	{
		//condition equivalent to fractional part of (sqrt(q) - sqrt(p))^2n < 10^(- bound)
		long sum = 0;
		for(int p = 1; p <= bound/2; p++)
		{
			for(int q = p + 1; p + q <= bound; q++)
			{
				if(Math.sqrt(q) - Math.sqrt(p) >= 1.0)
					break;
				sum += (int) ((double) bound)/(2.0 * -1 * Math.log10(Math.sqrt(q) - Math.sqrt(p))) + 1;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(sumN(2011, 2011));

	}

}
