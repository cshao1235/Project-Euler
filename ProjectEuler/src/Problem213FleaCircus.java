import java.util.Arrays;


public class Problem213FleaCircus {
	private static final int NUM_MOVES = 50;
	private static final int SIZE = 30;
	private static double[][][][] probability = new double[SIZE*SIZE][SIZE][SIZE][2];
	public static void main(String[] args) {
		for(int i = 0; i < SIZE*SIZE; i++)
		{
			int r = i/SIZE;
			int c = i%SIZE;
			probability[i][r][c][0] = 1;
			for(int j = 0; j < NUM_MOVES; j++)
			{
				for(int row = 0; row < SIZE; row++)
				{
					for(int col = 0; col < SIZE; col++)
					{
						probability[i][row][col][(j+1)%2] = 0.0;
					}
				}
				for(int row = 0; row < SIZE; row++)
				{
					for(int col = 0; col < SIZE; col++)
					{
						if(row > 0 && row < SIZE - 1 && col > 0 && col < SIZE - 1)
						{
							probability[i][row + 1][col][(j+1)%2] += probability[i][row][col][j%2]/4;
							probability[i][row][col + 1][(j+1)%2] += probability[i][row][col][j%2]/4;
							probability[i][row - 1][col][(j+1)%2] += probability[i][row][col][j%2]/4;
							probability[i][row][col - 1][(j+1)%2] += probability[i][row][col][j%2]/4;
						}
						else if(row == 0 && col == 0)
						{
							probability[i][row + 1][col][(j+1)%2] += probability[i][row][col][j%2]/2;
							probability[i][row][col + 1][(j+1)%2] += probability[i][row][col][j%2]/2;
						}
						else if(row == 0 && col == SIZE - 1)
						{
							probability[i][row + 1][col][(j+1)%2] += probability[i][row][col][j%2]/2;
							probability[i][row][col - 1][(j+1)%2] += probability[i][row][col][j%2]/2;
						}
						else if(row == SIZE - 1 && col == 0)
						{
							probability[i][row - 1][col][(j+1)%2] += probability[i][row][col][j%2]/2;
							probability[i][row][col + 1][(j+1)%2] += probability[i][row][col][j%2]/2;
						}
						else if(row == SIZE - 1 && col == SIZE - 1)
						{
							probability[i][row - 1][col][(j+1)%2] += probability[i][row][col][j%2]/2;
							probability[i][row][col - 1][(j+1)%2] += probability[i][row][col][j%2]/2;
						}
						else if(row == 0)
						{
							probability[i][row + 1][col][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row][col + 1][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row][col - 1][(j+1)%2] += probability[i][row][col][j%2]/3;
						}
						else if(row == SIZE - 1)
						{
							probability[i][row - 1][col][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row][col + 1][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row][col - 1][(j+1)%2] += probability[i][row][col][j%2]/3;
						}
						else if(col == 0)
						{
							probability[i][row + 1][col][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row][col + 1][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row - 1][col][(j+1)%2] += probability[i][row][col][j%2]/3;
						}
						else
						{
							probability[i][row + 1][col][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row][col - 1][(j+1)%2] += probability[i][row][col][j%2]/3;
							probability[i][row - 1][col][(j+1)%2] += probability[i][row][col][j%2]/3;
						}
					}
				}
			}
		}
		double[][] probabilityOfNoFlea = new double[SIZE][SIZE];
		for(int row = 0; row < SIZE; row++)
		{
			for(int col = 0; col < SIZE; col++)
			{
				probabilityOfNoFlea[row][col] = 1.0;
			}
		}
		for(int row = 0; row < SIZE; row++)
		{
			for(int col = 0; col < SIZE; col++)
			{
				for(int flea = 0; flea < SIZE*SIZE; flea++)
				{
					probabilityOfNoFlea[row][col] *= (1 - probability[flea][row][col][NUM_MOVES%2]);
				}
			}
		}
		double expected = 0;
		for(int row = 0; row < SIZE; row++)
		{
			for(int col = 0; col < SIZE; col++)
			{
				expected += probabilityOfNoFlea[row][col];
			}
		}
		System.out.println(expected);
	}
}
