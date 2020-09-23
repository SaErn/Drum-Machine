package mainPack;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfaceBuilder gUI = new InterfaceBuilder();
		gUI.setupContainers();
		gUI.formatLabels();
		gUI.setButtonArrayIndexNames();
		gUI.formatButtons();
		gUI.addPanelsToFrame();
		gUI.setHotKeys();
		gUI.addCompToPanels();
		gUI.InitiateListeners();
		gUI.showUi();
		
	
	}
	
	


}
