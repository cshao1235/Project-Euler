import java.util.ArrayList;
import java.util.Arrays;


public class Problem86CuboidRoute {
	public static void main(String[] args) {
		int bound = 1000000;
		int size = 2000;
		//int[] squares = new int[3*size+1];
		//for(int i = 1; i < squares.length; i++)
		//	squares[i] = i*i;
		int[] numSolutions = new int[size+1];
		numSolutions[3] = 2;
		for(int i = 4; i <= size; i++)
		{
			numSolutions[i] = numSolutions[i-1];
			for(int j = 2; j <= 2*i; j++)
			{
				int hyp = j*j + i*i;
				int hyp1 = (int) Math.sqrt(hyp);
				if(hyp1*hyp1 == hyp)
					numSolutions[i] += Math.min(j/2, i - (j-1)/2);
			}
		}
		for(int i = 3; i <= size; i++)
		{
			System.out.println(i + " " + numSolutions[i]);
			if(numSolutions[i] > bound)
				break;
		}
	}

}
