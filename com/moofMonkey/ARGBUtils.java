package com.moofMonkey;

public class ARGBUtils {
	public static int[] fronARGB(int argb) {
		int a, r, g, b;
		
		a = (int) ((argb & 0xFF000000) >> 24);
		r = (int) ((argb & 0x00FF0000) >> 16);
		g = (int) ((argb & 0x0000FF00) >> 8);
		b = (int) (argb & 0x000000FF);
		
		return new int[] {
			a,
			r,
			g,
			b
		};
	}
	
	public static int toARGB(int a, int r, int g, int b) {
		return (a << 24) + (r << 16) + (g << 8) + b;
	}
}
