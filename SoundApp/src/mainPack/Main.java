/* Main - Drum Machine 
 * v 1.0 
 * 2020-09-24 */
package mainPack;

public class Main {

	/* Skapar objekt ur InterfaceBuilder klassen som inneh�ller komponenter och metoder f�r att skapa, forma, och visa
	 * en interface. Objektet tar sen i sin tur hj�lp av SoundHandler och ListenerHandler klasserna f�r att ge programmet  
	 * dess funktionalitet */
	public static void main(String[] args) {
		
		InterfaceBuilder gUI = new InterfaceBuilder();
		gUI.setupContainers();
		gUI.formatLabels();
		gUI.setButtonArrayIndexNames();	
		gUI.formatButtons();
		gUI.addPanelsToFrame();
		gUI.addListenersAndHotKeys();
		gUI.addCompToPanels();
		gUI.showUi();
		
		
	}
}
