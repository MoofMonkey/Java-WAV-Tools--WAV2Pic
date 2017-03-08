package com.moofMonkey;

public class PixelData {
	int width,  height, pixels;
	
	private PixelData(int _width, int _height) {
		width = _width;
		height = _height;
		
		pixels = width * height;
	}
	
	public static PixelData getPixelData(int num) throws Throwable {
		int xy = floorMax(Math.sqrt(num)); // 1:1
		
		return new PixelData (
			xy,
			xy
		);
	}
	
	public static int floorMax(double i) {
		int floor = (int) (i / 1);
		if(i > floor)
			floor =+ 1;
		
		return floor;
	}
}
