package com.moofMonkey.cryptos;

import java.io.File;
import java.nio.file.Files;

import com.moofMonkey.audio.Wav;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

public class CryptoProcessor {
	public int bytesPerPixel;
	
	public void wav2this(String pathForImage, byte[] audioData, int _width, int _height) throws Throwable {  }
	public void this2wav(String pathToImage, String pathForWAV, int dataLen) throws Throwable {  }
	
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
		
		String mp3Post = ".mp3";
		File mp3 = new File(path + (path.endsWith(mp3Post) ? "" : mp3Post));
		e.encode(f, mp3, ea);
		wav.setPath(path);
		
		if(Files.size(mp3.toPath()) == 0) {
			String s = path;
			if(s.endsWith(mp3Post))
				s = s.substring(0, s.length() - mp3Post.length());
			s += ".wav";
			System.out.println("MP3 may not correctly saved. Saving to WAV");
			wav.setPath(s).save();
		}
	}
}
