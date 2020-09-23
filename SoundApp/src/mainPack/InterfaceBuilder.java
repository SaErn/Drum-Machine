package mainPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import com.sun.glass.events.KeyEvent;

public class InterfaceBuilder extends JFrame {

	private static JFrame frame = new JFrame("Drum Machine 1.0");
	private static JPanel panelTop = new JPanel();
	private static JPanel panelCenter = new JPanel();
	private static JPanel panelBottom = new JPanel();
	private static JButton[] soundButtons = { new JButton("<html>&nbsp;&nbsp;1 <br /> HI-HAT<br />CLOSED</html>"),
			new JButton("<html>&nbsp;&nbsp;2 <br /> HI-HAT<br />&nbsp;OPEN</html>"),
			new JButton("<html>&nbsp;3 <br /> KICK <br />DRUM</html>"),
			new JButton("<html>&nbsp;4 <br /> CLAP </html>"),
			new JButton("<html>&nbsp;&nbsp;5 <br /> SNARE <br />&nbsp;ONE</html>"),
			new JButton("<html>&nbsp;&nbsp;6 <br /> SNARE <br />&nbsp;TWO</html>"),
			new JButton("<html>&nbsp;&nbsp;7 <br /> CRASH <br />CYMBAL</html>"),
			new JButton("<html>&nbsp;&nbsp;&nbsp;8 <br /> EXPLOSION <br />DELAY</html>"),
			new JButton("<html>&nbsp;&nbsp;&nbsp;9 <br /> EXPLOSION <br />REVERB</html>"), 
			new JButton("EXIT") };
	private static JLabel labelTop = new JLabel("DRUM MACHINE");
	private static JLabel labelBottom = new JLabel("Exit App --> ");
	private static ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {
				String textString = ((JButton) e.getSource()).getText();
				String clean = textString.replaceAll("\\D+", "");
				System.out.println(clean);
				SoundHandler.playSound(Integer.parseInt(clean));

			}
		}
	};

	public void setupContainers() {
		Border borderRed = BorderFactory.createLineBorder(Color.RED);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
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

	public void formatLabels() {
		labelTop.setForeground(Color.WHITE);
		labelBottom.setForeground(Color.WHITE);
		labelTop.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
		labelBottom.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));

	}

	public void setButtonArrayIndexNames() {
		for (int i = 0; i < soundButtons.length; i++) {
			soundButtons[i].setName(Integer.toString(i));
		}
	}

	public void formatButtons() {

		for (JButton button : soundButtons) {

			button.setFocusable(false);
			button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
			button.setBackground(Color.darkGray);
			button.setForeground(Color.PINK);

		}

	}

	public void addPanelsToFrame() {
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		frame.getContentPane().add(panelBottom, BorderLayout.SOUTH);
	}

	public void setHotKeys() {

		for (JButton button : soundButtons) {

			switch (Integer.parseInt(button.getName())) {
			case 0:
				button.setMnemonic(KeyEvent.VK_1);
				break;
			case 1:
				button.setMnemonic(KeyEvent.VK_2);
				break;
			case 2:
				button.setMnemonic(KeyEvent.VK_3);
				break;
			case 3:
				button.setMnemonic(KeyEvent.VK_4);
				break;
			case 4:
				button.setMnemonic(KeyEvent.VK_5);
				break;
			case 5:
				button.setMnemonic(KeyEvent.VK_6);
				break;
			case 6:
				button.setMnemonic(KeyEvent.VK_7);
				break;
			case 7:
				button.setMnemonic(KeyEvent.VK_8);
				break;
			case 8:
				button.setMnemonic(KeyEvent.VK_9);
				break;
			default:
				break;
			}
		}
	}

	public void addCompToPanels() {

		panelTop.add(labelTop, BorderLayout.CENTER);
		panelBottom.add(labelBottom);
		panelBottom.add(soundButtons[soundButtons.length - 1]);

		for (int i = 0; i < soundButtons.length - 1; i++) {

			panelCenter.add(soundButtons[i]);

		}

	}

	public void InitiateListeners() {

		soundButtons[soundButtons.length - 1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});

		for (int i = 0; i < soundButtons.length - 1; i++) {
			soundButtons[i].addActionListener(listener);

		}

	}

	public void showUi() {
		frame.setVisible(true);
	}
}
