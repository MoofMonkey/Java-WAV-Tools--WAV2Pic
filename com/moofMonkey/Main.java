package com.moofMonkey;

import com.moofMonkey.audio.Wav;
import com.moofMonkey.cryptos.CryptoProcessor;
import com.moofMonkey.cryptos.PNGVerticalMode;

public class Main {
	static CryptoProcessor crypto =  new PNGVerticalMode();
	
	public static void main(String[] args) throws Throwable {
		if(args.length != 3 && args.length != 4) {
			showHelp();
			return;
		}
		
		if(Boolean.parseBoolean(args[2])) {
			Wav wav = new Wav(args[0]);
			wav.read();
			System.out.println(wav.getSummary());
			byte[] audioData = wav.audioData;
			int len = args.length == 4 ? Integer.parseInt(args[3]) : audioData.length;
			
			PixelData pd = PixelData.getPixelData(len / crypto.bytesPerPixel);
			crypto.wav2this(args[1], audioData, pd.width, pd.height);
		} else
			if(args.length == 4)
				crypto.this2wav(args[0], args[1], Integer.parseInt(args[3]));
			else
				crypto.this2wav(args[0], args[1], -1);
	}

	private static void showHelp() {
		System.out.println("java -jar WAV2Pic.jar <source> <destination> <encode?> [dataLen]");
	}
}
