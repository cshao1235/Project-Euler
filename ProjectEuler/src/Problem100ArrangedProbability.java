import java.util.ArrayList;

public class Problem100ArrangedProbability {
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
	//finds solutions to negative Pell equation x^2 - ny^2 = -1 and x^2 - ny^2 = 1
	//given minimal solution (minX, minY) and that x^2 - ny^2 = -1 is solvable
	public static ArrayList<Pair> pellSolutionsPositiveAndNegative(int n, int minX, int minY, int numSolutions)
	{
		ArrayList<Pair> solutions = new ArrayList<Pair>();
		solutions.add(new Pair(minX, minY));
		while(solutions.size() < numSolutions)
		{
			Pair p = solutions.get(solutions.size() - 1);
			long x = p.x;
			long y = p.y;
			solutions.add(new Pair(x * minX + n * y * minY, y * minX + x * minY));
		}
		return solutions;
	}
	public static void main(String[] args) {
		long bound = 1000000000000L;
		ArrayList<Pair> solutions = pellSolutionsPositiveAndNegative(2, 1, 1, 50);
		for(int i = 0; i < solutions.size(); i++)
		{
			Pair p = solutions.get(i);
			if(p.x % 2 == 1 && p.y % 2 == 1)
			{
				if((p.x + 1)/2 > bound)
				{
					System.out.println((p.y + 1)/2);
					break;
				}
			}
		}
	}

}
