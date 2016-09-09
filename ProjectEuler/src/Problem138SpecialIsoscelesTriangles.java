import java.util.ArrayList;


public class Problem138SpecialIsoscelesTriangles {
	static class Pair
	{
		long x;
		long y;
		public Pair(long x, long y)
		{
			this.x = x;
			this.y = y;
		}
		public long magnitude()
		{
			return (x+2*y)*(x+2*y) + y*y;
		}
		public String toString()
		{
			return x + " " + y;
		}
	}
	private static final int NUM_SOLUTIONS = 12;
	//finds solutions to negative Pell equation x^2 - ny^2 = -1 and x^2 - ny^2 = 1
	//given minimal solution (minX, minY) and that x^2 - ny^2 = -1 is solvable
	public static ArrayList<Pair> pellSolutionsPositiveAndNegative(int n, int minX, int minY)
	{
		ArrayList<Pair> solutions = new ArrayList<Pair>();
		solutions.add(new Pair(minX, minY));
		while(solutions.size() < NUM_SOLUTIONS)
		{
			Pair p = solutions.get(solutions.size() - 1);
			long x = p.x;
			long y = p.y;
			solutions.add(new Pair(x * minX + n * y * minY, y * minX + x * minY));
		}
		return solutions;
	}
	public static void main(String[] args) {
		ArrayList<Pair> solutions = pellSolutionsPositiveAndNegative(5, 2, 1);
		System.out.println(solutions.toString());
		long sum = 0;
		for(int i = 0; i < solutions.size(); i++)
		{
			sum += solutions.get(i).magnitude();
		}
		System.out.println(sum);
	}

}