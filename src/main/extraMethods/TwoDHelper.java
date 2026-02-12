package main.extraMethods;

public class TwoDHelper {
	private String[][] map;
	private int xMax;
	private int yMax;

	public TwoDHelper(int xMax, int yMax){
		this.xMax = xMax;
		this.yMax = yMax;
		map = new String[xMax][yMax];
		for(int x = 0; x < xMax; x++){
			for(int y = 0; y < yMax; y++){
				map[x][y] = " ";
			}
		}
	}

	public String formatLine(int row){
		String result = " ";
		for(int i = 0; i < yMax; i++){
			result += map[row][i];
			result += "|";
		}
		return result;
	}
}
