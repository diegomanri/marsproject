package marsPackage;

import javax.swing.*;

import java.awt.*;

/*
 * The AppLogoPanel holds MARS logo in place
 */

public class AppLogoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6705480536789390858L;
	private JLabel logoHolder; //placeholder button will be replaced by logo
	private ImageIcon logo;
	private JPanel panel;
	/*
	 * Constructor
	 */
	
	public AppLogoPanel(){
		//Create a flow layout for the logo to be contained.
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new FlowLayout());
		
		//Getting the logo into the GUI
		logo = new ImageIcon(getClass().getResource("/logo.png"));
		
		//Create the label and get the logo in there
		//logoHolder = new JLabel(null, logo, JLabel.CENTER);
		logoHolder = new JLabel(logo);
		panel.add(logoHolder);
		logoHolder.setPreferredSize(new Dimension(1000, 300)); 
		
		//Adding the panel
		add(panel);
	}
}
