package com.moofMonkey.cryptos;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.moofMonkey.ARGBUtils;
import com.moofMonkey.audio.Wav;

public class PNGHorizontalMode extends CryptoProcessor {
	@Override
	public void wav2this(String pathForImage, byte[] audioData, int width, int height) throws Throwable {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		int pixelNum = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
	    		int argb;
	    		try {
		    		argb = ARGBUtils.toARGB (
		    			audioData[pixelNum + 0],
		    			audioData[pixelNum + 1],
		    			audioData[pixelNum + 2],
		    			audioData[pixelNum + 3]
		    		);
	    		} catch(Throwable t) { break; }
	    		
	    		img.setRGB(x, y, argb);
	    		pixelNum = pixelNum + 4;
	    	}
		}

		ImageIO.write(img, "png", new File(pathForImage));
	}

	@Override
	public void this2wav(String pathToImage, String pathForWAV, int dataLen) throws Throwable {
		BufferedImage img = ImageIO.read(new File(pathToImage));
		int width = img.getWidth();
		int height = img.getHeight();
		
		if(dataLen == -1)
			dataLen = width * height * 4;

		byte[] bArr = new byte[dataLen];
		int myNum = 0;
		for(int i = 0; i < dataLen / 4; i++) {
			int x = i / height;
			int y = i % height;

			int argb = img.getRGB(x, y);
			int a, r, g, b;

			try {
				int[] colors = ARGBUtils.fronARGB(argb);
				
				a = colors[0];
				r = colors[1];
				g = colors[2];
				b = colors[3];
			} catch(Throwable t) {
				break;
			}

			bArr[myNum + 0] = (byte) a;
			bArr[myNum + 1] = (byte) r;
			bArr[myNum + 2] = (byte) g;
			bArr[myNum + 3] = (byte) b;

			myNum = myNum + 4;
		}

		Wav wav = new Wav();
		wav.audioData = bArr;
		wav.setPath(pathForWAV);
		saveAsMP3(wav);
	}
}
