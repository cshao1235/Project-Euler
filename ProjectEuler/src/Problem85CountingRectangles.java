import java.util.ArrayList;
import java.util.Arrays;


public class Problem85CountingRectangles {
	public static void main(String[] args) {
		int target = 2000000;
		int closestDifference = target;
		int area = 0;
		int[] nC2 = new int[(int) Math.sqrt(2*target) + 1];
		nC2[2] = 1;
		for(int i = 3; i < nC2.length; i++)
			nC2[i] = nC2[i-1] + i - 1;
		System.out.println(Arrays.toString(nC2));
		for(int i = 2; i < nC2.length; i++)
		{
			for(int j = 2; j < nC2.length; j++)
			{
				int distance = target - nC2[i] * nC2[j];
				if(closestDifference > Math.abs(distance))
				{
					area = (i-1)*(j-1);
					closestDifference = Math.abs(distance);
					System.out.println(nC2[i] + " " + nC2[j]);
				}
				if(distance < 0)
					break;
			}
		}
		System.out.println(closestDifference);
		System.out.println(area);
	}

}
