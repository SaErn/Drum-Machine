/* Mouse Events Class 
 * v 1.0 
 * 2020-09-24 */
package mainPack;

import java.awt.event.MouseListener;
import javax.swing.JButton;

public class MouseEventsClass{

	/*
	 * Skapar ett MouseListener objekt så listeners kan tilldelas till buttons-array
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
		 * Overridear mousepressed som testar om MouseEvent objektets "source" är en
		 * JButton. Om ja, lagras den knappens text i string. Om texten är lika med
		 * "EXIT" stängs programmet av. Om inte används replaceAll för att ta bort alla
		 * tecken utom heltal. Isolerat heltal lagras i string, omvandlas till int, och
		 * skickas som argument till metod där den identifierar vilken knapps ljud som
		 * ska spelas upp.
		 *
		 * I ReplaceAll används Regular Expression i argument parentes. Det som uttrycks
		 * i första set av citationstecken("") byts ut mot det i den andra. 
		 *  \\D  - 		står för "a non digit"(ett tecken som inte är siffra).
		 *  +	 - 		står för en eller flera förekomster av tecken.
		 * dvs. Alla tecken som inte är siffra byts ut mot "ingenting"
		 * 
		 * Uppspelningen av ljud sköts här i pressed så att ljudet kommer ut direkt
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
