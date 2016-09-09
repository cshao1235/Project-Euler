import java.util.ArrayList;


public class Problem94AlmostEquilateral {
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
			return x*x + y*y;
		}
		public String toString()
		{
			return x + " " + y;
		}
	}
	private static final long BOUND = 1000000000;
	public static ArrayList<Pair> pellSolutions(long n, long minX, long minY) //generates solutions to Pell equation x^2 - ny^2 = 1;
	{
		ArrayList<Pair> answers = new ArrayList<Pair>();
		answers.add(new Pair(minX, minY));
		while(answers.get(answers.size()-1).magnitude() <= (BOUND+1)/3)
		{
			Pair p = answers.get(answers.size()-1);
			long x = p.x * minX + n * p.y * minY;
			long y = p.y * minX + p.x * minY;
			answers.add(new Pair(x, y));
		}
		return answers;
	}
	public static void main(String[] args) {
		ArrayList<Pair> solutions = pellSolutions(3, 2, 1);
		System.out.println(solutions.toString());
		long sum = 0;
		for(int i = 0; i < solutions.size(); i++)
		{
			Pair p = solutions.get(i);
			long n = p.y;
			long m = p.x + 2*n;
			long s = m*m + n*n;
			long perimeter = 3*s - 1;
			if(perimeter > BOUND)
				break;
			sum += perimeter;
			System.out.println(m + " " + n + " " + perimeter);
		}
		System.out.println();
		for(int i = 0; i < solutions.size(); i++)
		{
			Pair p = solutions.get(i);
			long n = p.y;
			long m = p.x;
			long s = m*m + n*n;
			long perimeter = 3*s + 1;
			if(perimeter > BOUND)
				break;
			sum += perimeter;
			System.out.println(m + " " + n + " " + perimeter);
		}
		System.out.println(sum);
	}

}
