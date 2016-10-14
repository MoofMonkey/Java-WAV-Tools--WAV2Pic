package com.moofMonkey;

public enum PixelData {
	FOUR(3840, 2160),
	SIXTEEN(15360, 8640),
	SIXTY_FOUR(61440, 34560),
	;
	
	int width,  height, pixels;
	
	private PixelData(int _width, int _height) {
		width = _width;
		height = _height;
		
		pixels = width * height;
	}
	
	public static PixelData getNearest(int num) throws Throwable {
		PixelData last = null;
		for(PixelData pd : values())
			if(num < pd.pixels)
				if(last == null || pd.pixels < last.pixels)
					last = pd;
		
		return last;
	}
}
