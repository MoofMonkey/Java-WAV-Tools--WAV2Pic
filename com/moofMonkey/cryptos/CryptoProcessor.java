package com.moofMonkey.cryptos;

import java.io.File;

import com.moofMonkey.audio.Wav;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

public class CryptoProcessor {
	public void wav2this(String pathForImage, byte[] audioData, int _width, int _height) throws Throwable {  }
	public void this2wav(String pathToImage, int dataLen) throws Throwable {  }
	
	public static void saveAsMP3(Wav wav) throws Throwable {
		File f = File.createTempFile("wav_", "_wav");
		String path = wav.getPath();
		wav.setPath (
			f.getAbsolutePath()
		).save();
		
		int samplingRate = wav.sampleRate;
		int channels = wav.numChannels;
		int bitRate = 180 * 1000;

		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(bitRate);
		audio.setChannels(channels);
		audio.setSamplingRate(samplingRate);
		EncodingAttributes ea = new EncodingAttributes();
		ea.setAudioAttributes(audio);
		ea.setFormat("mp3");
		Encoder e = new Encoder();

		e.encode(f, new File(path + ".mp3"), ea);
		wav.setPath(path);
	}
}
