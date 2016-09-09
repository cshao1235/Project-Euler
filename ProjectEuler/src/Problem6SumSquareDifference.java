public class Problem6SumSquareDifference {

	public static int sumSquareDifference(int n)
	{
		int sumToN = n*(n+1)/2;
		return sumToN*sumToN - n*(n+1)*(2*n+1)/6;
	}
	public static void main(String[] args) {
		System.out.println(sumSquareDifference(100));

	}

}