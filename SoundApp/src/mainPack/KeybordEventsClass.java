/* Keybord Events Class
 * v 1.0 
 * 2020-09-24 */
package mainPack;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/* Klassen extendar KeyAdapter så att den kan ärva dess metoder och användas som ett KeyListener objekt. Den JFrame som
 * används i programmet tilldelas denna klassen som KeyListener så att programmet kan använda hotkeys*/
public class KeybordEventsClass extends KeyAdapter {

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) throws  ArrayIndexOutOfBoundsException { }

	/* Hämtar Key-eventets key-char och skickar till metod som tar char och returnerar index int.
	 * Testar så den int har fått en värde större än 0, är i så fall godkänd tangentbordstryckning.
	 * Index int skickas sen till playSound metoden så ljud som motsvarar det index spelas.
	 * InterfaceBuilder metoden convertKeyPressClick anropas så buttons "markeras/blinkar" vid nedtryckning av motsvarande hotkey
	 */
	@Override
	public void keyPressed(KeyEvent e) throws ArrayIndexOutOfBoundsException {
		
		int keyConvertedToIndex = HotKeyTester.testHotKey(e.getKeyChar());
		if (keyConvertedToIndex > 0 ) {
			SoundHandler.playSound(keyConvertedToIndex);
			InterfaceBuilder.convertKeyPressToClick(keyConvertedToIndex);
		}
	}
	
	public static void InitiateListeners(JFrame frame) {
		/*
		 * Frame tilldelas en instans av denna klassen så den kan upptäcka
		 * knapptryckningar på tangentbordet. ListenerHandler extends KeyAdapter så den
		 * kan fungera som en KeyListener
		 */
		frame.addKeyListener(new KeybordEventsClass());

	}


}
