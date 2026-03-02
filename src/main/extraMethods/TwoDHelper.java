package main.extramethods;

public class TwoDHelper {
	private String[][] map;
	private int xMax;
	private int yMax;

	public TwoDHelper(){
		this.xMax = 3;
		this.yMax = 3;
		map = new String[yMax][xMax];
		for(int x = 0; x < yMax; x++){
			for(int y = 0; y < xMax; y++){
				map[y][x] = " ";
			}
		}
	}

	public TwoDHelper(int xMax, int yMax){
		this.xMax = xMax;
		this.yMax = yMax;
		map = new String[yMax][xMax];
		for(int y = 0; y < yMax; y++){
			for(int x = 0; x < xMax; x++){
				map[y][x] = " ";
			}
		}
	}

	public String formatLine(int row){
		String result = "";
		for(int i = 0; i < xMax-1; i++){
			result += map[row][i];
			result += "|";
		}
		result += map[row][xMax-1];
		return result;
	}

	public String getBorder(){
		String result = "  ";
		for(int i = 0; i < xMax-1; i++)
			result += "-+";
		result += "-";
		return result;
	}

	public void editCoord(String newChar, int X, int Y){ //newChar 
		if(newChar.length() != 1){
			throw new IllegalArgumentException("newChar must be one character");
		}
		X -= 1;
		Y -= 1;
		map[Y][X] = newChar;
	}

	public void printMap(){
		System.out.print(" ");
		for(int i = 1; i < xMax + 1; i++){
			System.out.print(" " + i);
		}
		System.out.println();
		for(int j = 0; j < yMax; j++){
			System.out.print((j+1) + " ");
			System.out.print(formatLine(j));
			if(j<yMax-1) System.out.println("\n"+getBorder());
			else System.out.println();
		}
		System.out.println();
	}

	public int getYMax(){
		return yMax;
	}

	public int getXMax(){
		return xMax;
	}

	public String getLocation(int X, int Y){
		return map[Y-1][X-1];
	}

	void main(String[] args){
		TwoDHelper test = new TwoDHelper(5,4);
		//System.out.println(test.formatLine(1));
		test.printMap();
		
		test.editCoord("r", 3, 1);
		//System.out.println(getBorder());
		test.printMap();
		//System.out.println(test.formatLine(1));
	}
}
