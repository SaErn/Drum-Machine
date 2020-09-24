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

	/* String array som håller namn på alla ljudfiler som ska användas i File objekt i programmet */
	private static String[] fileNames = {new String("Closed Hat.au"), 
			new String("Open Hat.au"), 			new String("Kick.au"),
			new String("Clap.au"), 				new String("Snare 1.au"), 
			new String("Snare 2.au"), 			new String("Crash Cymbal.au"),
			new String("Explosion 1 Delay.au"), new String("Explosion 1 Reverb.au") };
	private static File currentFile;							/* Aktuell ljudfil som ska spelas upp */
	private static InputStream inStream;						/* Streamar in filers innehåll */
	private static AudioStream aStreamRepeating;				/* Lagrar audio-konverterad in-streamad fil */
	private static AudioStream aStreamStoppable1;				/* En för korta ljud som ska kunna spelas upp "samtidigt" */
	private static AudioStream aStreamStoppable2;				/* Två för längre ljud som stoppas innan upprepning */

	/* Spelar upp ljud när buttons klickas på eller hotkey triggas. Tar emot nedtryckt buttons nummer som används
	 * för att välja rätt filnamn ur string array med filnamn så ljud tillhörande nedtryckt button spelas upp. 
	 * I case 8 och 9 används även stopSound metoden för att stoppa ljud som redan spelas upp */
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

	/* Stoppar ljud som spelas upp. Används för långa ljud som ska stoppas innan repetering och när programmet avslutas */
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
