package marsPackage;

import javax.swing.*;
import java.awt.*;

/*
 * The MarsGUI class will be the class that will get all of the other panels get
 * together and built into it.
 */

public class MarsGUI extends JFrame {
	
	private JPanel panelHolder;
	private AppLogoPanel applogo;
	private TabPanel tabpanel;
	
/*
 * Constructor
 */
	
	public MarsGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MARS 1.0");
		setSize(1000, 900);
		
		//Creating the border layout that will hold everything together.
		setLayout(new BorderLayout());
		
		// creating the panels from other classes
		 applogo = new AppLogoPanel();
		 tabpanel = new TabPanel();
		
		// Adding the components to the content pane.
		 add(applogo, BorderLayout.NORTH);
		 add(tabpanel, BorderLayout.CENTER);
		 
		pack();
		setVisible(true);
		
	}

}
