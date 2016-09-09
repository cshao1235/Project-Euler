
public class Problem205DiceGame {
	public static void main(String[] args) {
		int rollsP = 9;
		int numP = 4;
		int rollsC = 6;
		int numC = 6;
		int[][] possibilitiesP = new int[numP * rollsP + 1][rollsP + 1];
		for(int i = 1; i <= numP; i++)
			possibilitiesP[i][1] = 1;
		for(int r = 2; r <= rollsP; r++)
		{
			for(int i = 1; i <= numP * rollsP; i++)
			{
				for(int k = 1; k <= numP; k++)
				{
					if(i + k <= numP * rollsP)
					{
						possibilitiesP[i+k][r] += possibilitiesP[i][r-1];
					}
				}
			}
		}
		int[][] possibilitiesC = new int[numC * rollsC + 1][rollsC + 1];
		for(int i = 1; i <= numC; i++)
			possibilitiesC[i][1] = 1;
		for(int r = 2; r <= rollsC; r++)
		{
			for(int i = 1; i <= numC * rollsC; i++)
			{
				for(int k = 1; k <= numC; k++)
				{
					if(i + k <= numC * rollsC)
					{
						possibilitiesC[i+k][r] += possibilitiesC[i][r-1];
					}
				}
			}
		}
		for(int i = 1; i <= rollsP; i++)
		{
			for(int j = 1; j <= numP * rollsP; j++)
				System.out.print(possibilitiesP[j][i] + ",");
			System.out.println();
		}
		for(int i = 1; i <= rollsC; i++)
		{
			for(int j = 1; j <= numC * rollsC; j++)
				System.out.print(possibilitiesC[j][i] + ",");
			System.out.println();
		}
		long sum = 0;
		for(int i = 1; i <= numP * rollsP; i++)
		{
			for(int j = 1; j < i; j++)
			{
				sum += possibilitiesP[i][rollsP] * possibilitiesC[j][rollsC];
			}
		}
		double probability = (double) sum / Math.pow(numP, rollsP) / Math.pow(numC, rollsC);
		System.out.println(probability);
	}

}
