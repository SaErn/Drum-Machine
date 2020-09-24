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
	
	/*  Lagrar buttons i array s� handlingar, som ska utf�ras likadant p� alla knappar, kan g�ras 
	 *  genom repetition i for-loop. Anv�nder HTML-kod f�r att formatera strings f�r tillh�rande text.
	 *  Detta f�r att buttons inte hanterar radbrytningar bra annars. 
	 *  &nbsp; 	- St�r f�r ett blanksteg
	 *  <br />	- st�r f�r en radbrytning */
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
	
	/* Ger form, f�rg och borders till frame och dem tre panels som anv�nds i UI */
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

	/* �ndrar utseende(f�rg och font) p� texten i �vre och undre labels */
	public void formatLabels() {
		labelTop.setForeground(Color.WHITE);
		labelTop.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));

	}

	/* Ger varje enskild button(index) i button-array ett namn baserat p� siffrorna 0 - 9 som anv�nds
	 * f�r att identifiera knapp n�r mnemonic "key-bindings" ska tilldelas i ListenerHandler.setHotKeys() */
	public void setButtonArrayIndexNames() {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setName(Integer.toString(i));
		}
	}

	/* �ndrar utseende p� alla knappar och tar bort focusable s� inte distraherande markering dyker upp vid knapptryckning */
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

	/* L�gger till panels i frame p� r�tt plats */
	public void addPanelsToFrame() {
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		frame.getContentPane().add(panelBottom, BorderLayout.SOUTH);
	}

	/* Skickar array med buttons i metod-anrop till ListenerHandler klassen d�r hotkeys och 
	 * listeners tilldelas  */
	public void addListenersAndHotKeys() {

		ListenerHandler.InitiateListeners(buttons, frame, crazyModeButton);
	}

	/* L�gger till tillh�rande komponenter(buttons, labels) till respektive panel */
	public void addCompToPanels() {

		panelTop.add(labelTop, BorderLayout.CENTER);
		panelBottom.add(crazyModeButton);
		panelBottom.add(buttons[buttons.length - 1]);

		for (int i = 0; i < buttons.length - 1; i++) {

			panelCenter.add(buttons[i]);

		}
		
	}

	/* G�r UI synlig */
	public void showUi() {
		frame.setVisible(true);
	}
	
	/* G�r s� buttons "markeras/blinkar" vid nedtryckning av motsvarande hotkey */
	public static void convertKeyPressToClick(int key) {
		buttons[key-1].doClick();
	}
	
	/* Testar om JRadioButton �r "ifylld" och returnerar svaret */
	public static boolean crazyModeButtonSelected() {
		return crazyModeButton.isSelected();
	}
}
