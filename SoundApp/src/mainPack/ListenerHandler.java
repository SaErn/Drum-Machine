/* Listener Handler 
 * v 1.0 
 * 2020-09-24 */
package mainPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/* Klassen extendar KeyAdapter så att den kan ärva dess metoder och användas som ett KeyListener objekt. Den JFrame som
 * används i programmet tilldelas denna klassen som KeyListener så att programmet kan använda hotkeys*/
public class ListenerHandler extends KeyAdapter {
	/*
	 * Boolean array som har en indexplats för varje button som spelar upp ljud.
	 * Ställs till false när någon button är nedtryck via klickning eller hotkey så
	 * att den blir "disabled" och att det då inte går att "spamma" knapparna då
	 * detta tillslut skapar för mycket input så programmet låser sig tills den kört
	 * färdigt alla events
	 */
	private static boolean[] keysEnabled = { true, true, true, true, true, true, true, true, true, };

	/*
	 * För att aktivera "crazy mode" som gör att ljud spelas både vid key-/mouse-
	 * pressed och release så man kan "spela snabbare", så att säga
	 */
	private static boolean ludacriseModeEnabled = false;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/*
	 * Switch-satsen testar vilken knapp som "releasats" på tangentbordet och
	 * ställer dess keysEnabled array index som true så knappen kan tryckas ner
	 * igen. Om Crazy mode är aktiverat så spelas ljudet upp en gång till här vid
	 * release
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 't':
			keysEnabled[0] = true;
			if (ludacriseModeEnabled == true) {
				SoundHandler.playSound(1);
			}
			break;
		case 'y':
			keysEnabled[1] = true;
			if (ludacriseModeEnabled == true) {
				SoundHandler.playSound(2);
			}
			break;
		case 'u':
			keysEnabled[2] = true;
			if (ludacriseModeEnabled == true) {
				SoundHandler.playSound(3);
			}
			break;
		case 'g':
			keysEnabled[3] = true;
			if (ludacriseModeEnabled == true) {
				SoundHandler.playSound(4);
			}
			break;
		case 'h':
			keysEnabled[4] = true;
			if (ludacriseModeEnabled == true) {
				SoundHandler.playSound(5);
			}
			break;
		case 'j':
			keysEnabled[5] = true;
			if (ludacriseModeEnabled == true) {
				SoundHandler.playSound(6);
			}
			break;
		case 'b':
			keysEnabled[6] = true;
			if (ludacriseModeEnabled == true) {
				SoundHandler.playSound(7);
			}
			break;
		case 'n':
			keysEnabled[7] = true;
//			if (ludacriseModeEnabled == true) {
//				SoundHandler.playSound(8);
//			}
			break;
		case 'm':
			keysEnabled[8] = true;
//			if (ludacriseModeEnabled == true) {
//				SoundHandler.playSound(9);
//			}
//			break;
		default:
			break;
		}
	}

	/*
	 * Fungerar i stort sett som keyReleased ovan men här testas först keysEnabled
	 * index så inte knappen redan är nedtryckt med musen, om inte ställs
	 * keysEnabled index till false. InterfaceBuilder metoden convertKeyPressClick
	 * anropas så buttons "markeras/blinkar" vid nedtryckning av motsvarande hotkey
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		switch (e.getKeyChar()) {
		case 't':
			if (keysEnabled[0] == true) {
				keysEnabled[0] = false;
				SoundHandler.playSound(1);
				InterfaceBuilder.convertKeyPressToClick(1);
			}
			break;
		case 'y':
			if (keysEnabled[1] == true) {
				keysEnabled[1] = false;
				SoundHandler.playSound(2);
				InterfaceBuilder.convertKeyPressToClick(2);
			}
			break;
		case 'u':
			if (keysEnabled[2] == true) {
				keysEnabled[2] = false;
				SoundHandler.playSound(3);
				InterfaceBuilder.convertKeyPressToClick(3);
			}
			break;
		case 'g':
			if (keysEnabled[3] == true) {
				keysEnabled[3] = false;
				SoundHandler.playSound(4);
				InterfaceBuilder.convertKeyPressToClick(4);
			}
			break;
		case 'h':
			if (keysEnabled[4] == true) {
				keysEnabled[4] = false;
				SoundHandler.playSound(5);
				InterfaceBuilder.convertKeyPressToClick(5);
			}
			break;
		case 'j':
			if (keysEnabled[5] == true) {
				keysEnabled[5] = false;
				SoundHandler.playSound(6);
				InterfaceBuilder.convertKeyPressToClick(6);
			}
			break;
		case 'b':
			if (keysEnabled[6] == true) {
				keysEnabled[6] = false;
				SoundHandler.playSound(7);
				InterfaceBuilder.convertKeyPressToClick(7);
			}
			break;
		case 'n':
			if (keysEnabled[7] == true) {
				keysEnabled[7] = false;
				SoundHandler.playSound(8);
				InterfaceBuilder.convertKeyPressToClick(8);
			}
			break;
		case 'm':
			if (keysEnabled[8] == true) {
				keysEnabled[8] = false;
				SoundHandler.playSound(9);
				InterfaceBuilder.convertKeyPressToClick(9);
			}
			break;
		default:
			break;
		}
	}

	/*
	 * Skapar ett MouseListener objekt så listeners kan tilldelas till buttons-array
	 * genom iteration.
	 * 
	 * Overridear actionPerformed som testar om ActionEvent objektets "source" är en
	 * JButton. Om ja, lagras den knappens text i string. Sen används replaceAll för
	 * att ta bort alla tecken utom heltal. Isolerat heltal lagras i string,
	 * omvandlas till int, och skickas som argument till metod där den identifierar
	 * vilken knapps ljud som ska spelas upp.
	 */
	private static MouseListener mouseListener = new MouseListener() {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			if (e.getSource() instanceof JRadioButton) {
				System.out.println(InterfaceBuilder.crazyModeButtonSelected());
				if (InterfaceBuilder.crazyModeButtonSelected() == true) {
					ludacriseModeEnabled = true;
					System.out.println(ludacriseModeEnabled);
				} else {
					ludacriseModeEnabled = false;
					System.out.println(ludacriseModeEnabled);
				}
			}
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
		}

