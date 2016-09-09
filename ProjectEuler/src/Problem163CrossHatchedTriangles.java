
public class Problem163CrossHatchedTriangles {
	public static long nC3(long n)
	{
		return n*(n-1)*(n-2)/6;
	}
	public static long numTriangles(int n) //number of triangles in grid of size n
	{
		long numPoints = 7*n*n - 6*(n-1) - 5*(n-1)*(n-2)/2 - 3*n*(n-1)/2;
		long numTriangles = nC3(numPoints);
		for(int i = 3; i <= 2*n + 1; i+=2)
			numTriangles -= 6*nC3(i);
		numTriangles += nC3(2*n+1);
		//for(int i = 3; i <= 2*n + 1; i+=2)
		//	numTriangles -= 3*nC3(i);
		return numTriangles;
	}
	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++)
			System.out.println(numTriangles(i));
	}

}
