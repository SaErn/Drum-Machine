/* Keybord Events Class
 * v 1.0 
 * 2020-09-24 */
package mainPack;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/* Klassen extendar KeyAdapter s� att den kan �rva dess metoder och anv�ndas som ett KeyListener objekt. Den JFrame som
 * anv�nds i programmet tilldelas denna klassen som KeyListener s� att programmet kan anv�nda hotkeys*/
public class KeybordEventsClass extends KeyAdapter {

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) throws  ArrayIndexOutOfBoundsException { }

	/* H�mtar Key-eventets key-char och skickar till metod som tar char och returnerar index int.
	 * Testar s� den int har f�tt en v�rde st�rre �n 0, �r i s� fall godk�nd tangentbordstryckning.
	 * Index int skickas sen till playSound metoden s� ljud som motsvarar det index spelas.
	 * InterfaceBuilder metoden convertKeyPressClick anropas s� buttons "markeras/blinkar" vid nedtryckning av motsvarande hotkey
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
		 * Frame tilldelas en instans av denna klassen s� den kan uppt�cka
		 * knapptryckningar p� tangentbordet. ListenerHandler extends KeyAdapter s� den
		 * kan fungera som en KeyListener
		 */
		frame.addKeyListener(new KeybordEventsClass());

	}


}
