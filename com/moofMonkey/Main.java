package com.moofMonkey;

import com.moofMonkey.audio.Wav;
import com.moofMonkey.cryptos.CryptoProcessor;
import com.moofMonkey.cryptos.PNGVerticalMode;

public class Main {
	static int width = 3840;
	static int height = 2160;
	static CryptoProcessor crypto =  new PNGVerticalMode();
	
	public static void main(String[] args) throws Throwable {
		if(args.length < 3) {
			showHelp();
			return;
		}
		
		if(Boolean.parseBoolean(args[2])) {
			Wav wav = new Wav(args[0]);
			wav.read();
			System.out.println(wav.getSummary());
			byte[] audioData = wav.audioData;
			
			crypto.wav2this(args[0], audioData, width, height);
		} else
			if(args.length >= 4)
				crypto.this2wav(args[0], Integer.parseInt(args[3]));
			else
				crypto.this2wav(args[0], -1);
	}

	private static void showHelp() {
		System.out.println("java -jar WAV2Pic.jar <source> <destination> <encode?> [dataLen]");
	}
}
