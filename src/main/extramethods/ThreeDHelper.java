package main.extramethods;

public class ThreeDHelper {
	private int xMax;
	private int yMax;
	private int zMax;
	private String[][][] map;

	public ThreeDHelper(int xMax, int yMax, int zMax){
		this.xMax = xMax;
		this.yMax = yMax;
		this.zMax = zMax;
		map = new String[zMax][yMax][xMax];
		clearMap();
	}

	public void clearMap(){
		for(int x = 0; x < xMax; x++)
			for(int y = 0; x < yMax; y++)
				for(int z = 0; z < zMax; z++)
					map[z][y][x] = " ";
	}

	public String getLocation(int x, int y, int z){
		x -= 1;
		y -= 1;
		z -= 1;
		return map[z][y][x];
	}

	public int getXMax(){
		return xMax;
	}

	public int getYMax(){
		return yMax;
	}
	
	public int getZMax(){
		return zMax;
	}
}