		/*
		 * Overridear mousepressed som testar om MouseEvent objektets "source" är en
		 * JButton. Om ja, lagras den knappens text i string. Om texten är lika med
		 * "EXIT" stängs programmet av. Om inte används replaceAll för att ta bort alla
		 * tecken utom heltal. Isolerat heltal lagras i string, omvandlas till int, och
		 * skickas som argument till metod där den identifierar vilken knapps ljud som
		 * ska spelas upp.
		 *
		 * I ReplaceAll används Regular Expression i argument parentes. Det som uttrycks
		 * i första set av citationstecken("") byts ut mot det i den andra. \\D - står
		 * för "a non digit"(ett tecken som inte är siffra) + - står för en eller flera
		 * förekomster av tecken dvs. Alla tecken som inte är siffra byts ut mot
		 * "ingenting"
		 * 
		 * Uppspelningen av ljud sköts här i pressed så att ljudet ska komma ut direkt
		 * vid nedklick, inte vid release
		 */
		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() instanceof JButton) {
				String textString = ((JButton) e.getSource()).getText();

				if (textString == "EXIT") {
					SoundHandler.stopSound(0);
					System.exit(0);

				} else {
					int isolatedInt = Integer.parseInt(textString.replaceAll("\\D+", ""));
					System.out.println(isolatedInt);

					/*
					 * Här testas om index som står för aktuell button i keysEnabled array är true.
					 * Detta gör så att det inte går att klicka på någon av knapparna om motsvarande
					 * hotkey är nedtryckt, då detta kan skapa lagg
					 */
					if (keysEnabled[isolatedInt - 1] == true) {
						SoundHandler.playSound(isolatedInt);
					}
				}
			}
		}

		/*
		 * Om crazy mode är aktiverat så spelas ljuden upp en andra gång vid release av
		 * musklick
		 */
		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			if (e.getSource() instanceof JButton && ludacriseModeEnabled == true) {
				String textString = ((JButton) e.getSource()).getText();
				int isolatedInt = Integer.parseInt(textString.replaceAll("\\D+", ""));
				
				if (isolatedInt <= 7) {
					SoundHandler.playSound(isolatedInt);
				}

			}

		}
	};

	/*
	 * Tilldelar listeners till alla buttons i button-array. Sen till resterande
	 * knappar som får varsin "skräddarsydd" instans av klassens statiska listener
	 * objekt
	 */
	public static void InitiateListeners(JButton[] buttons, JFrame frame, JRadioButton radioButton) {

		/*
		 * Frame tilldelas en instans av den egna klassen så den kan upptäcka
		 * knapptryckningar på tangentbordet. ListenerHandler extends KeyAdapter så den
		 * kan fungera som en KeyListener
		 */
		frame.addKeyListener(new ListenerHandler());

		/* Alla knappar i button-array tilldelas MouseListener, även radiobutton */
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addMouseListener(mouseListener);
		}

		radioButton.addMouseListener(mouseListener);

	}

}
