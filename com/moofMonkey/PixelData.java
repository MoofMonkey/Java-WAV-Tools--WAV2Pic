package com.moofMonkey;

public class PixelData {
	int width,  height, pixels;
	
	private PixelData(int _width, int _height) {
		width = _width;
		height = _height;
		
		pixels = width * height;
	}
	
	public static PixelData getPixelData(int num) throws Throwable {
		int xy = (int) Math.round(Math.sqrt(num)); // 1:1
		
		return new PixelData (
			xy,
			xy
		);
	}
}
