
public class Problem183MaxProductOfParts {
	public static void main(String[] args) {
		int sum = 0;
		int min = 5;
		int max = 10000;
		for(int i = min; i <= max; i++)
		{
			int x1 = (int) (((double) i)/Math.E);
			int x2 = x1+1;
			int maxX = 0;
			if(Math.log(x2) * x2 - Math.log(x1) * x1 >= Math.log(i))
				maxX = x1;
			else
				maxX = x2;
			while(maxX % 2 == 0)
				maxX /= 2;
			while(maxX % 5 == 0)
				maxX /= 5;
			if(i % maxX == 0)
				sum-=i;
			else
				sum+=i;
		}
		System.out.println(sum);
	}

}
