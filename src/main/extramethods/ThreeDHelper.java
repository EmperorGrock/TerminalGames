package main.extramethods;

/**
 * A helper class for managing 3D grids using TwoDHelper instances.
 * @author EmperorGrock
 */
public class ThreeDHelper {
	private int zMax;
	private TwoDHelper[] map;

	/**
	 * Constructs a ThreeDHelper with default dimensions (4x4x4).
	 */
	public ThreeDHelper(){
		this.zMax = 4;
		map = new TwoDHelper[4];
		for(int z = 0; z < 4; z++){
			map[z] = new TwoDHelper(4, 4);
		}
		clearMap();
	}

	/**
	 * Constructs a ThreeDHelper with specified dimensions.
	 * @param xMax the maximum x dimension
	 * @param yMax the maximum y dimension
	 * @param zMax the maximum z dimension
	 */
	public ThreeDHelper(int xMax, int yMax, int zMax){
		this.zMax = zMax;
		map = new TwoDHelper[zMax];
		for(int z = 0; z < zMax; z++){
			map[z] = new TwoDHelper(xMax, yMax);
		}
		clearMap();
	}

	/**
	 * Prints the 3D map to the console.
	 */
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

	/**
	 * Prints the 3D map in wide format to the console.
	 */
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

	/**
	 * Clears all maps in the 3D grid.
	 */
	public void clearMap(){
		for(int z = 0; z < zMax; z++)
			map[z].clearMap();
	}

	/**
	 * Gets the value at the specified location in the 3D grid.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 * @return the value at the location
	 */
	public String getLocation(int x, int y, int z){
		return map[z-1].getLocation(x, y);
	}

	/**
	 * Sets the value at the specified location in the 3D grid. newChar MUST be one character.
	 * No precondition checks that x, y, z are within bounds, or that newChar is one character, so be careful when using this method.
	 * @param newChar the new character to set at the location
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 */
	public void editCoord(String newChar, int x, int y, int z){
		map[z-1].editCoord(newChar, x, y);
	}
	
	/**
	 * Gets the maximum x dimension.
	 * @return the maximum x dimension
	 */
	public int getZMax(){
		return zMax;
	}

	/**
	 * Gets the maximum y dimension.
	 * @return the maximum y dimension
	 */
	public int getYMax(){
		return map[0].getYMax();
	}

	/**
	 * Gets the maximum x dimension.
	 * @return the maximum x dimension
	 */
	public int getXMax(){
		return map[0].getXMax();
	}

	/**
	 * Method to retrieve a slice of the ThreeDHelper as a TwoDHelper. 
	 * For whichDimensions, put 1, 2, or 3 corresponding to XY, XZ, or YZ.
	 * For location, put the the coordinate of the slice you want.
	 * For example, for the slice of XZ at location Y = 2, put (2, 2)
	 * BE CAREFUL: This method has no precondition checks.
	 * @param whichDimensions the dimensions to slice along (1 for XY, 2 for XZ, 3 for YZ)
	 * @param location the coordinate of the slice to retrieve
	 * @return a TwoDHelper representing the requested slice of the ThreeDHelper
	 * @throws IllegalArgumentException if whichDimensions is not 1, 2, or 3
	 */
	public TwoDHelper getLayer(int whichDimensions, int location) throws IllegalArgumentException{
		TwoDHelper slice;
		switch(whichDimensions){
			case(1):
				return map[location-1];
			case(2):
				slice = new TwoDHelper(map[0].getXMax(), zMax);
				for(int x = 1; x <= map[0].getXMax(); x++)
					for(int z = 1; z <= zMax; z++)
						slice.editCoord(getLocation(x,location,z),x,z);
				return slice;
			case(3):
				slice = new TwoDHelper(map[0].getYMax(), zMax);
				for(int y = 1; y <= map[0].getYMax(); y++)
					for(int z = 1; z <= zMax; z++)
						slice.editCoord(getLocation(location,y,z),y,z);
				return slice;
			default: 
				throw new IllegalArgumentException("You inputed out of the options.");
		}
	}
}
