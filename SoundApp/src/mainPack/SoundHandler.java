/* Sound Handler
 * v 1.0 
 * 2020-09-24 */
package mainPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundHandler {

	/* String array som h�ller namn p� alla ljudfiler som ska anv�ndas i File objekt i programmet */
	private static String[] fileNames = {new String("Closed Hat.au"), 
			new String("Open Hat.au"), 			new String("Kick.au"),
			new String("Clap.au"), 				new String("Snare 1.au"), 
			new String("Snare 2.au"), 			new String("Crash Cymbal.au"),
			new String("Explosion 1 Delay.au"), new String("Explosion 1 Reverb.au") };
	private static File currentFile;							/* Aktuell ljudfil som ska spelas upp */
	private static InputStream inStream;						/* Streamar in filers inneh�ll */
	private static AudioStream aStreamRepeating;				/* Lagrar audio-konverterad in-streamad fil */
	private static AudioStream aStreamStoppable1;				/* En f�r korta ljud som ska kunna spelas upp "samtidigt" */
	private static AudioStream aStreamStoppable2;				/* Tv� f�r l�ngre ljud som stoppas innan upprepning */

	/* Spelar upp ljud n�r buttons klickas p� eller hotkey triggas. Tar emot nedtryckt buttons nummer som anv�nds
	 * f�r att v�lja r�tt filnamn ur string array med filnamn s� ljud tillh�rande nedtryckt button spelas upp. 
	 * I case 8 och 9 anv�nds �ven stopSound metoden f�r att stoppa ljud som redan spelas upp */
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
				inStream = new FileInputStream(currentFile = new File(fileNames[buttonNr-1]));
				aStreamRepeating = new AudioStream(inStream);
				AudioPlayer.player.start(aStreamRepeating);
				break;
			case 8:
				stopSound(buttonNr);
				inStream = new FileInputStream(currentFile = new File(fileNames[buttonNr-1]));
				aStreamStoppable1 = new AudioStream(inStream);
				AudioPlayer.player.start(aStreamStoppable1);
				break;
			case 9:
				stopSound(buttonNr);
				inStream = new FileInputStream(currentFile = new File(fileNames[buttonNr-1]));
				aStreamStoppable2 = new AudioStream(inStream);
				AudioPlayer.player.start(aStreamStoppable2);
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

	/* Stoppar ljud som spelas upp. Anv�nds f�r l�nga ljud som ska stoppas innan repetering och n�r programmet avslutas */
	public static void stopSound(int buttonNr) {

		switch (buttonNr) {
		case 8:
			AudioPlayer.player.stop(aStreamStoppable1);
			break;
		case 9:
			AudioPlayer.player.stop(aStreamStoppable2);
			break;
		default:
			AudioPlayer.player.stop(aStreamRepeating);
			AudioPlayer.player.stop(aStreamStoppable1);
			AudioPlayer.player.stop(aStreamStoppable2);
			break;
		}
	}


}
