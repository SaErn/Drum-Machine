package mainPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDialog;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundHandler {

	private static File[] files = { 			new File("Closed Hat.au"), 
			new File("Open Hat.au"), 			new File("Kick.au"),
			new File("Clap.au"), 				new File("Snare 1.au"), 
			new File("Snare 2.au"), 			new File("Crash Cymbal.au"),
			new File("Explosion 1 Delay.au"), 	new File("Explosion 1 Reverb.au") };
	private static InputStream inStream;
	private static AudioStream audioStream1;
	private static AudioStream audioStream2;
	private static AudioStream audioStream3;

	public static void playSound(int buttonNr) {

		try {
			switch (buttonNr) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				inStream = new FileInputStream(files[buttonNr - 1]);
				audioStream1 = new AudioStream(inStream);
				AudioPlayer.player.start(audioStream1);
				break;
			case 8:
				stopSound(buttonNr);
				inStream = new FileInputStream(files[buttonNr - 1]);
				audioStream2 = new AudioStream(inStream);
				AudioPlayer.player.start(audioStream2);
				break;
			case 9:
				stopSound(buttonNr);
				inStream = new FileInputStream(files[buttonNr - 1]);
				audioStream3 = new AudioStream(inStream);
				AudioPlayer.player.start(audioStream3);
				break;
			default:
				break;
			}
		} catch (FileNotFoundException fNFExc) {
			fNFExc.printStackTrace();
		} catch (IOException iOExc) {
			iOExc.printStackTrace();
		}

	}

	public static void stopSound(int buttonNr) {

		switch (buttonNr) {
		case 8:
			AudioPlayer.player.stop(audioStream2);
			break;
		case 9:
			AudioPlayer.player.stop(audioStream3);
			break;
		default:
			break;
		}
	}

}
