package main.extramethods;

public class ThreeDHelper {
	private int zMax;
	private TwoDHelper[] map;

	public ThreeDHelper(){
		this.zMax = 4;
		map = new TwoDHelper[4];
		for(int z = 0; z < 4; z++){
			map[z] = new TwoDHelper(4, 4);
		}
		clearMap();
	}

	public ThreeDHelper(int xMax, int yMax, int zMax){
		this.zMax = zMax;
		map = new TwoDHelper[zMax];
		for(int z = 0; z < zMax; z++){
			map[z] = new TwoDHelper(xMax, yMax);
		}
		clearMap();
	}

	public void printMap(){
		for(int z = 0; z < zMax; z++){
			System.out.print(" ");
			for(int i = 1; i <= map[z].getXMax(); i++){
				System.out.print(" " + i);
			}
			System.out.print("   ");
		}
		System.out.println();
		for(int y = 0; y < map[0].getYMax(); y++){
			for(int z = 0; z < zMax; z++){
				System.out.print((y+1) + " ");
				System.out.print(map[z].formatLine(y));
				System.out.print("   ");
			}
			System.out.println();
			if(y < map[0].getYMax()-1){
				for(int z = 0; z < zMax; z++){
					System.out.print(map[z].getBorder()+"   ");
				}
			}
			System.out.println();
		}
	}

	public void printWideMap(){
		for(int z = 0; z < zMax; z++){
			for(int i = 1; i <= map[z].getXMax(); i++){
				System.out.print("   " + i);
			}
			System.out.print("    ");
		}
		System.out.println();
		for(int y = 0; y < map[0].getYMax(); y++){
			for(int z = 0; z < zMax; z++){
				System.out.print((y+1) + " ");
				System.out.print(map[z].formatWideLine(y));
				System.out.print("   ");
			}
			System.out.println();
			if(y < map[0].getYMax()-1){
				for(int z = 0; z < zMax; z++){
					System.out.print(map[z].getWideBorder()+"   ");
				}
			}
			System.out.println();
		}
	}

	public void clearMap(){
		for(int z = 0; z < zMax; z++)
			map[z].clearMap();
	}

	public String getLocation(int x, int y, int z){
		return map[z-1].getLocation(x, y);
	}
	
	public int getZMax(){
		return zMax;
	}

	public int getYMax(){
		return map[0].getYMax();
	}

	public int getXMax(){
		return map[0].getXMax();
	}

	void main(){
		ThreeDHelper test = new ThreeDHelper();
		test.printWideMap();
	}
}
