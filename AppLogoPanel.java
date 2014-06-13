package marsPackage;

import javax.swing.*;
import java.awt.*;

/*
 * The AppLogoPanel holds MARS logo in place
 */

public class AppLogoPanel extends JPanel{

	public final int LOGOHEIGHT = 227;
	public final int LOGOWIDTH = 994;
	
	private JButton testButton; //placeholder button will be replaced by logo
	
	/*
	 * Constructor
	 */
	
	public AppLogoPanel(){
		//Create a flow layout for the logo to be contained.
		setLayout(new FlowLayout());
		
		//Create button placeholder
		testButton = new JButton("LOGO SHOULD BE HERE. Will replace later!!");
		//Changing button size to be the size of the logo
		testButton.setSize(LOGOWIDTH, LOGOHEIGHT);
		
		//Add button to flow layout
		add(testButton);
	}
	
}
