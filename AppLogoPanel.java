package marsPackage;

import javax.swing.*;
import java.awt.*;

/*
 * The AppLogoPanel holds MARS logo in place
 */

public class AppLogoPanel extends JPanel{

	private JButton testButton; //placeholder button will be replaced by logo
	
	/*
	 * Constructor
	 */
	
	public AppLogoPanel(){
		//Create a flow layout for the logo to be contained.
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//Create button placeholder
		testButton = new JButton("LOGO SHOULD BE HERE. Will replace later!!");
		
		//Add button to flow layout
		panel.add(testButton);
		
		//setting button size
		testButton.setPreferredSize(new Dimension(990, 227)); 
		//Logo should only be 990 x 227 if the tabbed panel can be placed on top of it.
		
		//Adding the panel
		add(panel);
	}
	
}
