/* Interface Builder 
 * v 1.0 
 * 2020-09-24 */
package mainPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InterfaceBuilder extends JFrame {
	
	/*  Lagrar buttons i array så handlingar, som ska utföras likadant på alla knappar, kan göras 
	 *  genom repetition i for-loop. Använder HTML-kod för att formatera strings för tillhörande text.
	 *  Detta för att buttons inte hanterar radbrytningar bra annars. 
	 *  &nbsp; 	- Står för ett blanksteg
	 *  <br />	- står för en radbrytning */
	private static JButton[] buttons = { new JButton("<html>&nbsp;&nbsp;1 <br /> HI-HAT<br />CLOSED</html>"),
			new JButton("<html>&nbsp;&nbsp;2 <br /> HI-HAT<br />&nbsp;OPEN</html>"),
			new JButton("<html>&nbsp;3 <br /> KICK <br />DRUM</html>"),						
			new JButton("<html>&nbsp;4 <br /> CLAP </html>"),								
			new JButton("<html>&nbsp;&nbsp;5 <br /> SNARE <br />&nbsp;ONE</html>"),		
			new JButton("<html>&nbsp;&nbsp;6 <br /> SNARE <br />&nbsp;TWO</html>"),
			new JButton("<html>&nbsp;&nbsp;7 <br /> CRASH <br />CYMBAL</html>"),
			new JButton("<html>&nbsp;&nbsp;&nbsp;8 <br /> EXPLOSION <br />DELAY</html>"),
			new JButton("<html>&nbsp;&nbsp;&nbsp;9 <br /> EXPLOSION <br />REVERB</html>"), 
			new JButton("EXIT")};
	private static JRadioButton crazyModeButton = new JRadioButton("Crazy Mode(enable/disable)");
	private static JFrame frame = new JFrame("Drum Machine 1.0");
	private static JPanel panelTop = new JPanel();				
	private static JPanel panelCenter = new JPanel();
	private static JPanel panelBottom = new JPanel();
	private static JLabel labelTop = new JLabel("DRUM MACHINE");
	
	/* Ger form, färg och borders till frame och dem tre panels som används i UI */
	public void setupContainers() {
		Border borderRed = BorderFactory.createLineBorder(Color.RED);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		frame.getRootPane().setBorder(borderRed);

		panelTop.setSize(300, 100);
		panelTop.setBackground(Color.BLACK);
		panelTop.setBorder(borderRed);
		
		panelCenter.setSize(300, 100);
		panelCenter.setBackground(Color.WHITE);
		panelCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCenter.setLayout(new GridLayout(3, 3));
		
		panelBottom.setSize(300, 100);
		panelBottom.setBackground(Color.BLACK);
		panelBottom.setBorder(borderRed);

	}

	/* Ändrar utseende(färg och font) på texten i övre och undre labels */
	public void formatLabels() {
		labelTop.setForeground(Color.WHITE);
		labelTop.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));

	}

	/* Ger varje enskild button(index) i button-array ett namn baserat på siffrorna 0 - 9 som används
	 * för att identifiera knapp när mnemonic "key-bindings" ska tilldelas i ListenerHandler.setHotKeys() */
	public void setButtonArrayIndexNames() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setName(Integer.toString(i));
		}
	}

	/* Ändrar utseende på alla knappar och tar bort focusable så inte distraherande markering dyker upp vid knapptryckning */
	public void formatButtons() {

		for (JButton button : buttons) {

			button.setFocusable(false);
			button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
			button.setBackground(Color.darkGray);
			button.setForeground(Color.PINK);
		}
		
		crazyModeButton.setFocusable(false);
		//crazyModeButton.setFont(Font.MONOSPACED, Font.BOLD, 14);
		crazyModeButton.setBackground(Color.black);
		crazyModeButton.setForeground(Color.white);
	}

	/* Lägger till panels i frame på rätt plats */
	public void addPanelsToFrame() {
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		frame.getContentPane().add(panelBottom, BorderLayout.SOUTH);
	}

	/* Skickar array med buttons i metod-anrop till ListenerHandler klassen där hotkeys och 
	 * listeners tilldelas  */
	public void addListenersAndHotKeys() {

		ListenerHandler.InitiateListeners(buttons, frame, crazyModeButton);
	}

	/* Lägger till tillhörande komponenter(buttons, labels) till respektive panel */
	public void addCompToPanels() {

		panelTop.add(labelTop, BorderLayout.CENTER);
		panelBottom.add(crazyModeButton);
		panelBottom.add(buttons[buttons.length - 1]);

		for (int i = 0; i < buttons.length - 1; i++) {

			panelCenter.add(buttons[i]);

		}
		
	}

	/* Gör UI synlig */
	public void showUi() {
		frame.setVisible(true);
	}
	
	/* Gör så buttons "markeras/blinkar" vid nedtryckning av motsvarande hotkey */
	public static void convertKeyPressToClick(int key) {
		buttons[key-1].doClick();
	}
	
	/* Testar om JRadioButton är "ifylld" och returnerar svaret */
	public static boolean crazyModeButtonSelected() {
		return crazyModeButton.isSelected();
	}
}
