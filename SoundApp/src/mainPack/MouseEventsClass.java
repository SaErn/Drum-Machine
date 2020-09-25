/* Mouse Events Class 
 * v 1.0 
 * 2020-09-24 */
package mainPack;

import java.awt.event.MouseListener;
import javax.swing.JButton;

public class MouseEventsClass{

	/*
	 * Skapar ett MouseListener objekt s� listeners kan tilldelas till buttons-array
	 * genom iteration.
	 */
	private static MouseListener mouseListener = new MouseListener() {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {	}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {	}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) { }

		/*
		 * Overridear mousepressed som testar om MouseEvent objektets "source" �r en
		 * JButton. Om ja, lagras den knappens text i string. Om texten �r lika med
		 * "EXIT" st�ngs programmet av. Om inte anv�nds replaceAll f�r att ta bort alla
		 * tecken utom heltal. Isolerat heltal lagras i string, omvandlas till int, och
		 * skickas som argument till metod d�r den identifierar vilken knapps ljud som
		 * ska spelas upp.
		 *
		 * I ReplaceAll anv�nds Regular Expression i argument parentes. Det som uttrycks
		 * i f�rsta set av citationstecken("") byts ut mot det i den andra. 
		 *  \\D  - 		st�r f�r "a non digit"(ett tecken som inte �r siffra).
		 *  +	 - 		st�r f�r en eller flera f�rekomster av tecken.
		 * dvs. Alla tecken som inte �r siffra byts ut mot "ingenting"
		 * 
		 * Uppspelningen av ljud sk�ts h�r i pressed s� att ljudet kommer ut direkt
		 * vid nedklick, inte vid release
		 */
		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			if (e.getSource() instanceof JButton) {
				String textString = ((JButton) e.getSource()).getText();

				if (textString == "EXIT") {
					SoundHandler.stopSound(0);
					System.exit(0);

				} else {
					int isolatedInt = Integer.parseInt(textString.replaceAll("\\D+", ""));
					
						SoundHandler.playSound(isolatedInt);
				}
			}
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {}
	};

	/*
	 * Tilldelar listeners till alla buttons i button-array. 
	 */
	public static void InitiateListeners(JButton[] buttons) {

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addMouseListener(mouseListener);
		}

	}

}
