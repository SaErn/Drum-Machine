/* Main - Drum Machine 
 * v 1.0 
 * 2020-09-24 */
package mainPack;

public class Main {

	/* Skapar objekt ur InterfaceBuilder klassen som innehåller komponenter och metoder för att skapa, forma, och visa
	 * en interface. Objektet tar sen i sin tur hjälp av SoundHandler, InterfaceBuilder, MouseEvents, HotKeyTester och 
	 * KeybordEvents klasserna för att ge programmet dess funktionalitet */
	public static void main(String[] args) {
		
		InterfaceBuilder gUI = new InterfaceBuilder();
		gUI.setupContainers();
		gUI.formatLabels();
		gUI.formatButtons();
		gUI.addPanelsToFrame();
		gUI.addListenersAndHotKeys();
		gUI.addCompToPanels();
		gUI.showUi();
		
		
	}
}
