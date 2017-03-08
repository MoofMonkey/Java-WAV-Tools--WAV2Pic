package com.moofMonkey;

import java.util.ArrayList;
import java.util.Collections;

public class PixelData {
	int width,  height, pixels;
	
	private PixelData(int _width, int _height) {
		width = _width;
		height = _height;
		
		pixels = width * height;
	}
	
	public static PixelData getPixelData(int num) throws Throwable {
		ArrayList<Integer> factors = getFactors(num);
		
		int width = factors.get(factors.size() - 1); // Get last factor for ~1:1
		int height = num / width;
		
		return new PixelData (
			width,
			height
		);
	}
	
	public static ArrayList<Integer> getFactors(int num) {
		int upperlimit = (int)(Math.sqrt(num));
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i = 1; i <= upperlimit; i += 1)
			if (num % i == 0)
				factors.add(i);
		
		Collections.sort(factors);
		return factors;
	}
}
