import java.util.ArrayList;

public class Problem321SwappingCounters {
	public static class Pair
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
	public static ArrayList<Pair> pellTypeSolutions(long n, long a, long minX, long minY, long fminX, long fminY, int numSolutions)
	{
		ArrayList<Pair> solutions = new ArrayList<Pair>();
		solutions.add(new Pair(minX, minY));
		while(solutions.size() < numSolutions)
		{
			Pair p = solutions.get(solutions.size() - 1);
			long x = p.x;
			long y = p.y;
			solutions.add(new Pair(x * fminX + n * y * fminY, y * fminX + x * fminY));
		}
		return solutions;
	}
	public static void main(String[] args) {
		//M(n) = (n + 1)^2 - 1 = k(k + 1)/2
		//4k^2 + 4k + 1 = 8(n + 1)^2 - 7
		//(2k + 1)^2 - 8(n + 1)^2 = -7
		//x^2 - 8y^2 = -7
		int n = 8;
		int a = -7;
		//int minX = 1;
		//int minY = 1;
		int fminX = 3;
		int fminY = 1;
		int numGeneratedSolutions = 23;
		int numSolutions = 40;
		double upperBound = (Math.sqrt(n)*fminY + fminX)*Math.sqrt(Math.abs(a));
		ArrayList<Pair> minimalSolutions = new ArrayList<Pair>();
		for(int i = 3; i <= upperBound; i++)
		{
			if((i*i - a)%n != 0)
				continue;
			int square = (i*i - a)/n; 
			int j = (int) Math.sqrt(square);
			if(j*j == square)
				minimalSolutions.add(new Pair(i, j));
		}
		ArrayList<ArrayList<Pair>> allSolutions = new ArrayList<ArrayList<Pair>>();
		for(Pair p : minimalSolutions)
		{
			ArrayList<Pair> solutions = pellTypeSolutions(n, a, p.x, p.y, fminX, fminY, numGeneratedSolutions);
			System.out.println(solutions.toString());
			allSolutions.add(solutions);
		}
		int[] counters = new int[allSolutions.size()];
		int solutionCount = 0;
		ArrayList<Pair> smallSolutions = new ArrayList<Pair>();
		while(solutionCount < numSolutions)
		{
			long min = Long.MAX_VALUE;
			int index = 0;
			for(int i = 0; i < allSolutions.size(); i++)
			{
				if(allSolutions.get(i).get(counters[i]).y < min)
				{
					index = i;
					min = allSolutions.get(i).get(counters[i]).y;
				}
			}
			smallSolutions.add(allSolutions.get(index).get(counters[index]));
			solutionCount++;
			counters[index]++;
		}
		System.out.println(smallSolutions.toString());
		long sum = 0;
		for(Pair p : smallSolutions)
			sum += p.y - 1;
		System.out.println(sum);
	}

}
