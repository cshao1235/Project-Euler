
public class Problem91RightTriangleIntegerCoordinates {
	public static int dotProduct(int x1, int y1, int x2, int y2)
	{
		return x1 * x2 + y1 * y2;
	}
	public static long numTriangles(int bound)
	{
		long qcount = 0;
		long ocount = 0;
		for(int qx = 0; qx <= bound; qx++)
		{
			for(int qy = 0; qy <= bound; qy++)
			{
				if(qx == 0 && qy == 0)
					continue;
				else
				{
					for(int px = 0; px <= bound; px++)
					{
						for(int py = 0; py <= bound; py++)
						{
							if(px == 0 && py == 0)
								continue;
							else if(px == qx && py == qy)
								continue;
							else
							{
								if(dotProduct(qx, qy, px - qx, py - qy) == 0)
								{
									//System.out.println("(" + qx + "," + qy + ")   (" + px + "," + py + ")");
									qcount++;
								}
								else if(dotProduct(qx, qy, px, py) == 0)
								{
									//System.out.println("(" + qx + "," + qy + ")   (" + px + "," + py + ")");
									ocount++;
								}
							}
						}
					}
				}
			}
		}
		return qcount + ocount/2;
	}
	public static void main(String[] args) {
		System.out.println(numTriangles(50));

	}

}
