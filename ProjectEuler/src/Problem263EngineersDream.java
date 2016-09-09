import java.util.ArrayList;
import java.util.Arrays;


public class Problem263EngineersDream {
	public static void main(String[] args) {
		for(int i = 2; i < 1000; i+=2)
		{
			ArrayList<Integer> divisors = new ArrayList<Integer>();
			for(int j = 1; j < Math.sqrt(i); j++)
			{
				if(i%j == 0)
				{
					divisors.add(j);
					divisors.add(i/j);
				}
			}
			int sqrt = (int) Math.sqrt(i);
			if(sqrt*sqrt == i)
				divisors.add(sqrt);
			//System.out.println(divisors.toString());
			boolean[] possibleSums = new boolean[i + 1];
			possibleSums[0] = true;
			for(int j : divisors)
			{
				for(int k = i - j; k >= 0; k--)
				{
					if(possibleSums[k])
					{
						//System.out.println(k + " " + j);
						possibleSums[k + j] = true;
					}
				}
			}
			boolean allPossible = true;
			for(int k = 1; k <= i; k++)
			{
				if(!possibleSums[k])
				{
					allPossible = false;
					break;
				}
			}
			if(!allPossible)
				System.out.println(i);
		}
	}

}
