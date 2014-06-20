package marsPackage;

import java.awt.*;

import javax.swing.*;

public class MarsMain extends JFrame {

	private JPanel panelHolder;
	private AppLogoPanel applogo;
	private TabPanel tabpanel;
	private GridBagConstraints gbc;
	
	
	public MarsMain(){
		
		//Setting up the JFrame
		setTitle("MARS 1.0");
		setPreferredSize(new Dimension(1000, 900));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creating the panel holder
		panelHolder = new JPanel();
		panelHolder.setBackground(Color.WHITE);
		add(panelHolder);
		
		//adding Application logo panel to panelHolder
		applogo = new AppLogoPanel();
		panelHolder.add(applogo);

		//adding the tabpanel panel to the panelHolder
		tabpanel = new TabPanel();
		panelHolder.add(tabpanel);
	 
		pack();
	}
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarsMain frame = new MarsMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
