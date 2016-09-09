import java.util.Arrays;


public class Problem232TheRace {
	public static void main(String[] args) {
		int numPointsToWin = 100;
		double[][] probability = new double[numPointsToWin + 1][numPointsToWin + 1];
		probability[1][1] = 2.0/3;
		for(int i = 1; i <= numPointsToWin; i++) //p2
		{
			int maxT = (int) Math.ceil(Math.log(i) / Math.log(2)) + 1;
			for(int j = 1; j <= numPointsToWin; j++) //p1
			{
				if(i == 1 && j == 1)
					continue;
				else
				{
					int t1 = 0;
					double maxP = 0.0;
					for(int t = 1; t < maxT; t++)
					{
						double p = probability[j-1][i - (int) Math.pow(2, t - 1)] + (Math.pow(2, t) - 1) * probability[j-1][i] + probability[j][i - (int) Math.pow(2, t-1)];
						p /= (Math.pow(2, t) + 1);
						if(p > maxP)
						{
							maxP = p;
							t1 = t;
						}
					}
					double p1 = 2 + (Math.pow(2, maxT) - 1) * probability[j-1][i];
					p1 /= (Math.pow(2, maxT) + 1);
					if(p1 > maxP)
					{
						maxP = p1;
						t1 = maxT;
					}
					probability[j][i] = maxP;
					//System.out.println(t1 + " " + maxT);
				}
			}
		}
		for(int i = 1; i <= numPointsToWin/10; i++)
		{
			System.out.println(Arrays.toString(probability[i]));
		}
		System.out.println((probability[numPointsToWin][numPointsToWin] + probability[numPointsToWin - 1][numPointsToWin])/2);
	}
}
